package istic.taa.project;

import istic.taa.project.consumers.impl.WeatherConsumerImpl;

public class JpaTest {
	public static void main(String[] args) {
		WeatherConsumerImpl w = new WeatherConsumerImpl();
		w.updateWeather("paris", "current", null);

	}
}
