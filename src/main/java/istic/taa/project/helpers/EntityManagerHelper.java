package istic.taa.project.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityManagerHelper {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

	private EntityManagerHelper() {
	}

	public static EntityManager getEntityManager() {
		EntityManager em = threadLocal.get();
		if (em == null) {
			em = emf.createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}

	public static void closeEntityManager() {
		EntityManager em = threadLocal.get();
		if (em != null) {
			em.close();
			threadLocal.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		emf.close();
	}

	public static void beginTransaction() {
		EntityManagerHelper.getEntityManager().getTransaction().begin();
	}

	public static void rollback() {
		EntityManagerHelper.getEntityManager().getTransaction().rollback();
	}

	public static void commit() {
		EntityManagerHelper.getEntityManager().getTransaction().commit();
	}

	public static Query createHqlQuery(String q) {
		return EntityManagerHelper.getEntityManager().createQuery(q);
	}

	public static void close() {
		getEntityManager().close();
		threadLocal.set(null);
	}
}
