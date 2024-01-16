package com.ezen.springdb.service;

import org.springframework.ui.Model;

import com.ezen.springdb.dto.FruitDTO;

public interface FruitService {
	
	int list(Model model);
	
	int updateForm(Model model, int fruit_id);
	
	int update(FruitDTO dto);

}
