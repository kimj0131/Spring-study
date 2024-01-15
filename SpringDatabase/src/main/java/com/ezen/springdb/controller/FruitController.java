package com.ezen.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.mapper.CountryMapper;
import com.ezen.springdb.mapper.FruitMapper;
import com.ezen.springdb.mapper.FruitMapperXML;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class FruitController {
	
	// @GetMapping, @PostMapping ... 등으로 @RequestMapping을 줄여 사용할 수 있다.
	
	@Autowired
	FruitMapper fruitMapper;
	
	@Autowired
	FruitMapperXML fruitMapperXML;
	
	@Autowired
	CountryMapper countryMapper;
	

	@GetMapping("/fruit/list")
	public void list(Model model) {
		log.info(fruitMapperXML);
//		model.addAttribute("fruits", fruitMapper.getAll());
		model.addAttribute("fruits", fruitMapperXML.getAll());
	}
	
	@GetMapping("/fruit/update")
	public void updateForm(Model model, int fruit_id) {
		model.addAttribute("fruit", fruitMapper.get(fruit_id));
		model.addAttribute("countries", countryMapper.getAll());
	}
	
	@PostMapping("/fruit/update")
	public String update(FruitDTO dto) {
//		int row = fruitMapper.update(dto);
		int row = fruitMapperXML.updateFruit(dto);
		return "redirect:/fruit/list";
	}
}
