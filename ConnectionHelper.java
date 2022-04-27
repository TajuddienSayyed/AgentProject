package com.java.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String url = rb.getString("url");
		String driver = rb.getString("driver");
		String user = rb.getString("user");
		String pwd = rb.getString("password");
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
}