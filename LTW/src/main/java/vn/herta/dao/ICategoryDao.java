package vn.herta.dao;

import java.util.List;
import vn.herta.models.CategoryModel;
public interface ICategoryDao {
	List<CategoryModel> findAll();
	List<CategoryModel> findName(String keyword);
	CategoryModel findById(int id);
	CategoryModel find(String name);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);


}
