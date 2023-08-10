package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja1","root", "root");
	
	Statement statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select * from student");
	
	while(resultSet.next()) {
		System.out.println(resultSet.getString(1)+"||"+resultSet.getString(2)+"||"+resultSet.getString(3)+"||"+resultSet.getString(4));
	}
	
	connection.close();
	statement.close();
	resultSet.close();
	}

}
