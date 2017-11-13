package istic.taa.project.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IActivityDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.Activity;

@Component
public class ActivityDaoImpl extends GenericDaoImpl<Activity> implements IActivityDao {
	public static final String QUERY = "FROM Activity a where a.adequateWeather :id";

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getActivitieByAdequateWeather(long id) {
		Query query = EntityManagerHelper.createHqlQuery(QUERY);
		query.setParameter("id", id);

		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return new ArrayList<>();
	}
}
