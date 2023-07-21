package user.service;

import java.util.List;

import core.service.CoreService;
import user.entity.User;

public interface UserService extends CoreService{
	
	User register(User user);
	
	User login(User user);
	
	User edit(User user);
	
	List<User> findAll();
	
	boolean remove(Integer userId);
	
	boolean save(User user);
}
