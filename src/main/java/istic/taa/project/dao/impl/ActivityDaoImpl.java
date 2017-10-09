package istic.taa.project.dao.impl;

import istic.taa.project.dao.IActivityDao;
import istic.taa.project.dao.impl.GenericDaoImpl;
import istic.taa.project.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityDaoImpl extends GenericDaoImpl<Activity> implements IActivityDao {
}
