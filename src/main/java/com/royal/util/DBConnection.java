package com.royal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton Desing Pattern---DBConnection------->MYSQL(Database)
public class DBConnection 
{
	// 1) Make credentials
	private static final String URLNAME="jdbc:mysql://localhost:3306/club32";
	private static final String DRIVERCLASS="com.mysql.cj.jdbc.Driver";//---jar
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	private static Connection conn = null;
	
	// 2) Create getConnection method
	private static Connection getConnection() 
	{
		Connection conn = null;
		try 
		{
			// 3) Load DriverClass
			Class.forName(DRIVERCLASS);
			
			// 4) Pass credentials into DriverManager's getConnection method
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getDbInstance() 
	{
		if(conn == null) 
		{
			conn = DBConnection.getConnection();
		}
		return conn;
	}
//	public static void main(String[] args) 
//	{
//		Connection conn = DBConnection.getDbInstance(); 
//		System.out.println(conn);
//	}
}






