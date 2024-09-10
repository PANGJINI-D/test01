package com.test;
import java.sql.Connection;
import java.sql.SQLException;

import com.dao.DBConnecter;
import com.dao.UserDAO;
import com.domain.AddressDTO;
import com.domain.DepartmentDTO;
import com.domain.StudentDTO;

public class Test {
	public static void main(String[] args) {
		
		// 드라이버 연결 테스트
		try {
			Connection conn = DBConnecter.getConnection();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDAO userDAO = new UserDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		AddressDTO addressDTO = new AddressDTO();
		StudentDTO studentDTO = new StudentDTO();

		// 3. 테이블에 데이터 추가하기
//		departmentDTO.setDepartmentName("인공지능학");
//		departmentDTO.setDepartmentName("정보보호학");
//		userDAO.addDepartment(departmentDTO);
		
//		addressDTO.setAddressPostalCode(56789);
//		addressDTO.setAddressLine1("789 서울시 송파구");
//		addressDTO.setAddressLine2("주택 305");
//		userDAO.addAddress(addressDTO);
		
//		tml_student	1, 짱구, 22,  1(컴공), 1(123 서울시 강남구)
//		2, 철수, 21,  2(인공지능학), 3(456 서울시 동작구)
//		3. 맹구, 20, 1(컴공)	1(123 서울시 강남구)
//		4. 유리, 22, 3(정보보호학과)  3(789 서울시 송퍄구)
		studentDTO.setStudentName("짱구");
		studentDTO.setStudentAge(22);
		studentDTO.setDepartmentId(1);
		studentDTO.setAddressId(1);
		userDAO.addStudent(studentDTO);
		
		
		
		
		
	}
}
