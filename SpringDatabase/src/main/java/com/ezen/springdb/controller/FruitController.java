package com.ezen.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.springdb.mapper.FruitMapper;

@Controller
public class FruitController {
	
	// @GetMapping, @PostMapping ... 등으로 @RequestMapping을 줄여 사용할 수 있다.
	
	@Autowired
	FruitMapper fruitMapper;
	

	@GetMapping("/fruit/list")
	public void list(Model model) {
		model.addAttribute("fruits", fruitMapper.getAll());
	}
}
