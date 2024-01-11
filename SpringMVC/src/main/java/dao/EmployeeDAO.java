package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EmployeeDTO;

public class EmployeeDAO {

	public List<EmployeeDTO> getEmpByDept(int i) {
		
		String sql = "select * from employees where department_id=?";
		
		List<EmployeeDTO> list = new ArrayList<>();
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, i);
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					EmployeeDTO dto = new EmployeeDTO();
					dto.setEmployee_id(rs.getInt("employee_id"));
					dto.setFirst_name(rs.getString("first_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setDepartment_id(rs.getString("department_id"));
					list.add(dto);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

}
