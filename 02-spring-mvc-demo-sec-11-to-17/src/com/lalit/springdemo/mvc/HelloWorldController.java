package com.lalit.springdemo.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show inital html form
	// http://localhost:8090/spring-mvc-demo/showForm
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorldForm";
	}

	// need a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}

	// THIS IS A WORKING EXAMPLE WITH REQUEST AND MODEL EXAMPLE
	@RequestMapping("/nchoDudewithhttpServlet") public String nchoDudewithhttpServlet(HttpServletRequest
	  request, Model model) {
		//read the request from HTML 
		String name =
	  request.getParameter("studentName") ; 
	// convert the data to all caps
		name = "Hi " + name.toUpperCase(); //create the message
	  model.addAttribute("message",name) ; //add the message to the model 
	  return  "helloWorld"; }

	@RequestMapping("/nchoDude")
	public String nchoDude(@RequestParam("studentName") String studentName, Model model) {

		// convert the data to all caps
		studentName = "Hi with  @RequestParam " + studentName.toUpperCase();
		// create the message
		model.addAttribute("message", studentName);
		// add the message to the model
		return "helloWorld";
	}
}
