package istic.taa.project.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import istic.taa.project.dao.IGenericDao;
import istic.taa.project.exceptions.TechnicalException;
import istic.taa.project.helpers.EntityManagerHelper;

@Component
public abstract class GenericDaoImpl<T> implements IGenericDao<T> {
	protected static final Logger LOG = Logger.getLogger(GenericDaoImpl.class);

	@Override
	public void create(T obj) {
		EntityManagerHelper.beginTransaction();
		try {
			EntityManagerHelper.getEntityManager().persist(obj);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			LOG.error("An error occured when trying to persist obj {}", e);
			throw new TechnicalException("An internal error occured when trying to create the object", e);
		}
	}

	@Override
	public void deleteById(Class<T> clazz, long id) {
		T obj = this.findById(clazz, id);
		if (obj != null) {
			EntityManagerHelper.getEntityManager().remove(obj);
		} else {
			LOG.debug("Trying to delete null object");
		}
	}

	@Override
	public T findById(Class<T> clazz, long id) {
		return EntityManagerHelper.getEntityManager().find(clazz, (Object) id);
	}

	@Override
	public void update(T obj) {
		EntityManagerHelper.beginTransaction();
		try {
			EntityManagerHelper.getEntityManager().merge(obj);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			LOG.error("An error occured when trying to persist obj ", e);
		}

	}
}
