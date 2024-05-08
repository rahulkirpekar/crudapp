package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("userName");
		String password = request.getParameter("password");		
		boolean flag = false;
		if (((username.trim().length()>0) && (username!=null)) && ((password.trim().length()>0) && (password!=null))) 
		{
			if(username.equals("admin") && password.equals("admin@123")) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
			}else 
			{
				flag = true;
			}
		} else 
		{
			flag = true;
		}
		RequestDispatcher rd = null;
		if (flag) 
		{
			rd = request.getRequestDispatcher("login.jsp");
		}else 
		{
			rd = request.getRequestDispatcher("register.jsp");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
