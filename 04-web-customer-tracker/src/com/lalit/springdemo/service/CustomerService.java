package com.lalit.springdemo.service;

import java.util.List;

import com.lalit.springdemo.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomer() ;

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int id) ;

	public void deleteCustomer(int theId);
}
