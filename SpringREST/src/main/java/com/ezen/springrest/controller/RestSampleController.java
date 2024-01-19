package com.ezen.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.service.QuizService;

import lombok.extern.log4j.Log4j;

// @RestController : 내부의 모든 메서드들에 @ResponseBody가 적용된다

@Log4j
@RequestMapping("/rest")
@RestController
public class RestSampleController {

	// produces : 응답 헤더의 Content-type을 변경한다. (브라우저의 해석 방식 변경)

	@RequestMapping(value = "/v1", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String value1() {
		return "Hello, Restful!";
	}

	@RequestMapping(value = "/v2", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String value2() {
		return "<h1>Hello, Restful!</h1>";
	}

	// jackson-databind : DTO를 응답하면 자동으로 json형식으로 만들어서 응답해준다
	@GetMapping(value = "/v3", produces = "application/json")
	public EmployeeDTO value3() {
		EmployeeDTO emp = new EmployeeDTO();

		emp.setEmployee_id(11);	
		emp.setFirst_name("철수");
		emp.setLast_name("김");
		return emp;
	}
	
	@GetMapping(value = "/v4", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDTO value4() {
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmployee_id(15);	
		emp.setFirst_name("만득");
		emp.setLast_name("이");
		return emp;
	}
	
	// jackson-dataformat-xml : DTO를 XML형식 문자열로 응답해주는 라이브러리
	@GetMapping(value = "/v5", produces = MediaType.APPLICATION_XML_VALUE)
	public EmployeeDTO value5() {
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmployee_id(18);	
		emp.setFirst_name("자바");
		emp.setLast_name("심");
		return emp;
	}
	
	// jackson-databind는 List<DTO>로 리턴하더라도 잘 변환해준다
	@GetMapping(value = "/v6", produces = MediaType.APPLICATION_XML_VALUE)
	public List<EmployeeDTO> value6() {
		List<EmployeeDTO> emps = new ArrayList<>();
		
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setEmployee_id(18);	
		emp1.setFirst_name("자바");
		emp1.setLast_name("심");
		
		EmployeeDTO emp2 = new EmployeeDTO();
		emp2.setEmployee_id(19);	
		emp2.setFirst_name("씨플");
		emp2.setLast_name("박");
		
		EmployeeDTO emp3 = new EmployeeDTO();
		emp3.setEmployee_id(20);	
		emp3.setFirst_name("이썬");
		emp3.setLast_name("최");
		
		EmployeeDTO emp4 = new EmployeeDTO();
		emp4.setEmployee_id(21);	
		emp4.setFirst_name("씨샵");
		emp4.setLast_name("김");
		
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		
		return emps;
	}
	
	@GetMapping("/entity1")
	public ResponseEntity<String> entity1(){
		
		ResponseEntity<String> resp = ResponseEntity
			.status(HttpStatus.OK)
			.contentType(MediaType.TEXT_HTML)
			.body("<h1>The response I made</h1>");
		
		return resp;
	}
	
	@GetMapping("/entity2")
	public ResponseEntity<String> entity2(){
		return ResponseEntity.ok("<h1>OK!!</h1>");
	}
	
	// jackson-databind의 JSON형식 데이터 응답을 수동으로 구현해보기
	@GetMapping("/entity3")
	public ResponseEntity<String> entity3(){
		return ResponseEntity
				.status(200)
				.contentType(MediaType.APPLICATION_JSON)
				.body("{\"first_name\":\"틀린\", \"last_name\":\"코\"}");
	}
	
	
	@GetMapping("/entity4")
	public ResponseEntity<EmployeeDTO> entity4(){
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmployee_id(20);
		emp.setFirst_name("Allen");
		emp.setLast_name("Worker");
		
		return ResponseEntity
				.status(200)
				.contentType(MediaType.APPLICATION_JSON)
				.body(emp);
	}
	
	
	// 퀴즈
	@Autowired
	QuizService quizService;
	
	@GetMapping(value = "/quizJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDTO> randomEmpsJSON() {
		List<EmployeeDTO> emps = quizService.ranEmpList();
		return emps;
	}
	@GetMapping(value = "/quizXML", produces = MediaType.APPLICATION_XML_VALUE)
	public List<EmployeeDTO> randomEmpsXML() {
		List<EmployeeDTO> emps = quizService.ranEmpList();
		return emps;
	}
	
}
