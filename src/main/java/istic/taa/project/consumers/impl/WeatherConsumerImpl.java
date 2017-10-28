package istic.taa.project.consumers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import istic.taa.project.constants.Constants;
import istic.taa.project.consumers.IWeatherConsumer;
import istic.taa.project.dao.IWeatherDao;
import istic.taa.project.helpers.HTTPHelper;
import istic.taa.project.helpers.ParserHelper;
import istic.taa.project.model.Weather;

@Component
public class WeatherConsumerImpl implements IWeatherConsumer {
	@Autowired
	private IWeatherDao weatherDao;

	private HTTPHelper httpHelper = HTTPHelper.getInstance();
	private ParserHelper parserHelper = ParserHelper.getInstance();
	private List<Weather> weathers = new ArrayList<>();

	@Override
	public List<Weather> getWeather() {
		return weathers;
	}


	@Override
	public void updateWeather(String location, String mode, Integer days) {

		String result = httpHelper.get(buildEndpoint(location, mode, days));
		if (days == null) {
			Weather weather = new Weather();
			weather = parserHelper.fromStrToObj(result, weather.getClass());
			weathers.add(weather);
		} else {
			weathers = parserHelper.fromStrToObj(result, new TypeReference<List<Weather>>() {
			});
		}
		saveWeather();
	}

	private String buildEndpoint(String location, String mode, Integer days) {
		String result = Constants.WEATHER_ENDPOINT.replace(Constants.LOCATION_PARAMETER, location)
				.replace(Constants.APPID_PARAMETER, Constants.WEATHER_API_KEY).replace(Constants.MODE_PARAMETER, mode);
		if (days != null && days > 0 && mode.equals(Constants.WEATHER_MODE_FORECAST)) {
			result = new StringBuilder(result)
					.append(Constants.WEATHER_ENDPOINT_DAYS.replace(Constants.DAYS_PARAMETER, days.toString()))
					.toString();
		}
		return result;

	}

	private void saveWeather() {
			weathers.stream().forEach ( w -> {
				weatherDao.create(w);
			});
	}

}
