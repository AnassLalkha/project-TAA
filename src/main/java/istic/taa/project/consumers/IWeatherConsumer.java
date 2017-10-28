package istic.taa.project.consumers;

import java.util.List;

import istic.taa.project.model.Weather;

public interface IWeatherConsumer {
	public void updateWeather(String location, String mode, Integer days);
	public List<Weather> getWeather();
}
