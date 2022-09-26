package com.java.user.dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.java.user.dao.UserDao;
import com.java.user.entities.User;
import com.java.user.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao
{
	static
	{
		System.out.println("UserDaoImpl Loaded.....");
	}
	
	@Autowired
	SessionFactory sessionfactory;
	

	@Override
	public String saveUser(User user) {
		Session session=null;
		Transaction tr=null;
		try
		{
			session=sessionfactory.openSession();
			tr=session.beginTransaction();
			
			session.save(user);
			return "User record saved...";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("problem in inseration...!");
		}
		finally
		{
			HibernateUtil.CleanResources(session, tr);
		}
		return "Insertion failed";
		
	}


	@Override
	public User getUserById(int userId) {
		Session session=null;
		Transaction tr=null;
		try {
			session= sessionfactory.openSession();
			tr=session.beginTransaction();

			User user=session.get(User.class, userId);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
	}


	@Override
	public User getUserByEmail(String userEmail) {
		Session session=null;
		Transaction tr=null;
		try {
			session= sessionfactory.openSession();
			tr=session.beginTransaction();

			User user=session.get(User.class, userEmail);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
	}


	@Override
	public List<User> getListOfUser() {
		Session session = null;
		Transaction tr = null;
		List<User> userList=new ArrayList<User>();
		try {
			session = sessionfactory.openSession();
			tr=session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			List<User> list=cr.list();
			return list;
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.CleanResources(session, tr);
		}
		return userList;
	
	}


	@Override
	public User updateUserRecord(User user) {
		Session session=null;
		Transaction tr=null;
		try {
			session = sessionfactory.openSession();
			tr=session.beginTransaction();
			session.update(user);
			User use=session.get(User.class, user.getUserId());
			return user;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
	}


	@Override
	public String deleteUser(int userId) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionfactory.openSession();
			tr=session.beginTransaction();
			User entity=session.get(User.class, userId);
			session.delete(entity);
			return "User deleted";
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.CleanResources(session, tr);
		}
		return null;
	}

	
}

	

	