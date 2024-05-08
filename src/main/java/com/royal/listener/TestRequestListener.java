package com.royal.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class TestRequestListener implements ServletRequestListener 
{
	public void requestInitialized(ServletRequestEvent sre) 
	{
		System.out.println("TestRequestListener---requestInitialized()");
	}
	public void requestDestroyed(ServletRequestEvent sre) 
	{
		System.out.println("TestRequestListener---requestDestroyed()");
	}
}
