package vn.herta.dao;

import java.util.List;
import vn.herta.models.CategoryModel;
//Lấy tất cả các danh mục
public interface ICategoryDao {
	List<CategoryModel> findAll();
	// Tìm kiếm danh mục theo từ khóa trong tên
	List<CategoryModel> findName(String keyword);
	 // Tìm danh mục theo ID
	CategoryModel findById(int id);
	// Tìm danh mục theo tên chính xác
	CategoryModel find(String name);
	 // Thêm danh mục mới
	void insert(CategoryModel category);
	 // Cập nhật danh mục
	void update(CategoryModel category);
	 // Xóa danh mục theo ID
	void delete(int id);


}
