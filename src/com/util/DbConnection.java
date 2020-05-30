package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection()
	{
		String Driver= "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/shopping";
		String userName = "root";
		String password = "root";
		Connection con = null;
		
		try {
			Class.forName(Driver);
		
			con = DriverManager.getConnection(url,userName,password);
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("Something went wrong in establing connection");
	}
	return con;
	}
}
