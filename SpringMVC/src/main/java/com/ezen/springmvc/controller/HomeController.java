package com.ezen.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Coffee;
import com.ezen.springmvc.model.Cook;
import com.ezen.springmvc.model.Department;

import commons.Calculator;

@Controller
public class HomeController {
	
	private static Logger log =  LogManager.getLogger(HomeController.class);
	
	@Autowired
	Cook cook;
	
	@Autowired
	Calculator calculator;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Department dept = new Department();
		Coffee coffee = new Coffee();
		
		// @NonNull필드에 null을 넣으려는 경우 익셉션을 발생시켜준다
		try {			
			coffee.setCoffee_id(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info(dept);
		log.info(coffee);
		
		int a = calculator.diff(10, 13);
		
		log.fatal("Welcome to HomeController!!");
		log.error("Welcome to HomeController!!");
		log.warn("Welcome to HomeController!!");
		log.info("Welcome to HomeController!!");
		log.debug("Welcome to HomeController!!");
		log.trace("Welcome to HomeController!!");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("cook", cook);
		
		return "home";
	}
	
}
