package istic.taa.project.dao.impl;

import istic.taa.project.dao.IGenericDao;
import istic.taa.project.helpers.EntityManagerHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericDaoImpl<T> implements IGenericDao<T> {
	protected static final Logger LOG = Logger.getLogger(GenericDaoImpl.class);

	public void create(T obj) {
		EntityManagerHelper.beginTransaction();
		try {
			EntityManagerHelper.getEntityManager().persist(obj);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			LOG.error((Object) "An error occured when trying to persist obj {}", e);
		}
	}

	public void deleteById(Class<T> clazz, long id) {
		T obj = this.findById(clazz, id);
		if (obj != null) {
			EntityManagerHelper.getEntityManager().remove(obj);
		} else {
			LOG.debug((Object) "Trying to delete null object");
		}
	}

	public T findById(Class<T> clazz, long id) {
		return EntityManagerHelper.getEntityManager().find(clazz, (Object) id);
	}

	public void update(T obj) {
		EntityManagerHelper.beginTransaction();
		try {
			EntityManagerHelper.getEntityManager().merge(obj);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			LOG.error((Object) "An error occured when trying to persist obj ", e);
		}

	}
}
