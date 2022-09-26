package com.java.user.dao;

import java.util.List;



import com.java.user.entities.User;

public interface UserDao
{
	public String saveUser(User user);
	public User getUserById(int userId);
	public List<User> getListOfUser();
	public User updateUserRecord(User user);
	public User getUserByEmail(String userEmail);
	public String deleteUser(int userId);
}


