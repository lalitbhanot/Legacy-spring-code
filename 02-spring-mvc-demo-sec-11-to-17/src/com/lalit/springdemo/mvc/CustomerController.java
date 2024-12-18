package com.lalit.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void InitBinder(WebDataBinder databinder)
	{
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true) ;
		databinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// add customer object to the model
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingReult) {
		System.out.println("the Customer ::" + theCustomer.getFirstName() + theCustomer.getLastName());
		if (theBindingReult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
}
