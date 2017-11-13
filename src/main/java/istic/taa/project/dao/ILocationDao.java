package istic.taa.project.dao;

import java.util.List;

import istic.taa.project.model.Location;

public interface ILocationDao extends IGenericDao<Location> {
	public List<Location> findAll();
}
