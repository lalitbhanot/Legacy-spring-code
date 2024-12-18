package com.lalit.springdemo.dao;

import java.util.List;

import com.lalit.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);
}
