package istic.taa.project.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IFavouriteLocationDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.FavouriteLocation;

@Component
public class FavouriteLocationDaoImpl extends GenericDaoImpl<FavouriteLocation> implements IFavouriteLocationDao {

	private static final String GET_FAVOURITE_LOCATION_QUERY = "from FavouriteLocation favouriteLocation join favouriteLocation.user u  where u.identifier= :id";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FavouriteLocation>  getFavouriteLocations(long id) {
		Query query = EntityManagerHelper.createHqlQuery(GET_FAVOURITE_LOCATION_QUERY);
		query.setParameter("id", id);
		if (!query.getResultList().isEmpty() && query.getResultList().get(0).getClass() == FavouriteLocation.class) {
			return query.getResultList();
		}
	
		return new ArrayList<>();
	}
}
