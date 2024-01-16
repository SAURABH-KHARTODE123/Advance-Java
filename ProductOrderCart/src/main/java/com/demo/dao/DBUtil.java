package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con = null;
	
	public static Connection getMyConnection() {
		if(con == null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
				con = DriverManager.getConnection(url,"root","welcome");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void closeMyConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
