package com.ezen.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.service.FruitService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class FruitController {
	
	@Autowired
	FruitService fruitService;

	// @GetMapping, @PostMapping ... 등으로 @RequestMapping을 줄여 사용할 수 있다.
	@GetMapping("/fruit/list")
	public String list(Model model) {
		int result = fruitService.list(model);
		
		if (result == 1) {
			return "/fruit/list";
		} else {
			return "redirect:/fruit/list";
		}
		
		//log.info(fruitMapperXML);
		//model.addAttribute("fruits", fruitMapper.getAll());
		//model.addAttribute("fruits", fruitMapperXML.getAll());
	}
	
	@GetMapping("/fruit/update")
	public String updateForm(Model model, int fruit_id) {
		int result = fruitService.updateForm(model, fruit_id);
		
		if (result == 1) {
			return "/fruit/update";
		} else {
			return "redirect:/fruit/list";
		}
		
		// model.addAttribute("fruit", fruitMapper.get(fruit_id));
		// model.addAttribute("countries", countryMapper.getAll());
	}
	
	@PostMapping("/fruit/update")
	public String update(FruitDTO dto, RedirectAttributes attributes) {
		int result = fruitService.update(dto);
		
		if (result == 1) {
			return "redirect:/fruit/list";
		} else {
			attributes.addAttribute("fruit_id", dto.getFruit_id());
			attributes.addAttribute("updateResult", false);
			return "redirect:/fruit/update";
			//return "redirect:/fruit/update?fruit_id" + dto.getFruit_id();
		}
		
		// int row = fruitMapper.update(dto);
		// int row = fruitMapperXML.updateFruit(dto);
		//return "redirect:/fruit/list";
	}
}
