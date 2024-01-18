package com.ezen.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String home() {

		return "home";
	}

	@ResponseBody
	@GetMapping(value = "/fruit", produces = "text/text; charset=UTF-8")
	public String fruit() {

		// 원래 의미 : /WEB-INF/views/fruit.jsp로 포워드 하겠다
		// @ResponseBody를 붙인 후 : "fruit"을 응답하겠다 (데이터를 응답)
		return "<b>fruit</b>";
	}
}
