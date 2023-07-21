package user.dao;

import core.dao.CoreDAO;
import user.entity.User;

public interface UserDAO extends CoreDAO<User, String> {
	// 萬用更新
	public User update(User newUser);

	// 刪除
	public User delete(Integer userId);

	// 找名稱
	public User selectByUserName(String userName);

	// 找帳號
	public User selectByUserAcct(String userAcct);

	// 登入
	public User selectForLogin(String userAcct, String password);

}
