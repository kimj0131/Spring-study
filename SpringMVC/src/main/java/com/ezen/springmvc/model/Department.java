package com.ezen.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복의 적용방법
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@ToString
public class Department {

	@Setter
	private Integer department_id;
	@Getter
	private String department_name;
 	@Getter	@Setter
	private Integer manager_id;
 	@Setter 
	private Integer location_id;
	
}
