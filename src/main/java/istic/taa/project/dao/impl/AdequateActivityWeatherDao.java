package istic.taa.project.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.IAdequateActivityWeather;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.AdequateActivitiesWeather;

@Component
public class AdequateActivityWeatherDao extends GenericDaoImpl<AdequateActivitiesWeather>
		implements IAdequateActivityWeather {

	private static final String QUERY = "FROM AdequateActivitiesWeather ad where (UPPER(ad.title) like UPPER(%:title%) || (ad.minTemperature <=:t && ad.maxTemperture >= :t && ad.minWindCondition <= :w && ad.maxWindCondition >= :w && ad.maxPluviometry >= :p && ad.minPluviometry<= :p && ad.maxHumidity >= :h && ad.minHumidity <= :h";

	@SuppressWarnings("unchecked")
	@Override
	public List<AdequateActivitiesWeather> getByParameter(double t, double w, double p, double h, String title) {
		Query query = EntityManagerHelper.createHqlQuery(QUERY);
		query.setParameter("title", title);
		query.setParameter("t", t);
		query.setParameter("w", w);
		query.setParameter("p", p);
		query.setParameter("h", h);

		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return null;
	}

}
