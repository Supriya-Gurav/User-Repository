package com.java.user.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.user.beans.UserBean;
import com.java.user.dao.UserDao;
import com.java.user.entities.User;
import com.java.user.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	static
	{
		System.out.println("UserServiceImpl loaded.....");
	}

	@Autowired
	UserDao daoImpl;

	public User beantoEntity(UserBean bean) {
		User user=new User();
		user.setUserAddress(bean.getUserAddress());
		user.setUserAge(bean.getUserAge());
		user.setUserEmail(bean.getUserEmail());
		user.setUserName(bean.getUserName());
		user.setUserId(bean.getUserId());
		return user;
	}
	@Override
	public String saveUser(UserBean bean) {
		User user=new User();
		user.setUserId(bean.getUserId());
		user.setUserName(bean.getUserName());
		user.setUserEmail(bean.getUserEmail());
		user.setUserAddress(bean.getUserAddress());
		user.setUserAge(bean.getUserAge());
		return daoImpl.saveUser(user);
		
	}
	@Override
	public UserBean getUserById(int userId) {
		User user=daoImpl.getUserById(userId);
		return userEntityTobean(user);
	}
	
	private UserBean userEntityTobean(User user)
	{
			UserBean bean=new UserBean();
			bean.setUserId(user.getUserId());
			bean.setUserName(user.getUserName());
			bean.setUserEmail(user.getUserEmail());
			bean.setUserAddress(user.getUserAddress());
			bean.setUserAge(user.getUserAge());
			
			return bean;
			
		}
	
	@Override
	public UserBean getUserByEmail(String userEmail) {
		User user=daoImpl.getUserByEmail(userEmail);
		return userEntityTobean(user);
	}

	
	public UserBean updateUser(UserBean bean, int userId) {
		List<User> userList=daoImpl.getListOfUser();
		System.out.println(userList);
		for(User user:userList)
		{
			if(user.getUserId()==userId)
			{
				user.setUserId(bean.getUserId());
				user.setUserName(bean.getUserName());
				user.setUserEmail(bean.getUserEmail());
				user.setUserAddress(bean.getUserAddress());
				user.setUserAge(bean.getUserAge());
				return userEntityTobean(daoImpl.updateUserRecord(user));
			}
		}
		return null;
	}





	@Override
	public String deleteUser(int userId) {
		return daoImpl.deleteUser(userId);
	}
	@Override
	public List<UserBean> ListOfUser() {
		List<User> entities=daoImpl.getListOfUser();
		List<UserBean> bean=userEntityToBean(entities);
		return null;
	}


	private List<UserBean> userEntityToBean(List<User> entities) {
		List<UserBean> list=new ArrayList<UserBean>();
		for(User usr:entities) {
		
			UserBean bean=userEntityTobean(usr);
			bean.setUserId(usr.getUserId());
			bean.setUserName(usr.getUserName());
			bean.setUserEmail(usr.getUserEmail());
			bean.setUserAge(usr.getUserAge());
			bean.setUserAddress(usr.getUserAddress());
		}
		
		return list;
	}
	}

	
	
	
	
	
	

	
	
	
	
	

