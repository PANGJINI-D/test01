package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectDAO {	// SELECT 연산 메서드
	public Connection conn;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
	// 학생 정보 조회 메서드
	// 학생번호, 이름, 전공, 우편번호, 주소1, 주소2 출력
	public void findStudentInfo() {
		String query = "SELECT ts.STUDENT_ID, ts.STUDENT_NAME, td.DEPARTMENT_NAME, ta.ADDRESS_POSTAL_CODE, ta.ADDRESS_LINE1, ta.ADDRESS_LINE2 "
				+ "FROM TBL_STUDENT ts, TBL_DEPARTMENT td, TBL_ADDRESS ta "
				+ "WHERE ts.DEPARTMENT_ID = td.DEPARTMENT_ID "
				+ "AND ts.ADDRESS_ID = ta.ADDRESS_ID "
				+ "ORDER BY STUDENT_ID";
		
		try {
			//db 연결객체 얻기
			conn = DBConnecter.getConnection();
			preparedStatement = conn.prepareStatement(query);
			//결과 조회
			resultSet = preparedStatement.executeQuery();
			
			//조회 결과를 모두 출력
			System.out.println("***** 1. 학생 정보 출력 *****");
			while(resultSet.next()) {
				System.out.println("[ 학생번호 ] " + resultSet.getInt(1));
                System.out.println("[ 이름 ] " + resultSet.getString(2));
                System.out.println("[ 전공 ] " + resultSet.getString(3));
                System.out.println("[ 우편번호 ] " + resultSet.getInt(4));
                System.out.println("[ 주소1 ] " + resultSet.getString(5));
                System.out.println("[ 주소2 ] " + resultSet.getString(6));
                System.out.println("---------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("findStudentInfo() 메서드 오류");
			e.printStackTrace();
		}	
	}
	
	
	// 나이가 22살인 학생들의 학과 정보 출력 메서드
	public void findStudentAge22() {
		String query = "SELECT ts.STUDENT_NAME, ts.STUDENT_AGE, td.DEPARTMENT_NAME "
				+ "FROM TBL_STUDENT ts, TBL_DEPARTMENT td "
				+ "WHERE ts.DEPARTMENT_ID = td.DEPARTMENT_ID "
				+ "AND ts.STUDENT_AGE = 22";
		
		try {
			//db 연결객체 얻기
			conn = DBConnecter.getConnection();
			preparedStatement = conn.prepareStatement(query);
			//결과 조회
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("***** 2. 22살인 학생들의 학과정보 *****");
			while(resultSet.next()) {
				System.out.println("[ 이름 ] " + resultSet.getString(1));
				System.out.println("[ 나이 ] " + resultSet.getInt(2));
				System.out.println("[ 전공 ] " + resultSet.getString(3));
				System.out.println("---------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("findStudentAge22() 메서드 오류");
			e.printStackTrace();
		}
	}
	
	
	//서울시 강남구에 사는 학생의 이름과 학과정보 출력하기
	public void findStudentGangnam() {
		String query = "SELECT ts.STUDENT_NAME, td.DEPARTMENT_NAME, ta.ADDRESS_LINE1 "
				+ "FROM TBL_STUDENT ts, TBL_ADDRESS ta, TBL_DEPARTMENT td "
				+ "WHERE ts.DEPARTMENT_ID = td.DEPARTMENT_ID  "
				+ "AND ts.ADDRESS_ID = ta.ADDRESS_ID "
				+ "AND ta.ADDRESS_LINE1 LIKE '%서울시 강남구%'";
		
		try {
			//db 연결객체 얻기
			conn = DBConnecter.getConnection();
			preparedStatement = conn.prepareStatement(query);
			//결과 조회
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("***** 3. 강남구에 사는 학생들의 이름, 학과정보 *****");
			while(resultSet.next()) {
				System.out.println("[ 이름 ] " + resultSet.getString(1));
				System.out.println("[ 전공 ] " + resultSet.getString(2));
				System.out.println("[ 주소1 ] " + resultSet.getString(3));
				System.out.println("---------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("findStudentGangnam() 메서드 오류");
			e.printStackTrace();
		}
	}
}
