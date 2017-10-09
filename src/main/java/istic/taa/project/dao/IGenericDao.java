package istic.taa.project.dao;

public interface IGenericDao<T> {
	public void create(T obj);

	public void deleteById(Class<T> clazz, long id);

	public T findById(Class<T> clazz, long id);

	public void update(T obj);
}
