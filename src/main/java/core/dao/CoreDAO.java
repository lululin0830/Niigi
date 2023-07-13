package core.dao;

import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;

public interface CoreDAO<E, I> {

	Boolean insert(E entity);

	E getByPrimarryKey(I id);

	List<E> getAll();
	
	default Session getSession() {
		  return HibernateUtil.getSessionFactory().getCurrentSession();
		 }
}
