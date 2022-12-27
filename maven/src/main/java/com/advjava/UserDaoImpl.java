package com.advjava;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UserDaoImpl implements UserDao{
	
	
	
	@Override
	public void save(User u) {
	
		try {
			Properties props = new Properties();
			try {
				props.load(App.class.getResourceAsStream("/config/db.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			var conn = Database.instance().connectDb(props);
			
			var stmt = conn.prepareStatement("Insert into users (name) values (?);");
			
			stmt.setString(1, u.getName());
			
			stmt.executeUpdate();
			System.out.println("User Inserted Successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Failed.");
		}
		
	}

	@Override
	public Optional<User> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		Properties props = new Properties();
		try {
			props.load(App.class.getResourceAsStream("/config/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			var conn = Database.instance().connectDb(props);
			
			var stmt = conn.createStatement();
			var rs = stmt.executeQuery("Select * from users;");
			while(rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

}
