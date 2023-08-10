package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectDemo3 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String dburl = "jdbc:mysql://localhost:3306/weja1";
	private static String user = "root";
	private static String password = "root";
	private static String driverclass = "com.mysql.cj.jdbc.Driver";
	private static String quiry;

public static void main(String[] args) {
	
	try {
		Class.forName(driverclass);
		connection=DriverManager.getConnection(dburl,user,password);
		statement=connection.createStatement();
		quiry="select *from student";
		resultSet=statement.executeQuery(quiry);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(2)+" || "
					+resultSet.getString(3)+" || "
					+resultSet.getString(4)+" || ");
		}
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		try {
		if(connection != null){
			connection.close();
			}
		if(statement != null) {
		statement.close();
		}
		if(resultSet != null){
			resultSet.close();
		}
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			}

}
