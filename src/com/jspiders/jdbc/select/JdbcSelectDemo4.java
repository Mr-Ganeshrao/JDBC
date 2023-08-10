package com.jspiders.jdbc.select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSelectDemo4 {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String dburl="jdbc:mysql://localhost:3306/weja1";
	private static String driverpath="com.mysql.cj.jdbc.Driver";
	private static String filepath="E:\\WEJA1\\jdbc\\resources\\db_info.properties";
	private static String quiry;

	public static void main(String[] args) {
		try {
			Class.forName(driverpath);
			
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			
			
			connection=DriverManager.getConnection(dburl,properties);
			
			statement=connection.createStatement();
			
			quiry="select * from student";
			resultSet=statement.executeQuery(quiry);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2)+" || "
									+resultSet.getString(3));
			}
			
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			try {
			if(connection != null) {
				
					connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
			if(fileReader != null) {
				fileReader.close();
			}
				
			} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}

	}


