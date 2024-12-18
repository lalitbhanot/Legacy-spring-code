package com.lalit.springBoot.cruddemo.dao;

import java.util.List;

import com.lalit.springBoot.cruddemo.entity.Employee;

public interface EmployeeDAOJpa {

	
	public List<Employee> findAll();
	
	public Employee findById (int theId);
	
	public void save (Employee employee);
	
	public void deleteById (int theId);
	
}
