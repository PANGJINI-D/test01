package com.test;
import java.sql.Connection;
import java.sql.SQLException;

import com.dao.DBConnecter;
import com.dao.UserDAO;
import com.dao.UserSelectDAO;
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
		UserSelectDAO userSelectDAO = new UserSelectDAO();
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
		
//		studentDTO.setStudentName("유리");
//		studentDTO.setStudentAge(22);
//		studentDTO.setDepartmentId(3);
//		studentDTO.setAddressId(3);
//		userDAO.addStudent(studentDTO);
		
		// 4. student 테이블의 모든 정보 조회 (java에서 진행, 메서드로 만들기)
		//	- 학생번호, 이름, 전공, 우편번호, 주소1, 주소2를 조회하고 출력하기
		userSelectDAO.findStudentInfo();
		
		//	- student 테이블의 나이가 22살인 학생들의 학과 정보 출력하기
		userSelectDAO.findStudentAge22();
		
		//	- 서울시 강남구에 사는 학생의 이름과 학과정보 출력하기
		userSelectDAO.findStudentGangnam();
		
		//	- 맹구의 주소를 address 테이블의 3번으로 수정하기
		userDAO.updateAddress("맹구", 3);
		
		
		
		
	}
}
