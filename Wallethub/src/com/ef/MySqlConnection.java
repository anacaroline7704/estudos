package com.ef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static final String CLASS_FOR_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/wallethub?useTimezone=true&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	
	/**
	 * Private default constructor in order to avoid create new instance of
	 * that, forcing to use static getConnection method for new database connection.
	 */
	private MySqlConnection() {
		
	}
	
	/**
	 * Validate before create a new connection wheter is there an active connection, and then return.
	 * */
	protected static Connection getConnection() {

		try {

			Class.forName(CLASS_FOR_NAME);

		} catch (ClassNotFoundException cnfe) {
			
			cnfe.printStackTrace();
		}
		
		try {
			
			if(connection == null) {
			
				connection = DriverManager.getConnection(URL_CONNECTION, USERNAME, PASSWORD);
				//connection.setAutoCommit(Boolean.FALSE);
			}
			
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
		}
		
		return connection;
	}
}
