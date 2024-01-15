package com.ezen.springdb.mapper;

import java.util.List;

import com.ezen.springdb.dto.FruitDTO;

public interface FruitMapperXML {

	List<FruitDTO> getAll();
	
	FruitDTO get(int fruit_id);
	
	int addFruit(FruitDTO dto);
	
	int updateFruit(FruitDTO dto);
	
	int deleteFruit(int fruit_id);
}
