package com.ezen.springdb.dto;

import java.util.Date;

import lombok.Data;

// getter, setter, 생성자 생성
@Data
public class EmployeeDTO {
	// DB 컬럼명과 정확하게 일치하도록 작성하는 것이 좋다
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private Double salary;
	private Double commission_pct;
	private String job_id;
	private Date hire_date;
	private Integer department_id;
	private Integer manager_id;

}
