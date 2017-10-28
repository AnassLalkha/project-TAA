package istic.taa.project.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import istic.taa.project.model.Weather;
import istic.taa.project.services.IWeatherService;
import istic.taa.project.wrappers.WeatherWrapper;

@RestController
public class WeatherController {

	@Autowired
	private IWeatherService weatherService;

	@RequestMapping("/interface/v1/update-weather")
	public void updateWeather(@RequestBody Weather weather) throws IOException {
	}
	
	@RequestMapping("/interface/v1/request-current-weather")
	public WeatherWrapper getCurrentWeather(@RequestParam String location) {
		return weatherService.getCurrentWeatherByLocation(location);
	}
}
