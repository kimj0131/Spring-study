package com.ezen.springrest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.springrest.dto.CountryDTO;


public interface CountryMapper {
	
	@Select("SELECT * FROM countries")
	List<CountryDTO> getAll();
}
