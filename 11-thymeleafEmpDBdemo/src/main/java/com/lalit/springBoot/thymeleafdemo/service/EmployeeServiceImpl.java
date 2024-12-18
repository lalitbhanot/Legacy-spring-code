package com.lalit.springBoot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import com.lalit.springBoot.thymeleafdemo.Dao.EmployeeRepositoryDAO;
import com.lalit.springBoot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("No user found ");
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
