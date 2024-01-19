package com.ezen.springrest.dto;

import lombok.Data;

// getter, setter, 생성자 생성
@Data
public class EmployeeDTO {
	// DB 컬럼명과 정확하게 일치하도록 작성하는 것이 좋다
	private Integer employee_id;
	private String first_name;
	private String last_name;
	
}
