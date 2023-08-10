package com.jspiders.jdbc.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcInsertDemo {
	private static Connection connection;
	private static Statement statement;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filepath="E:\\WEJA1\\jdbc\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		 
		try {
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			statement=connection.createStatement();
			query="insert into student values (3,'soham','soham@g.com',8888502545)";
			int result =statement.executeUpdate(query);
			
			System.out.println("Query ok," +result+" row(s) affected");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
