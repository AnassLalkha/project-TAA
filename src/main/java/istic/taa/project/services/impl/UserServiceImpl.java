package istic.taa.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import istic.taa.project.constants.Operations;
import istic.taa.project.dao.IFavouriteActivityDao;
import istic.taa.project.dao.IFavouriteLocationDao;
import istic.taa.project.dao.IUserDao;
import istic.taa.project.model.Activity;
import istic.taa.project.model.FavouriteLocation;
import istic.taa.project.model.InvalidTokens;
import istic.taa.project.model.User;
import istic.taa.project.services.ITokenService;
import istic.taa.project.services.IUserService;
import istic.taa.project.utils.UserFactory;
import istic.taa.project.wrappers.GenericWrapper;
import istic.taa.project.wrappers.UserWrapper;

@Component
public class UserServiceImpl implements IUserService, UserDetailsService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFavouriteActivityDao activityDao;
	@Autowired
	private IFavouriteLocationDao locationDao;
	@Autowired
	private ITokenService tokenService;

	@Override
	public List<FavouriteLocation> getFavouriteLocations(String username, String email) {
		User user = userDao.getUserByMailAndUsername(username, email);
		if (user != null) {
			return locationDao.getFavouriteLocations(user.getIdentifier());
		}
		return new ArrayList<>();
	}

	@Override
	public List<Activity> getFavouriteActivities(String username, String email) {
		User user = userDao.getUserByMailAndUsername(username, email);
		if (user != null) {
			return activityDao.getFavouriteActivities(user.getIdentifier());
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
		try {
			userDao.create(u);
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

}
