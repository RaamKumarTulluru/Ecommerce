package com.project.Into_style;



import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.dao.ProductDAO;
import com.project.model.Product;

public class ProductUnitTest 
{
static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	

	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Lee");
		product.setProductDesc("Jean Pants");
		product.setPrice(4500);
		product.setStock(15);
		product.setCategoryId(1);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
	}

}




