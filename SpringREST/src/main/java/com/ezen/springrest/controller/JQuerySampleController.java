package com.ezen.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.springrest.dto.EmployeeDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/jquery")
@Controller
public class JQuerySampleController {

	@GetMapping("/")
	public String jQueryHome() {
		
		return "jquery/index";
	}
	
	@ResponseBody
	@GetMapping("/employee/{emp_id}")
	public EmployeeDTO getEmployee(@PathVariable("emp_id") Integer emp_id) {
		
		log.info("emp_id : " + emp_id);
		
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmployee_id(emp_id);
		emp.setFirst_name("WIll");
		emp.setLast_name("Smith");
		
		return emp;
	}
	
}
