package vn.herta.dao;

import java.util.List;


import vn.herta.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);




	
	
}
