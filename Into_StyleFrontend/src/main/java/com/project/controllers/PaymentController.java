package com.project.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.CartDAO;
import com.project.dao.InvoiceDAO;
import com.project.dao.ProductDAO;
import com.project.dao.UserDAO;
import com.project.model.Cart;
import com.project.model.Invoice;
import com.project.model.User;

@Controller

public class PaymentController 
{/*
	@Autowired
	CartDAO cartDAO;
	
    @Autowired
    ProductDAO productDAO;
    
    @Autowired
    UserDAO userDAO;
    
    @Autowired
    InvoiceDAO orderDAO; 
    
  @RequestMapping("/checkout")
  public String checkOut(Model m,HttpSession session)
  {
	  String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDAO.listCart(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		User userDetail=userDAO.getUser(username);
		
	    String address=userDetail.getCustomerAddr();
	    
	    m.addAttribute("addr", address);
	  
	    return"OrderConfirm";
  }
  
  @RequestMapping(value="/UpdateAddr", method=RequestMethod.POST)
  public String UpdateAddr(@RequestParam("addr")String addr,Model m, HttpSession session)
  {
	  String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDAO.listCart(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		User userdetail=userDAO.getUser(username);
		userdetail.setCustomerAddr(addr);		
	

	    String address=userdetail.getCustomerAddr();
	    
	    m.addAttribute("addr", address);
	  
	  return "OrderConfirm";
  }
  
  @RequestMapping(value="/payment")
  public String paymentPage(Model m, HttpSession session)
  {
	  
	  
	  return "Payment";
  }
  
  @RequestMapping(value="/receipt", method=RequestMethod.POST)
  public String generateReceipt(@RequestParam ("rd") String rd, Model m,HttpSession session)
  {
	  String username=(String)session.getAttribute("username");
	  
	  Invoice orderDetail=new Invoice();
	  orderDetail.setOrderDate(new Date());
	  orderDetail.setShippingAddress(userDAO.getUser(username).getCustomerAddr());
	  orderDetail.setUsername(username);
	  
	  List<Cart> cartItemList=cartDAO.listCart(username);
		
	  m.addAttribute("cartItemList", cartItemList);
	  m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
	  orderDetail.setTotalAmount(this.getGrandTotal(cartItemList));
	  
	  orderDAO.saveOrder(orderDetail);
	  orderDAO.updateCart(username);
	  
	  m.addAttribute("orderDetail", orderDetail);
	  
	  return "Receipt";
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

*/
}

