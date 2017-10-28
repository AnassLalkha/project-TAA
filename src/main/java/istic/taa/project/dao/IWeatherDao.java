package istic.taa.project.dao;

import istic.taa.project.model.Weather;

public interface IWeatherDao extends IGenericDao<Weather>{
	public Weather findByLocation(String location);
}
