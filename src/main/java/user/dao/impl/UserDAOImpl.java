package user.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import user.dao.UserDAO;
import user.entity.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public Boolean insert(User entity) throws Exception {
		getSession().persist(entity);
		return true;
	}

	@Override
	public User selectById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByUserAcct(String userAcct) {
		Session session = getSession();
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = cBuilder.createQuery(User.class);
		// from User
		Root<User> root = cQuery.from(User.class);
		
		//where UserAcct=?
		cQuery.where(cBuilder.equal(root.get("userAcct"), userAcct));
		// select *
		return session.createQuery(cQuery).uniqueResult();
	}

	@Override
	public User selectForLogin(String userAcct, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
