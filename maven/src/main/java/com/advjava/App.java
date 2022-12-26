package com.advjava;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Database db = Database.instance();
        
        try {
			db.connectDb();
		} catch (SQLException e) {
			System.out.println("Cannot Connect to Database.");
		}
        
        System.out.println("Connected to Database.");
        
        try {
			db.closeDb();
		} catch (SQLException e) {
			System.out.println("Cannot close Database Connection.");
		}
    }
}
