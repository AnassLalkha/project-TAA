package istic.taa.project.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IWeatherDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.Weather;

@Component
public class WeatherDaoImpl extends GenericDaoImpl<Weather> implements IWeatherDao {
	public static final String QUERY_FIND_BY_LOCATION = "FROM Weather weather where weather.location = :loc";

	@Override
	public Weather findByLocation(long id) {
		Query query = EntityManagerHelper.createHqlQuery(QUERY_FIND_BY_LOCATION);
		query.setParameter("loc", id);

		if (!query.getResultList().isEmpty()) {
			return (Weather) query.getResultList().get(0);
		}
		return null;
	}

}
