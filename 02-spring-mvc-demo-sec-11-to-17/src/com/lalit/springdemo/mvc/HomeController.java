package com.lalit.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//Step 1
@Controller
public class HomeController {
//step 2
@RequestMapping("/")
	public String showPage() {
		return "main-menu" ;
	}
	


}
