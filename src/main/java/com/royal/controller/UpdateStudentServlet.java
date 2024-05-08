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

public class UpdateStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			int rno =Integer.parseInt(request.getParameter("rno"));
			String name = request.getParameter("name");
			int std =  Integer.parseInt(request.getParameter("std"));
			int marks =Integer.parseInt(request.getParameter("marks"));
			
			StudentBean s = new StudentBean(rno, name, std, marks);
			
			StudentDao dao = new StudentDao();
			
			int rowsAffected = dao.updateStudent(s);
			
			
			RequestDispatcher rd = null;
			if(rowsAffected > 0) 
			{
				rd = request.getRequestDispatcher("ListStudentServlet");
			}else 
			{
				rd = request.getRequestDispatcher("studreg.html");
	
			}
			rd.forward(request, response);
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
