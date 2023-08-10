package com.jspiders.jdbc.delete;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDeleteDemo {
	
	private static Connection connection;
	private static Statement statement;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filepath="E:\\WEJA1\\jdbc\\resources\\db_info.properties";
	private static  String query;
	
	public static void main(String[] args) {
		 
		try {
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverpath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			statement=connection.createStatement();
			query="delete from student where id = 3";
			
			int result=statement.executeUpdate(query);
			
			System.out.println("Query ok," +result+" row(s) affected");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(connection != null) {
				
					connection.close();}
			
			if(statement != null) {
				statement.close();
			}
			if(fileReader != null) {
				fileReader.close();
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}


