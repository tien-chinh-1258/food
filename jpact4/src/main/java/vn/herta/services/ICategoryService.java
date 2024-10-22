package vn.herta.services;

import java.util.List;

import vn.herta.entity.Category;


public interface ICategoryService {
		 
	 int count();

	 List<Category> findAll(int page, int pagesize);

	 List<Category> searchByName(String catname);

	 List<Category> findAll();
	 
	 Category findByCategoryname(String name);

	 Category findById(int cateid);

	 void delete(int cateid) throws Exception;

	 void update(Category category);
	 
	 void insert(Category category);

	

	}


