package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.ProductDAO;
import com.project.model.Product;

@Controller
public class PageController 
{
	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/login")
		public String showLogin(Model m)
		{
		    m.addAttribute("pageinfo" , "Login");
			return "Login";
		}
	@RequestMapping("/adminhome")
	public String showHome(Model m)
	{
	    m.addAttribute("pageinfo" , "Home");
	    List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		return "AdminHome";
	}
	 
    @RequestMapping("/register")
		public String showRegister(Model m)
		{
    	    m.addAttribute("pageinfo" , "Register");
			return "Register";
		}


}
