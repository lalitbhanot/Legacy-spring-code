package com.lalit.springBoot.cruddemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.springBoot.cruddemo.entity.Employee;
import com.lalit.springBoot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api-spring-jpa")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired //check between the employeeService and parameter theemployeeService
	public EmployeeRestController(EmployeeService theemployeeService) {
		employeeService = theemployeeService;    
	}

	@GetMapping("/employees")
	public List <Employee> findAll (){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById (@PathVariable int id){

		Employee theEmployee = employeeService.findById(id);
		if (theEmployee==null) 
		{
			throw new RuntimeException("Employee not found  " + id) ;
		}
		
		return theEmployee ;
	}

	@PostMapping("/employees")
	public Employee addEmployee (@RequestBody Employee theEmployee){

		theEmployee.setId(0) ;
		employeeService.save(theEmployee) ;
		return theEmployee ;
	}

	@PutMapping("/employees")
	public Employee updateEmployee (@RequestBody Employee theEmployee){

		employeeService.save(theEmployee) ;
		return theEmployee ;
	}

	@DeleteMapping("/employees/{id}")
	public String  deleteEmployee (@PathVariable int id){

		Employee theEmployee = employeeService.findById(id);
		if (theEmployee==null) 
		{
			throw new RuntimeException("Employee not found  " + id) ;
		}
		employeeService.deleteById(id);
		
		return "Employee Deleted" ;
	}

	
	}

