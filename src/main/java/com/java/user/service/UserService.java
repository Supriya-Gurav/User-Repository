package com.java.user.service;

import java.util.List;



import com.java.user.beans.UserBean;
import com.java.user.entities.User;

public interface UserService 
{	
	public String saveUser(UserBean bean);
	public List<UserBean> ListOfUser();
	public UserBean getUserById(int userId);
	public UserBean getUserByEmail(String userEmail);
	public UserBean updateUser(UserBean bean,int userId);
	public String deleteUser(int userId);

	

	

}
