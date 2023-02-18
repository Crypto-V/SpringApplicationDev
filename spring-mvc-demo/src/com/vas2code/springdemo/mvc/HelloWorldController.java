package com.vas2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need the controller to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new a controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from the html form
		String theName = request.getParameter("studentName");

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message

		String result = "YOYO " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

	// the new a controller method that will automatically get the parameter and assign
	// it to the variable same as the method above but less code.
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message

		String result = "Hey my Friend "+theName+" from the coding world ";

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
