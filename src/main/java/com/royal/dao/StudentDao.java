package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

// Dao - Data Access Object
public class StudentDao 
{
	public int insertStudent(StudentBean s) 
	{
		String insertQuery = "INSERT INTO student(name,std,marks) VALUES('"+s.getName()+"',"+s.getStd()+","+s.getMarks()+")";
		Connection conn = DBConnection.getDbInstance();
		Statement stmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rowsAffected = stmt.executeUpdate(insertQuery);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao insertStudent() --- Db not connected");
		}
		return rowsAffected;
	}
	public int updateStudent(StudentBean s) 
	{
		String insertQuery = "UPDATE student SET name='"+s.getName()+"',std="+s.getStd()+",marks="+s.getMarks()+" WHERE rno="+s.getRno();
		Connection conn = DBConnection.getDbInstance();
		Statement stmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rowsAffected = stmt.executeUpdate(insertQuery);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao insertStudent() --- Db not connected");
		}
		return rowsAffected;
	}
	public ArrayList<StudentBean> getAllStudents() 
	{
		String selectQuery = "select * from student";
		Connection conn = DBConnection.getDbInstance();
		Statement stmt = null;
		ResultSet rs = null;
		StudentBean sbean = null;
		
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		if (conn!=null) 
		{
			try 
			{
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery(selectQuery);
				 while(rs.next()) 
				 {
					 int rno = rs.getInt(1);
					 String name = rs.getString(2);
					 int std = rs.getInt(3);
					 int marks = rs.getInt(4);
					 
					 sbean = new StudentBean(rno, name, std, marks);

					 list.add(sbean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao---getAllStudentRecords()--Db not connected");
		}
		return list;
	}
	public int deleteStudent(int rno) 
	{
		String deleteQuery = "DELETE FROM student where rno="+rno;
		Connection conn = DBConnection.getDbInstance();
		Statement stmt = null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rowsAffected = stmt.executeUpdate(deleteQuery);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao deleteStudent() --- Db not connected");
		}
		return rowsAffected;
	}
	public StudentBean getStudentByRno(int rno) 
	{
		String selectQuery = "select * from student WHERE rno="+rno;
		Connection conn = DBConnection.getDbInstance();
		Statement stmt = null;
		ResultSet rs = null;
		StudentBean sbean = null;
		
		StudentBean s = new StudentBean();
		if (conn!=null) 
		{
			try 
			{
				 stmt = conn.createStatement();
				 rs = stmt.executeQuery(selectQuery);
				 
				 rs.next(); 
				 
				 int grno = rs.getInt(1);
				 String name = rs.getString(2);
				 int std = rs.getInt(3);
				 int marks = rs.getInt(4);
					 
				 sbean = new StudentBean(rno, name, std, marks);

			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao---getStudentByRno()--Db not connected");
		}
		return sbean;
	}
	public static void main(String[] args) 
	{
		StudentBean s = new StudentDao().getStudentByRno(4);
		
		System.out.println(s.getRno() + " "  +s.getName());
		
	}
}