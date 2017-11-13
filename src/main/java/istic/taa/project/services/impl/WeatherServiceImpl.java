package istic.taa.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import istic.taa.project.constants.Constants;
import istic.taa.project.constants.Operations;
import istic.taa.project.consumers.IWeatherConsumer;
import istic.taa.project.dao.ILocationDao;
import istic.taa.project.dao.IWeatherDao;
import istic.taa.project.model.Weather;
import istic.taa.project.services.IWeatherService;
import istic.taa.project.wrappers.GenericWrapper;
import istic.taa.project.wrappers.WeatherWrapper;

@Component
public class WeatherServiceImpl implements IWeatherService {

	@Autowired
	private IWeatherConsumer weatherConsumer;
	@Autowired
	private IWeatherDao weatherDao;
	@Autowired
	private ILocationDao locationDao;

	@Override
	public List<Weather> getForcastWeatherByLocation(String location, Integer days) {
		weatherConsumer.updateWeather(location, Constants.WEATHER_MODE_FORECAST, days);
		return weatherConsumer.getWeather();

	}

	@Override
	public WeatherWrapper getCurrentWeatherByLocation(String location) {
		String status = "ok";
		try {
			weatherConsumer.updateWeather(location, Constants.WEATHER_MODE_CURRENT, null);
		} catch (Exception e) {
			status = "ko";
		}
		return new WeatherWrapper(Operations.CURRENT_WEATHER, status, weatherConsumer.getWeather());

	}

	@Override
	public GenericWrapper updateWeather(String location, Integer days) {
		try {
			weatherConsumer.updateWeather(location, Constants.WEATHER_MODE_FORECAST, days);
		} catch (Exception e) {
			return new GenericWrapper(Operations.UPDATE_WEATHER.toString(), "ko");
		}
		return new GenericWrapper(Operations.UPDATE_WEATHER.toString(), "ko");

	}

	@Override
	public void updatewkndWeatherForAllLocation() {
		locationDao.findAll().stream().forEach(l -> {
			List<Weather> list = getForcastWeatherByLocation(l.getName(), 5);
			if (list.size() >= 4) {
				weatherDao.create(list.get(4));
			}
		});

	}

}
