package vn.herta.services;

import java.util.List;

import vn.herta.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	List<CategoryModel> findName(String keyword);
	CategoryModel findById(int id);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);

}
