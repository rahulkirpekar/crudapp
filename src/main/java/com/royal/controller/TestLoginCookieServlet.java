package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TestLoginCookieServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("userName");
		String password = request.getParameter("password");		
		boolean flag = false;
		if (((username.trim().length()>0) && (username!=null)) && ((password.trim().length()>0) && (password!=null))) 
		{
			if(username.equals("rahulkirpekar") && password.equals("admin@123")) 
			{
				Cookie cookie = new Cookie("userName", username);
				response.addCookie(cookie);
				System.out.println("-------in if");
				
				Cookie c[] = request.getCookies();

				for (int i = 0; i < c.length; i++) 
				{
					System.out.println(c[i].getName() + " " +c[i].getValue());
					
				}
						
			}else 
			{
				flag = true;
			}
		} else 
		{
			flag = true;
		}
		System.out.println("flag - " + flag);
		RequestDispatcher rd = null;
		if (flag) 
		{
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);		

		}else 
		{
			System.out.println("else---register.jsp");
			
			response.getWriter().print("<h1>Success</h1>");
//			rd = request.getRequestDispatcher("RegisterServlet");
		}
//		rd.forward(request, response);		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
