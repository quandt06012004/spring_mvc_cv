package com.admin.dao;

import java.util.List;

import com.admin.entities.Customers;

public interface CustomerDao {
	public List<Customers> listCustomers();
	public boolean insertCustomer(Customers cus);
	public Customers getCustomerById(int cusId);
	public boolean deleteCustomer(int cusId);
	public boolean updateCustomer(Customers cus);
}
