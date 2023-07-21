package user.service.impl;

import java.util.List;

import user.dao.UserDAO;
import user.dao.impl.UserDAOImpl;
import user.entity.User;
import user.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	@Override
	public User register(User user) {
		if(user.getUserName() == null) {
			user.setMessage("使用者名稱未輸入");
			user.setSuccessful(false);
			return user;
		}
		if(user.getUserAcct() == null) {
			user.setMessage("使用者帳號未輸入");
			user.setSuccessful(false);
			return user;
		}
		if(user.getPassword() == null) {
			user.setMessage("密碼未輸入");
			user.setSuccessful(false);
			return user;
		}
		if(dao.selectByUserAcct(user.getUserAcct()) != null) {
			user.setMarketingAuthority("帳號重複");
			user.setSuccessful(false);
			return user;
		}
		user.setSuccessful(true);
		return user;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User edit(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
