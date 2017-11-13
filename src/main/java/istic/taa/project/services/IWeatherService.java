package istic.taa.project.services;

import java.util.List;

import istic.taa.project.model.Weather;
import istic.taa.project.wrappers.GenericWrapper;
import istic.taa.project.wrappers.WeatherWrapper;

public interface IWeatherService {
	public List<Weather> getForcastWeatherByLocation(String location, Integer days);

	public WeatherWrapper getCurrentWeatherByLocation(String location);

	public GenericWrapper updateWeather(String location, Integer days);

	public void updatewkndWeatherForAllLocation();

}
