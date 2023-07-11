package user.dao;

import java.util.List;



import user.entity.User;

public interface UserDAO {
	public void insert(User user);

	// 更新一個權限，換四個權限
	public void updatePermissions(User user);
	//更新密碼
	public void updatePassword(User user);

	public void delete(Integer userId);

	public User findByPrimaryKey(Integer userId);

	public List<User> getAll();
}
