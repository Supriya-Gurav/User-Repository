package com.java.user.controller;

import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.user.beans.UserBean;
import com.java.user.entities.User;
import com.java.user.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController 
{
	static
	{
		System.out.println("User Controller Loaded" );
	}
	@Autowired
	UserService service;
	
	@PostMapping("/")
	public String addUser(@RequestBody UserBean bean)
	{
		System.out.println(bean);
		service.saveUser(bean);
		return "User record Saved";
		
	}
	@GetMapping("/{userId}")
	public UserBean serachUserById(@PathVariable("userId") int userId)
	{
		UserBean bean=service.getUserById(userId);
		System.out.println("Userby Id"+bean);
		return bean;
	}
	
	
	
	@PutMapping("/{userId}")
	public ResponseEntity updateUserInfo(@RequestBody UserBean bean,@PathVariable("userId") int userId)
	{
		System.out.println(bean);
		UserBean ubean=service.updateUser(bean, userId);
		if(ubean.getUserId()==bean.getUserId())
		{
			System.out.println(ubean);
			return new ResponseEntity(ubean,HttpStatus.OK);
	
		}
		return new ResponseEntity("No User found of given id...",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity deleteUser(@PathVariable("userId")int userId) {
		service.deleteUser(userId);
		return new ResponseEntity("user deleted sucessfully",HttpStatus.NO_CONTENT);
	}
	@GetMapping("/list")
	public List<UserBean> listOfUsers(){
		List<UserBean> bean=service.ListOfUser();
		System.out.println(bean);
		return bean;
		
	}
	
}
