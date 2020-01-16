package com.wanchopi.spring.controller;


import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wanchopi.spring.model.Student;


/**
 * Spring MVC Controller
 * @author Wanchopi
 *
 */
@Controller
public class StudentController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Value("${countries}")
	private String countries;	// load field countries of properties
	
	@Value("${frameworks}")
	private String frameworks;	// load field frameworks of properties
	
	@ModelAttribute("countryList")
	public String[] loadCountries() {
		String[] items = this.countries.split(",");	// converts a comma-separated string into an array
		return items;	
	}
	
	@ModelAttribute("frameworkList")
	public String[] loadFrameworks() {
		String[] items = this.frameworks.split(","); // convers a comma-separated string into an array
		return items;
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	@GetMapping("/")
	public ModelAndView student() {
		logger.info("Returning form view");
		Student student = new Student();
		ModelAndView mav = new ModelAndView("index", "student", student);
		return mav;
	}
	

	@PostMapping("/save")
	public String saveForm(@Valid @ModelAttribute("student") Student student,
			BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "index";
		}
		else {
			return "success";
		}
	}

}
