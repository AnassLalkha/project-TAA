package istic.taa.project.dao;

import java.util.List;

import istic.taa.project.dao.IGenericDao;
import istic.taa.project.model.FavouriteLocation;

public interface IFavouriteLocationDao extends IGenericDao<FavouriteLocation> {
	public List<FavouriteLocation> getFavouriteLocations(long id);
}
