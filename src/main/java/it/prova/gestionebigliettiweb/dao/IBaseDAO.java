package it.prova.gestionebigliettiweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IBaseDAO<T> {
	
	public List<T> list() throws Exception;

	public T findOne(Long id) throws Exception;

	public void update(T input) throws Exception;

	public void insert(T input) throws Exception;

	public void delete(T input) throws Exception;

	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);

}
