package core.dao;

import java.util.List;

import org.hibernate.Session;

import core.util.HibernateUtil;

public interface CoreDAO<E, I> {

	Boolean insert(E entity)throws Exception;

	E selectById(I id)throws Exception;

	List<E> getAll()throws Exception;

	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
