package com.lalit.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lalit.springdemo.dao.CustomerDAO;
import com.lalit.springdemo.entity.Customer;
import com.lalit.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	private CustomerDAO customerDAO;
	@Autowired
	private CustomerService customerService;

	// @RequestMapping("/list") refactoring to getMapping
	@GetMapping("/list")
	public String listcustomer(Model theModel) {
		// add customer object to the model
		// get customer from the dao
		List<Customer> theCustomer = customerService.getCustomer();
		System.out.println(theCustomer.size());
		// add the customer to the model
		theModel.addAttribute("customer", theCustomer);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addcustomer(Model theModel) {

		// create model to bind the form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String addcustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// create model to bind the form data
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// create model to bind the form data
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
