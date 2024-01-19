package com.ezen.springrest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.mapper.QuizMapper;


@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	QuizMapper quizMapper;
	
	@Override
	public List<EmployeeDTO> ranEmpList() {
		
		List<EmployeeDTO> emps = quizMapper.getAll();
		
		List<EmployeeDTO> ranEmps = new ArrayList<>();
		for (int i = 0; ranEmps.size() < 10; i++) {
			Collections.shuffle(emps);
			ranEmps.add(emps.get(0));
		}
		
		return ranEmps;
	}
}
