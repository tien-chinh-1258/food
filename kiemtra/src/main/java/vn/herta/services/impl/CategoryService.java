package vn.herta.services.impl;

import java.util.List;

import vn.herta.dao.ICategoryDao;
import vn.herta.dao.impl.CategoryDaoImpl;
import vn.herta.models.CategoryModel;
import vn.herta.services.ICategoryService;

public class CategoryService implements ICategoryService {
    public ICategoryDao cateDao = new CategoryDaoImpl();
		

	@Override
	public List<CategoryModel> findAll() {
		
		return cateDao.findAll();
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return cateDao.findName(keyword);
		
	}

	@Override
	public CategoryModel findById(int id) {
	
		return cateDao.findById(id);
	}


	@Override
	public void insert(CategoryModel category) {
	    cateDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate =new CategoryModel();
		cate= cateDao.findById(category.getCategoryid());
		if(cate !=null) {
			cateDao.update(category);
		}		
		
	}

	@Override
	public void delete(int id) {
		CategoryModel cate =new CategoryModel();
		cate= cateDao.findById(id);
		if(cate !=null) {
			cateDao.delete(id);
		}
		
	}
	

}
