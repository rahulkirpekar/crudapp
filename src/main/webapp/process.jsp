<?xml version="1.0" encoding="UTF-8" ?>
<%@page errorPage="error.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
</head>
<body>
<%  
  
		String num1=request.getParameter("n1");  
		String num2=request.getParameter("n2");  
		  
		int a=Integer.parseInt(num1);  
		int b=Integer.parseInt(num2);  
		int c=a/b;  
		out.print("division of numbers is: "+c);  
		  
%> 
</body>
</html>
