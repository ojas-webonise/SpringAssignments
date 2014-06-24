package com.sample.jsp;

import java.sql.*;

public class DbConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/demodb";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	private Connection conn = null;
	private Statement stmt = null;
	
	
	public DbConnection() {
		System.out.println(" constructor Called >>>>>>>>>>>>>>>>>>>>>>>");
		openDbConnection();
	}

	private void openDbConnection(){
		try {
			//STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 3: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		try{
			if(stmt!=null)
				stmt.close();
		} catch(SQLException se2) {
		}
		try{
			if(conn!=null)
				conn.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}

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
			openDbConnection();
			stmt = conn.createStatement();
			String sql = "SELECT first_name, last_name FROM person";
			ResultSet rs = stmt.executeQuery(sql);

			//Extract data from result set k
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

