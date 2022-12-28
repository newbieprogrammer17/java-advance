package com.advjava;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		
    	//Referencing to an userDao Class
    	UserDaoImpl userDao = new UserDaoImpl();
		/* userDao.save(new User("Sachin")); */
    	
    	List<User> users = userDao.getAll();
    	
    	for(int i = 0; i < users.size(); i++) {
    		System.out.println("id: " + users.get(i).getId()+" name: "+users.get(i).getName());
    	}
    }
}
