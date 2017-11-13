package istic.taa.project.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import istic.taa.project.dao.ILocationDao;
import istic.taa.project.helpers.EntityManagerHelper;
import istic.taa.project.model.Location;
import istic.taa.project.model.User;
import istic.taa.project.utils.EncodingUtils;

@Component
public class LocationDaoImpl extends GenericDaoImpl<Location> implements ILocationDao {

	private static final String QUERY = "From Location location ";

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findAll() {
		Query query = EntityManagerHelper.createHqlQuery(QUERY);
		return  query.getResultList();
		
}
