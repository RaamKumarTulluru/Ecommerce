package com.project.dao;

import com.project.model.User;


public interface UserDAO
{
	public boolean registerUser(User user);
	public boolean updateAddress(User user);
	public User getUser(String username);

}
