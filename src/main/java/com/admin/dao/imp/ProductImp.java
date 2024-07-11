package com.admin.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.dao.ProductDao;
import com.admin.entities.Product;
@Repository
public class ProductImp implements ProductDao{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public List<Product> listProduct(Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session.createQuery("from Product")
					.setFirstResult(offset)
					.setMaxResults(maxResult)
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

	@Override
	public boolean insertProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
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
	public Product getProductById(Integer proId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Product product = session.get(Product.class, proId);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(Integer proId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getProductById(proId));
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
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(p);
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
	public long getTotalProductPagination() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		try {
			List list = session.createQuery("select count(*) from Product").list();
			return (long) list.get(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public List<Product> getProductByName(String name, Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if(name==null || name.length()==0)
				name = "%";
			else
				name = "%"+name+"%";
			List<Product> list = session.createQuery("from Product where Name like :proName")
					.setParameter("proName", name)
					.setFirstResult(offset)
					.setMaxResults(maxResult)
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


	@Override
	public long getTotalProductPaginationByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		if(name==null || name.length()==0)
			name = "%";
		else
			name = "%"+name+"%";
		try {
			List list = session.createQuery("select count(*) from Product  where Name like :proName ")
					.setParameter("proName", name)
					.list();
			return (long) list.get(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
