package istic.taa.project.dao;

import java.util.List;

import istic.taa.project.dao.IGenericDao;
import istic.taa.project.model.FavouriteActivity;

public interface IFavouriteActivityDao extends IGenericDao<FavouriteActivity> {
	public List<FavouriteActivity> getFavouriteActivities(long id);
}
