package com.project.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO

{
	@Autowired
	SessionFactory sessionFactory;
	
	 
	public boolean registerUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	 
	public boolean updateAddress(User user) 
	{
		
		return false;
	}

 
	public User getUser(String username) 
	{
	
		return null;
	}
	

}


