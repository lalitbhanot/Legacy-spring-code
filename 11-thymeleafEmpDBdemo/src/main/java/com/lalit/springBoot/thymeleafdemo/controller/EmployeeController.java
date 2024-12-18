package com.lalit.springBoot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lalit.springBoot.thymeleafdemo.service.EmployeeService;
import com.lalit.springBoot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired // check between the employeeService and parameter theemployeeService
	public EmployeeController(EmployeeService theemployeeService) {
		employeeService = theemployeeService;
	}

	@GetMapping("/list")
	public String findAll(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-emp";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/form-emp";
	}

	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {

		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/form-emp";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		Employee theEmployee = employeeService.findById(id);
		if (theEmployee == null) {
			throw new RuntimeException("Employee not found  " + id);
		}
		employeeService.deleteById(id);

		return "redirect:/employees/list";
	}

	/*
	 * @GetMapping("/employees/{id}") public Employee findById (@PathVariable int
	 * id){
	 * 
	 * Employee theEmployee = employeeService.findById(id); if (theEmployee==null) {
	 * throw new RuntimeException("Employee not found  " + id) ; }
	 * 
	 * return theEmployee ; }
	 * 
	 * @PostMapping("/employees") public Employee addEmployee (@RequestBody Employee
	 * theEmployee){
	 * 
	 * theEmployee.setId(0) ; employeeService.save(theEmployee) ; return theEmployee
	 * ; }
	 * 
	 * @PutMapping("/employees") public Employee updateEmployee (@RequestBody
	 * Employee theEmployee){
	 * 
	 * employeeService.save(theEmployee) ; return theEmployee ; }
	 * 
	 * @DeleteMapping("/employees/{id}") public String deleteEmployee (@PathVariable
	 * int id){
	 * 
	 * Employee theEmployee = employeeService.findById(id); if (theEmployee==null) {
	 * throw new RuntimeException("Employee not found  " + id) ; }
	 * employeeService.deleteById(id);
	 * 
	 * return "Employee Deleted" ; }
	 * 
	 * 
	 */
}
