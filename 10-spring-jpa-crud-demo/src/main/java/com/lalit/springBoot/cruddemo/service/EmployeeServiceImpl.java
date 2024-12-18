package com.lalit.springBoot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.springBoot.cruddemo.dao.EmployeeRepositoryDAO;
import com.lalit.springBoot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepositoryDAO employeeDAO;

	public EmployeeServiceImpl(EmployeeRepositoryDAO theemployeeDAO) {
		employeeDAO = theemployeeDAO;
	}

	@Override
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeDAO.findById(theId);
		Employee theEmployee = null ;
		if (result.isPresent())
		{
			theEmployee =result.get();
		}
		else
		{
			throw new RuntimeException("No user found ") ;
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
