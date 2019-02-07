package com.project.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.model.Invoice;
@Repository("invoiceDAO")
@Transactional

public class InvoiceDAOImpl implements InvoiceDAO
{
	public boolean saveOrder(Invoice invoice)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCart(String username)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
