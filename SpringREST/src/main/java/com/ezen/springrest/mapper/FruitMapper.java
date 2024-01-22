package com.ezen.springrest.mapper;

import java.util.List;

import com.ezen.springrest.dto.FruitDTO;


public interface FruitMapper {

	List<FruitDTO> getAll();
	
	FruitDTO get(int fruit_id);
	
	int addFruit(FruitDTO dto);
	
	int updateFruit(FruitDTO dto);
	
	int deleteFruit(int fruit_id);
}
