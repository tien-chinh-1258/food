package vn.herta.dao.impl;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.herta.configs.JPAConfig;
import jakarta.persistence.Query;
import vn.herta.entity.Category;
import vn.herta.dao.ICategoryDao;

public class CategoryDao implements ICategoryDao {
	
   @Override
public void insert(Category category) {
	   EntityManager enma = JPAConfig.getEntityManager();
	   EntityTransaction trans = enma.getTransaction();
	  
	   try {
	   trans.begin();
	   // goi phuong thuc de insert,update,delete
	   enma.persist(category);
	   trans.commit();
	   } catch (Exception e) {
	     e.printStackTrace();
	     trans.rollback();
	     throw e;
	   }finally {
	        enma.close();
	       }
	    }
   
   @Override
public void update(Category category) {
	   EntityManager enma = JPAConfig.getEntityManager();
	   EntityTransaction trans = enma.getTransaction();
	  
	   try {
	   trans.begin();
	   // goi phuong thuc de insert,update,delete
	   enma.merge(category);
	   trans.commit();
	   } catch (Exception e) {
	     e.printStackTrace();
	     trans.rollback();
	     throw e;
	   }finally {
	        enma.close();
	       }
	    }
   @Override
public void delete(int cateid) throws Exception {
	   EntityManager enma = JPAConfig.getEntityManager();
	   EntityTransaction trans = enma.getTransaction();
	  
	   try {
	   trans.begin();
	   // goi phuong thuc de insert,update,delete
	   Category category = enma.find(Category.class,cateid);
	   if(category !=null) {	   
	      enma.remove(category);
	   }else {
		   throw new Exception("không tìm thấy");
	   }
	   trans.commit();
	   } catch (Exception e) {
	     e.printStackTrace();
	     trans.rollback();
	     throw e;
	   }finally {
	        enma.close();
	       }
	    }
   @Override
public Category findById(int cateid) {
	   EntityManager enma = JPAConfig.getEntityManager();
	   Category category = enma.find(Category.class,cateid);
	   return category;
   }
   @Override
public List<Category> findAll() {
	   EntityManager enma = JPAConfig.getEntityManager();
	   TypedQuery<Category> query = enma.createNamedQuery("Category.findAll",Category.class);
	   return query.getResultList();
   }
   @Override
public List<Category> findByCategoryname(String catname) {
	   EntityManager enma = JPAConfig.getEntityManager();
	   String jpql ="SELECT c FROM Category c.catename like :catname";
	   TypedQuery<Category> query = enma.createNamedQuery(jpql,Category.class);
	   query.setParameter("catename","%"+ catname + "%");
	   return query.getResultList();
   }
   @Override
public List<Category> findAll(int page,int pagesize) {
	   EntityManager enma = JPAConfig.getEntityManager();
	   TypedQuery<Category> query = enma.createNamedQuery("Category.findAll",Category.class);
	   query.setFirstResult(page*pagesize);
	   query.setMaxResults(pagesize);
	   return query.getResultList();
   }
   @Override
public int count() {
	   EntityManager enma = JPAConfig.getEntityManager();
	   String jpql ="SELECT count(c) FROM Category c";
	   Query query = enma.createQuery(jpql);
	   return ((Long)query.getSingleResult()).intValue();
   }

@Override
public List<Category> searchByName(String keyword) {
	// TODO Auto-generated method stub
	return null;
}
  
   
}
