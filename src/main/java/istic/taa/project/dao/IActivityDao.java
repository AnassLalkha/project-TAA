package istic.taa.project.dao;

import java.util.List;

import istic.taa.project.model.Activity;

public interface IActivityDao extends IGenericDao<Activity> {
	List<Activity> getActivitieByAdequateWeather(long id);
}
