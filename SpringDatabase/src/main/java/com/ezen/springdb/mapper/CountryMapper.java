package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.springdb.dto.CountryDTO;

public interface CountryMapper {
	
	@Select("SELECT * FROM countries")
	List<CountryDTO> getAll();
}
