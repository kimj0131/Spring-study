package com.ezen.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.EmployeeDTO;

import lombok.extern.log4j.Log4j;

// @RestController : 내부의 모든 메서드들에 @ResponseBody가 적용된다

@Log4j
@RequestMapping("/rest")
@RestController
public class RestSampleController {

	// produces : 응답 헤더의 Content-type을 변경한다. (브라우저의 해석 방식 변경)

	@RequestMapping(value = "/v1", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String value1() {
		return "<h1>Hello, Restful!</h1>";
	}

	@RequestMapping(value = "/v2", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String value2() {
		return "<h1>Hello, Restful!</h1>";
	}

	// jackson-databind : DTO를 응답하면 자동으로 json형식으로 만들어서 응답해준다
	@GetMapping(value = "/v3", produces = "application/json; charset=UTF-8")
	public EmployeeDTO value3() {
		EmployeeDTO emp = new EmployeeDTO();

		emp.setEmployee_id(11);	
		emp.setFirst_name("철수");
		emp.setLast_name("김");
		return emp;
	}
}
