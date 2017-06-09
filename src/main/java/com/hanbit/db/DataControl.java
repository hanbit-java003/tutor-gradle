package com.hanbit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataControl {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hanbit"
				+ "?characterEncoding=utf8&useSSL=false";
		String user = "hanbit";
		String password = "hanbit";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
