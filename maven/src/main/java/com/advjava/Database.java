package com.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	//implementing singleton pattern for the database class.
	
	public static Database db = new Database();
	public static String URL = "jdbc:mysql://localhost:3306/omecedemodb";
	public static Connection conn;
	
	// static instance of class globally accessible.
	public static Database instance() {
		return db;
	}
	
	private Database() {
		// private constructor so class cannot be initiated from outside.
	}
	
	// database connection method can be called throughout the project.
	public static void connectDb() throws SQLException {
		conn = DriverManager.getConnection(URL, "root", "pass@123");
	}
	
	// database close method.
	public void closeDb() throws SQLException {
		conn.close();
	}

}
