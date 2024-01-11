package com.ezen.springmvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Cook {
	@Autowired
	Dish dish;
	@Autowired
	Food food;

	private Cook() {}
	
	@Override
	public String toString() {
		return String.format("%s/%s", food, dish);
	}
	
}
