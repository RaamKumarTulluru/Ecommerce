package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.CartDAO;
import com.project.dao.ProductDAO;
import com.project.model.Cart;
import com.project.model.Product;

@Controller

public class CartController
{
	@Autowired
	CartDAO cartDAO;
	
    @Autowired
    ProductDAO productDAO;
    
    @RequestMapping("/cart")
    public String ShowCart(Model m,HttpSession session)
    {	
    	String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDAO.listCart(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		return "Cart";
		
    }
    
@RequestMapping("/addToCart/{productId}")
  public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
     {
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		
		Cart cartItem=new Cart();
		cartItem.setProductID(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);	
		cartItem.setPrice(product.getPrice());
		cartItem.setPaymentStatus("NP");
		cartItem.setUsername(username);
		
		cartDAO.addCart(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCart(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		return "Cart";
	}

  @RequestMapping("/updateCartItem/{cartItemId}")
    public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m, HttpSession session)
     {
	  Cart cartItem=cartDAO.getCart(cartItemId);
	  cartItem.setQuantity(quantity);
	  
	  cartDAO.updateCart(cartItem);
	  
	  String username=(String)session.getAttribute("username");
	  List<Cart> cartItemList=cartDAO.listCart(username);
		
	  m.addAttribute("cartItemList", cartItemList);
	  m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
	  return "Cart";
     }
	
  @RequestMapping("/deleteCartItem/{cartItemId}")
  public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m, HttpSession session)
   {
	  Cart cartItem=cartDAO.getCart(cartItemId);
	 
	  
	  cartDAO.deleteCart(cartItem);
	  
	  String username=(String)session.getAttribute("username");
	  List<Cart> cartItemList=cartDAO.listCart(username);
		
	  m.addAttribute("cartItemList", cartItemList);
	  m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
	  return "Cart";
   }
	
  
	public int getGrandTotal(List<Cart> cartList)
	 {
		int grandTotal=0,count=0;
		while(count<cartList.size())
		{
			grandTotal=grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice());
			count++;
		}
		return grandTotal;
	}

}
