package com.jspiders.jdbc.select;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSelectDemo5 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filepath="E:\\WEJA1\\jdbc\\resources\\db_info.properties";
	public static void main(String[] args) {
		
		try {
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverpath"));
			
			
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			statement=connection.createStatement();
			resultSet=statement.executeQuery(properties.getProperty("quiry"));
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2)+"||"
						+resultSet.getString(3));
			}
		} catch (IOException  | SQLException | ClassNotFoundException e2) {
			e2.printStackTrace();
			e2.printStackTrace();
			e2.printStackTrace();
		}finally {
			try {
			if(connection != null) {
				
					connection.close();
					
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();;
			}if(fileReader != null) {
				fileReader.close();
			}
				} catch (SQLException | IOException e) {
					
					e.printStackTrace();
				} 
			}
		} 
		
	}


