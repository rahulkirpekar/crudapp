package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//CREATE TABLE Student
//(
//	rno int PRIMARY KEY AUTO_INCREMENT,
//	name varchar(50),		
//	std int,
//	marks int
//);
public class InsertStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			String std =request.getParameter("std");
			String marks = request.getParameter("marks");
	
			StudentBean s = new StudentBean();
			
			boolean flag = false;
			String name = request.getParameter("name");
			if(name != null)
			{	
				if(name.trim().length() > 0) 
				{
					s.setName(name);
					request.setAttribute("nameValue", name);
				}else 
				{
					flag = true;
					request.setAttribute("nameErr", "<font color='red'>Please Enter valid Name</font>");
				}
			}else 
			{
				flag = true;
				request.setAttribute("nameErr", "<font color='red'>Please Enter valid Name</font>");
			}
			
			if(std != null)
			{
				if(std.trim().length() > 0) 
				{
					int stdI = Integer.parseInt(std);
					s.setStd(stdI);
					request.setAttribute("stdValue", stdI);
				}else 
				{
					flag = true;
					request.setAttribute("stdErr", "<font color='red'>Please Enter valid Std</font>");
				}
			}else 
			{
				flag = true;
				request.setAttribute("stdErr", "<font color='red'>Please Enter valid Std</font>");
			}
			
			if(marks!=null) 
			{
				if(marks.trim().length() > 0) 
				{
					int marksI = Integer.parseInt(marks);
					s.setMarks(marksI);
					request.setAttribute("marksValue", marksI);
				}else 
				{
					flag = true;
					request.setAttribute("marksErr", "<font color='red'>Please Enter valid Marks</font>");
				}
			}else 
			{
				flag = true;
				request.setAttribute("marksErr", "<font color='red'>Please Enter valid Marks</font>");
			}
			RequestDispatcher rd = null;
			if(flag) 
			{
				request.getRequestDispatcher("register.jsp").forward(request, response);
				
			}else 
			{
				StudentDao dao = new StudentDao();
	
				int rowsAffected = dao.insertStudent(s);
				
				if(rowsAffected > 0) 
				{
					rd = request.getRequestDispatcher("ListStudentServlet");
				}else 
				{
					rd = request.getRequestDispatcher("register.jsp");
				}
				rd.forward(request, response);
			}
		}else 
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
