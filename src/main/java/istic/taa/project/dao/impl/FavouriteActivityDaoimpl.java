package istic.taa.project.dao.impl;

import istic.taa.project.dao.IFavouriteActivityDao;
import istic.taa.project.dao.impl.GenericDaoImpl;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.FavouriteActivity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class FavouriteActivityDaoimpl extends GenericDaoImpl<FavouriteActivity> implements IFavouriteActivityDao {
	private static final String GET_FAVOURITE_ACTIVITIES_BY_ID_QUERY = "FROM FavouriteActivity favouriteActivity join favouriteActivity.user u WHERE u.identifier = :id";

	@SuppressWarnings("unchecked")
	@Override
	public List<FavouriteActivity> getFavouriteActivities(long id) {
		Query query = EntityManagerHelper.createHqlQuery(GET_FAVOURITE_ACTIVITIES_BY_ID_QUERY);
		query.setParameter("id", id);
		if (!query.getResultList().isEmpty() && query.getResultList().get(0).getClass() == FavouriteActivity.class) {
			return query.getResultList();
		}
		return new ArrayList<>();
	}

}
