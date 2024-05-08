package com.royal.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class TestFIlter1 implements Filter 
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		PrintWriter out =	response.getWriter();
		
		// Pre-Filtering code---request
		out.println("<br>TestFIlter1----Apply :: Pre-filtering ");
		
		chain.doFilter(request, response);
		
		// Post-Filtering code----reponse
		out.println("<br>TestFIlter1----Apply :: Post-filtering ");
	}
}
