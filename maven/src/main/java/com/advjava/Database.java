package com.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	
	//implementing singleton pattern for the database class.
	
	public static Database db = new Database();
	public static String URL = "";
	public static Connection conn;
	
	// static instance of class globally accessible.
	public static Database instance() {
		return db;
	}
	
	private Database() {
		// private constructor so class cannot be initiated from outside.
	}
	
	// database connection method can be called throughout the project.
	public static Connection connectDb(Properties props) throws SQLException {
		String server = props.getProperty("server");
		String port = props.getProperty("port");
		String database = props.getProperty("database");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		
		URL = String.format("jdbc:mysql://%s:%s/%s", server, port, database);
		System.out.println("url : "+URL);
		conn = DriverManager.getConnection(URL, user, password);
		return conn;
	}
	
	// database close method.
	public void closeDb() throws SQLException {
		conn.close();
	}

}
