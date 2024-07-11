package com.admin.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.entities.Category;
import com.admin.entities.Users;

@Repository
public class UsersDao {
@Autowired
SessionFactory sessionFactory;
		public List<Users> listUsers() {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				List list = session.createQuery("from Users").list();
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
		public Users getUserById(int UserId) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			try {
				Users User = session.get(Users.class, UserId);
				return User;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				session.close();
			}
			return null;
		}
		
	public void insert(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	public List<Users> login(String email, String password) {
	    Session session = sessionFactory.openSession();
	    Query query = session.createQuery("from Users where Email = :email and UserPassWord = :password");
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    
	    List<Users> resultList = query.getResultList();
	    
	    if (!resultList.isEmpty()) {
	        return resultList;
	    } else {
	        return null;
	    }
	}
}
