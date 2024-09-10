package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	
	// 리턴타입이 Connection 객체인 메서드
	public static Connection getConnection() {
		Connection conn = null;
		
		// 드라이버 연결에 필요한 정보
		String userName = "web5";
		String userPassword = "0910";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 드라이버를 메모리에 할당
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userName, userPassword);
			System.out.println("===== 드라이버 연결 성공 =====");
			
		} catch (ClassNotFoundException e) {
			System.out.println("===== 드라이버 로딩 실패 =====");
			e.printStackTrace();
		} catch (SQLException e) {	// 연결에 필요한 정보가 잘못되었을 때 발생함
			System.out.println("===== 드라이버 연결 정보 오류 =====");
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
