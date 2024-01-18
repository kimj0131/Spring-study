package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class RedirectController {

	@RequestMapping(value = "/redirect/test1", method = RequestMethod.GET)
	public String test1(Model model) {
		model.addAttribute("ice", "true");
		return "redirect:/abc/a";
	}
	
	@RequestMapping(value = "/redirect/test2", method = RequestMethod.GET)
	public String test2(RedirectAttributes attributes) {
		// 리다이렉트 요청시 GET방식 파라미터로 함께 보내는 값들을 RedirectAttributes라고 칭한다
		attributes.addAttribute("age", 20);
		return "redirect:/abc/b?user=admin&t=a";
	}
	
	@RequestMapping(value = "/abc/b", method = RequestMethod.GET)
	public String test22(String user, Character t, int age) {
		log.info("user:" + user);
		log.info("t:" + t);
		log.info("age:" + age);
		return "/aaa/aaa";
	}
	
	@RequestMapping(value = "/redirect/test3", method = RequestMethod.GET)
	public String test3(RedirectAttributes attributes) {
		attributes.addFlashAttribute("age",123);
		attributes.addFlashAttribute("login", "true");
		
		return "redirect:/abc/c2";
	}
	
	@RequestMapping(value = "/abc/c", method = RequestMethod.GET)
	public String test33(@ModelAttribute("age") int age, @ModelAttribute("login") boolean login) {
		log.info("age: "+ age);
		log.info("login: "+ login);
		
		
		return "/bbb/bbb";
	}
	@RequestMapping(value = "/abc/c2", method = RequestMethod.GET)
	public String test333(Model model) {
		log.info("age: "+ model.getAttribute("age"));
		log.info("login: "+ model.getAttribute("login"));
		
		
		return "/bbb/bbb";
	}
}
