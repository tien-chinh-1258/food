package vn.herta.services.impl;

import vn.herta.dao.IUserDao;
import vn.herta.dao.impl.UserDaoImpl;
import vn.herta.models.UserModel;
import vn.herta.services.IUserService;

public class UserService implements IUserService {
	IUserDao userDao= new UserDaoImpl();  // lay toan bo ham trong Dao cua user

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user !=null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUserName(username);
	}

}
