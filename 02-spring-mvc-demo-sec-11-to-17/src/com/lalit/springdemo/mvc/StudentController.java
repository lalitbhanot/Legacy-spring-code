package com.lalit.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// create a student object
		Student thestudent = new Student();
		// add student object to the model
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("the Student ::" +theStudent.getFirstName() + theStudent.getLastName() );
		return "student-confirmation" ;
		
	}
}
