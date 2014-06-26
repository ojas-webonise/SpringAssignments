package com.mvc.architecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbOperation {
	
	@Autowired
	private DataSource dataSource;
	
	public String saveUser(String fname, String lname) {
		String message = "Inputs Not Saved..";
		if (null == fname) {
			message = "First name blank";
		} else if(null == lname) {
			message = "Last name blank";
		} else if (save(fname, lname)) {
			message = "Inputs Saved..";
		}
		return message;
	}

	private boolean save(String fname, String lname) {
		String sql = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
		int rowsInserted = 0;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setString(2, lname);
			rowsInserted = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsInserted > 0;
	}

	public String readUsers() {
		System.out.println("read users ...");
		StringBuffer result = new StringBuffer();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT first_name, last_name FROM person";
			ResultSet rs = stmt.executeQuery(sql);

			//Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");
				result.append("<br> <br> "+ first + "  "+ last);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}
