package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectDemo {
	public static void main(String[] args) {
		 
		try {
			//1. Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. open connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja1?user=root&password=root");
			
			//3. create p/*-    and prepair statement
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from student");
			
			//4.process the result
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"||"+resultSet.getString(2)+"||"+resultSet.getString(3)+"||"+resultSet.getString(4));
			}
			
			//5. close connestion
			
			connection.close();
			statement.close();
			resultSet.close();
		}  catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

}}
