package dto;

import java.sql.Date;

public class EmployeeDTO {
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private Double salary;
	private Date hire_date;
	private String department_id;
	

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String laString_name) {
		this.last_name = laString_name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "EmployeeDto_ans [employee_id=" + employee_id + ", first_name=" + first_name + ", laString_name="
				+ last_name + ", salary=" + salary + ", hire_date=" + hire_date + ", department_id=" + department_id
				+ "]";
	}

}