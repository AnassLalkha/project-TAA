package istic.taa.project.dao.impl;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IWeatherDao;
import istic.taa.project.model.Weather;

@Component
public class WeatherDaoImpl extends GenericDaoImpl<Weather> implements IWeatherDao {
	public static final String QUERY_FIND_BY_LOCATION = "FROM Weather weather where location = :loc";

	@Override
	public Weather findByLocation(String location) {
		return null;
	}

}
