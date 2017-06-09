package com.hanbit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataControl {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hanbit"
				+ "?characterEncoding=utf8&useSSL=false";
		String user = "hanbit";
		String password = "hanbit";
		
		Connection conn = null;
		ResultSet resultSet = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
			
			String sql = "SELECT no, name, age, addr FROM tbl_students";
			
			Statement stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()) {
				int no = resultSet.getInt("no");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String addr = resultSet.getString("addr");
				
				System.out.println(no + "/" + name + "/" + age + "/" + addr);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
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
