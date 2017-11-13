package istic.taa.project.dao;

import java.util.List;

import istic.taa.project.model.AdequateActivitiesWeather;

public interface IAdequateActivityWeather extends IGenericDao<AdequateActivitiesWeather> {
	public List<AdequateActivitiesWeather> getByParameter(double t, double w, double p, double h, String title);
}
