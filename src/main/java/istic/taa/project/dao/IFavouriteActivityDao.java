package istic.taa.project.dao;

import java.util.List;

import istic.taa.project.model.Activity;
import istic.taa.project.model.FavouriteActivity;

public interface IFavouriteActivityDao extends IGenericDao<FavouriteActivity> {
	public List<Activity> getFavouriteActivities(long id);
}
