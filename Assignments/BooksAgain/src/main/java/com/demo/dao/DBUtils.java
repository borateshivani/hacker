package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	static Connection conn;
	
	static {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac99";
			conn = DriverManager.getConnection(url,"dac99","welcome");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
public static Connection getMyConnection() {
	try {
		if(conn==null) {
			String url="jdbc:mysql://192.168.10.127:3306/dac99";
			Connection conn = DriverManager.getConnection(url,"dac99","welcome");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());;
	}
	return conn;
}

public static void closeMyConnection() throws SQLException {
	if(conn!=null && !conn.isClosed()) {
		conn.close();
	}
}
}
