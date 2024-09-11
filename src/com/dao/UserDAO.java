package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.domain.AddressDTO;
import com.domain.DepartmentDTO;
import com.domain.StudentDTO;

public class UserDAO {		// 삽입, 삭제, 수정 연산 메서드
	
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
	// department 테이블에 데이터 추가하기
	// 코드 중복 어떻게 줄일지 고민해보기..
	public void addDepartment(DepartmentDTO departmentDTO) {
		String query = "INSERT INTO TBL_DEPARTMENT "
				+ "VALUES(SEQ_DEPARTMENT.NEXTVAL, ?)";
		
		try {
			// db 연결객체 얻기
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			// 쿼리문 완성
			preparedStatement.setString(1, departmentDTO.getDepartmentName());
			
			// 삽입연산은 받아올 결과가 없기 때문에 executeUpdate
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addDepartment() 메서드 sql 오류");
			e.printStackTrace();
		} finally {
			 try {
		            if(preparedStatement != null) {
		               preparedStatement.close();
		            }
		            if(connection != null) {
		               connection.close();
		            }
		         } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }
		}
	}
	
	// address 테이블에 데이터 추가하기
		public void addAddress(AddressDTO addressDTO) {
			String query = "INSERT INTO TBL_ADDRESS "
					+ "VALUES(SEQ_ADDRESS.NEXTVAL, ?, ?, ?)";
			
			try {
				// db 연결객체 얻기
				connection = DBConnecter.getConnection();
				preparedStatement = connection.prepareStatement(query);
				
				// 쿼리문 완성
				preparedStatement.setInt(1, addressDTO.getAddressPostalCode());
				preparedStatement.setString(2, addressDTO.getAddressLine1());
				preparedStatement.setString(3, addressDTO.getAddressLine2());
				
				// 삽입연산은 받아올 결과가 없기 때문에 executeUpdate
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("addAddress() 메서드 sql 오류");
				e.printStackTrace();
			} finally {
				 try {
			            if(preparedStatement != null) {
			               preparedStatement.close();
			            }
			            if(connection != null) {
			               connection.close();
			            }
			         } catch (SQLException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			         }
			}
		}
		
		// student 테이블에 데이터 추가하기
		public void addStudent(StudentDTO studentDTO) {
			String query = "INSERT INTO TBL_STUDENT "
					+ "VALUES(SEQ_STUDENT.NEXTVAL, ?, ?, ?, ?)";
			
			try {
				// db 연결객체 얻기
				connection = DBConnecter.getConnection();
				preparedStatement = connection.prepareStatement(query);
				
				// 쿼리문 완성
				preparedStatement.setString(1, studentDTO.getStudentName());
				preparedStatement.setInt(2, studentDTO.getStudentAge());
				preparedStatement.setInt(3, studentDTO.getDepartmentId());
				preparedStatement.setInt(4, studentDTO.getAddressId());
				
				// 삽입연산은 받아올 결과가 없기 때문에 executeUpdate
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("addStudent() 메서드 sql 오류");
				e.printStackTrace();
			} finally {
				 try {
			            if(preparedStatement != null) {
			               preparedStatement.close();
			            }
			            if(connection != null) {
			               connection.close();
			            }
			         } catch (SQLException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			         }
			}
		}

		
	// 맹구의 주소를 address 테이블의 3번으로 수정하기
	public void updateAddress(String studentName, int newAddressId) {
		String query = "UPDATE TBL_STUDENT ts "
					+ "SET ts.ADDRESS_ID = ? "
					+ "WHERE ts.STUDENT_NAME = ?";
		
		try {
			// db 연결
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//쿼리 완성하기
			preparedStatement.setInt(1, newAddressId);
			preparedStatement.setString(2, studentName);
			//실행
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
                System.out.println(studentName + " 주소 업데이트 성공");
            } else {
                System.out.println("주소 업데이트 실패");
            }
		} catch (SQLException e) {
			System.out.println("updateAddress() 메서드 sql 오류");
			e.printStackTrace();
		} finally {
			try {
	            if (preparedStatement != null) {
	               preparedStatement.close();
	            }
	            if (connection != null) {
	               connection.close();
	            }
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
		}
	}
		
		
		
}
