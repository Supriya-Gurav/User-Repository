package com.java.user.beans;

public class UserBean 
{
	private int userId;
	private String userName;
	private String userEmail;
	private String userAddress;
	private int userAge;
	
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(int userId, String userName, String userEmail, String userAddress, int userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userAge = userAge;
		
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userAddress="
				+ userAddress + ", userAge=" + userAge + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	

	
	
}
