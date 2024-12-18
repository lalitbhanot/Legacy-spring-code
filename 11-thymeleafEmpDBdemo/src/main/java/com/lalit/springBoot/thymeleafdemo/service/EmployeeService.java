package com.lalit.springBoot.thymeleafdemo.service;

import java.util.List;

import com.lalit.springBoot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
public List<Employee> findAll();
	
	public Employee findById (int theId);
	
	public void save (Employee employee);
	
	public void deleteById (int theId);
}
