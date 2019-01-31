package com.project.Into_style;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.dao.UserDAO;
import com.project.model.User;

public class UserUnitTest
{
static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();	
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	

	@Test
	public void registerUserTest()
	{
		User user=new User();
		
		user.setUsername("Gopi");
		user.setPassword("Gopi123");
		user.setUsername("karthik");
		user.setPassword("karthik123");
		user.setEnabled(true);
		user.setRole("ROLE_admin");
		user.setCustomerName("venkatesh");
		user.setCustomerAddr("kothapet");
		
		assertTrue("Problem in adding User:",userDAO.registerUser(user));
	}


}


