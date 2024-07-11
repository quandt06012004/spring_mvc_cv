package com.admin.dao.imp;

import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.dao.InvoiceDao;
import com.admin.entities.Invoices;
import com.admin.entities.Product;
@Repository
public class InvoiceImp implements InvoiceDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Invoices> listInvoices() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Invoices> list = session.createQuery("from Invoices").list();
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
	public boolean insertInvoice(Invoices in) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(in);
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
	public Invoices getInvoiceById(Integer inId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Invoices invoices = session.get(Invoices.class, inId);
			return invoices;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteInvoices(Integer inId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getInvoiceById(inId));
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
	public boolean updateInvoice(Invoices in) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(in);
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
	public List<Invoices> getInvoiceSearchId(Integer id) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
		javax.persistence.Query query=null;
		query=session.createQuery("from Invoices where inId=:id").setParameter("id",id);
		List result=query.getResultList();
		session.close();
		return result;
	}

}
