package com.admin.dao.imp;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.dao.CategoriesDao;
import com.admin.entities.Category;
@Repository
public class Categoriesimp implements CategoriesDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			List list = session.createQuery("from Category").list();
//			List<Category> list = session.createQuery("from Category").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertCategory(Category c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Category getCategoryById(int catId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Category category = session.get(Category.class, catId);
			return category;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteCategory(int catId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getCategoryById(catId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category cus) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(cus);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Category> getCategoryByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if(name==null || name.length()==0)
				name = "%";
			else
				name = "%"+name+"%";
			List list = session.createQuery("from Categories where Name like :Catname")
					.setParameter("Catname", name)
					.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
