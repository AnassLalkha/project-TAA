package istic.taa.project.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IFavouriteActivityDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.Activity;
import istic.taa.project.model.FavouriteActivity;

@Component
public class FavouriteActivityDaoimpl extends GenericDaoImpl<FavouriteActivity> implements IFavouriteActivityDao {
	private static final String GET_FAVOURITE_ACTIVITIES_BY_ID_QUERY = "SELECT favouriteActivity.activity FROM FavouriteActivity favouriteActivity join favouriteActivity.user u WHERE u.identifier = :id";

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getFavouriteActivities(long id) {
		Query query = EntityManagerHelper.createHqlQuery(GET_FAVOURITE_ACTIVITIES_BY_ID_QUERY);
		query.setParameter("id", id);
		if (!query.getResultList().isEmpty()) {
			List<Activity> list = query.getResultList();
			return list;
		}
		return new ArrayList<>();
	}

}
