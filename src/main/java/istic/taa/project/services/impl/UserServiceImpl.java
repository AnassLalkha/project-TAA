package istic.taa.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import istic.taa.project.constants.Operations;
import istic.taa.project.dao.IActivityDao;
import istic.taa.project.dao.IFavouriteActivityDao;
import istic.taa.project.dao.IFavouriteLocationDao;
import istic.taa.project.dao.IUserDao;
import istic.taa.project.dao.IWeatherDao;
import istic.taa.project.dao.impl.AdequateActivityWeatherDao;
import istic.taa.project.model.Activity;
import istic.taa.project.model.AdequateActivitiesWeather;
import istic.taa.project.model.FavouriteActivity;
import istic.taa.project.model.FavouriteLocation;
import istic.taa.project.model.InvalidTokens;
import istic.taa.project.model.Message;
import istic.taa.project.model.User;
import istic.taa.project.model.Weather;
import istic.taa.project.services.INotificationService;
import istic.taa.project.services.ITokenService;
import istic.taa.project.services.IUserService;
import istic.taa.project.utils.RandomUtils;
import istic.taa.project.utils.UserFactory;
import istic.taa.project.wrappers.GenericWrapper;
import istic.taa.project.wrappers.UserWrapper;

@Component
public class UserServiceImpl implements IUserService, UserDetailsService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFavouriteActivityDao favActivityDao;
	@Autowired
	private IFavouriteLocationDao locationDao;
	@Autowired
	private ITokenService tokenService;
	@Autowired
	private AdequateActivityWeatherDao aaWeather;
	@Autowired
	private IActivityDao activityDao;
	@Autowired
	private IWeatherDao weatherDao;
	@Autowired
	private INotificationService notificationService;

	@Override
	public List<FavouriteLocation> getFavouriteLocations(String username, String email) {
		User user = userDao.getUserByMailAndUsername(username, email);
		if (user != null) {
			return locationDao.getFavouriteLocations(user.getIdentifier());
		}
		return new ArrayList<>();
	}

	@Override
	public List<FavouriteActivity> getFavouriteActivities(String username, String email) {
		User user = userDao.getUserByMailAndUsername(username, email);
		if (user != null) {
			return favActivityDao.getFavouriteActivities(user.getIdentifier());
		}
		return new ArrayList<>();
	}

	@Override
	public UserWrapper authenticate(String username, String pwd) {
		User u = this.userDao.getUserByCredential(username, pwd);
		String status = (u == null) ? "ko" : "ok";
		return new UserWrapper(u, Operations.AUTHENTICATION, status);
	}

	@Override
	public UserWrapper create(String username, String password, String mail) {
		User u = new User(username, password, mail);
		u.setValidationCode(RandomUtils.generateRandom());
		try {
			userDao.create(u);
			Message message = new Message(u, "c");
			notificationService.sendMessage(message);
		} catch (Exception e) {
			u = null;
		}
		String status = (u == null) ? "ko" : "ok";
		return new UserWrapper(u, Operations.CREATE_USER, status);
	}

	@Override
	public GenericWrapper requestDeletion(String username, String mail) {
		User u = userDao.getUserByMailAndUsername(username, mail);
		String status = "ko";
		if (u != null) {
			boolean result = userDao.updateDeletionCode(u);
			if (result) {
				status = "ok";
				Message message = new Message(u, "d");
				notificationService.sendMessage(message);
			}
		}
		return new GenericWrapper(Operations.REQUEST_DELETION.toString(), status);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userDao.findUserByUsername(username);
		return ((u == null) ? null : UserFactory.create(u));
	}

	@Override
	public GenericWrapper logout(String username) {
		InvalidTokens t = tokenService.findTokenByUser(username);
		String status = "ok";
		if (t == null) {
			status = "ko";
		}
		return new GenericWrapper(Operations.LOGOUT.toString(), status);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findUserByUsername(username);

	}

	@Override
	public List<Activity> generateActivityByWeather(String username) {
		// firstable get the user favourite activities
		User u = this.findByUsername(username);
		if (u != null) {
			List<Activity> fullResult = new ArrayList<>();
			// should determine the favourite location
			List<FavouriteLocation> fl = u.getFavouriteLocations();
			fl.stream().forEach(l -> {
				Weather weather = weatherDao.findByLocation(l.getIdentifier());
				fullResult.addAll(getActivityMatchingToWeather(getActivitieByWeather(weather)));
			});
			return fullResult;
		}
		return new ArrayList<>();
	}

	private List<Activity> getActivityMatchingToWeather(List<AdequateActivitiesWeather> aaw) {
		List<Activity> result = new ArrayList<>();
		aaw.stream().forEach(a -> {
			result.addAll(this.activityDao.getActivitieByAdequateWeather(a.getIdentifier()));
		});
		return result;
	}

	private List<AdequateActivitiesWeather> getActivitieByWeather(Weather weather) {
		// construct the props
		double t = weather.getCurrent().getTemperature();
		double w = weather.getCurrent().getWindSpeed();
		double p = weather.getCurrent().getPrecipitation();
		double h = weather.getCurrent().getHumidity();
		String title = weather.getCurrent().getCondition().getDesc();
		return ((aaWeather.getByParameter(t, w, p, h, title) == null) ? new ArrayList<>()
				: aaWeather.getByParameter(t, w, p, h, title));
	}

	@Override
	public GenericWrapper validateMail(String param) {
		User u = userDao.findUserByValidationCode(param);
		String status = "Unable to validate your mail";
		if (u != null) {
			u.setValidatedMail(true);
			userDao.update(u);
			status = "Your mail have been validated";
		}
		GenericWrapper w = new GenericWrapper(Operations.VALIDATE_MAIL.toString(), status);
		return w;
	}

}
