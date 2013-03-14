package fr.company.demo.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJpaDAO<T extends Serializable> {

	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T find(final Integer id) {
		return this.entityManager.find(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery("from " + this.clazz.getName())
				.getResultList();
	}

	public void save(final T entity) {
		this.entityManager.persist(entity);
	}

	public void update(final T entity) {
		this.entityManager.merge(entity);
	}

	public void delete(final T entity) {
		this.entityManager.remove(entity);
	}

	public void deleteById(final Integer entityId) {
		final T entity = find(entityId);
		delete(entity);
	}
}