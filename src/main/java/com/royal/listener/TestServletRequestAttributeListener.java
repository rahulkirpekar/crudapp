package com.royal.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;

public class TestServletRequestAttributeListener implements ServletRequestAttributeListener 
{
	public void attributeAdded(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttributeListener---attributeAdded()");
	}
	public void attributeReplaced(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttributeListener---attributeReplaced()");
	}
	public void attributeRemoved(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttributeListener---attributeRemoved()");
	}
}
