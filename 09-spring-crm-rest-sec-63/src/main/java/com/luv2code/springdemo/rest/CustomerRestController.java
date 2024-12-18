package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer showFormForUpdate(@PathVariable int customerId) {

		// create model to bind the form data
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer == null)
		{
			throw new CustomerNotFoundException("Customer Not Found " + customerId );
		}
		
		return theCustomer;
	}
	
	
	@PostMapping("/customers")
	public Customer addcustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		//theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String  deleteCustomer(@PathVariable int customerId) {

		// create model to bind the form data
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer == null)
		{
			throw new CustomerNotFoundException("Customer Not Found " + customerId );
		}
		customerService.deleteCustomer(customerId);
		return "Customer Deleted";
	}
}
