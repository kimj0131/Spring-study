package com.ezen.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.mapper.CountryMapper;
import com.ezen.springdb.mapper.FruitMapperXML;

@Service
public class FruitserviceImpl implements FruitService {

	@Autowired
	FruitMapperXML fruitMapperXML;
	@Autowired
	CountryMapper countryMapper;
	
	@Override
	public int list(Model model) {
		List<FruitDTO> fruits = fruitMapperXML.getAll();
		
		if (fruits.size() == 0) {
			return -1;
		}
		model.addAttribute("fruits", fruits);
		
		return 1;
	}

	@Override
	public int updateForm(Model model, int fruit_id) {
		FruitDTO fruit = fruitMapperXML.get(fruit_id);

		if (fruit == null) {
			return -1;
		}

		model.addAttribute("fruit", fruit);
		model.addAttribute("countries", countryMapper.getAll());

		return 1;
	}

	@Override
	public int update(FruitDTO dto) {
		return fruitMapperXML.updateFruit(dto);
//		return -1;
	}
}
