package com.lalit.springBoot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lalit.springBoot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	private List<Employee> theEmployee ;
	
	@PostConstruct
	private void loadData() {
	Employee employee = new Employee("abc","abc","abc1@gmail.com");
	Employee employee1 = new Employee("abc1","abc1","abc1@gmail.com");
	Employee employee2 = new Employee("abc2","abc2","abc2@gmail.com");
	Employee employee3 = new Employee("abc3","abc3","abc3@gmail.com");
	
	theEmployee = new ArrayList<>();
	
	theEmployee.add(employee3);
	theEmployee.add(employee2);
	theEmployee.add(employee1);
	theEmployee.add(employee);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		theModel.addAttribute("employees",theEmployee) ;
		
		return "list-emp" ;
	}
}
