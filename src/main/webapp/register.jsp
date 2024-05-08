<%@page import="jakarta.servlet.http.Cookie"%>
<%@page import="jakarta.servlet.http.HttpSession" session="true"%>
<head>
<title>Student Registration Page</title>
</head>
<body>
	<%@include file="header.jsp"%>
<%
	Cookie c[] = request.getCookies();

	out.print("c : " + c);
	if(c[0].getValue().equals("rahulkirpekar"))
	{

// 	String username = 	(String)session.getAttribute("username");
// 	if(username!=null)
// 	{
%>
		<form action='InsertStudentServlet'>                     
			<table>                                              
					<tr>                                         
					<td><h2>Student Registration Page</h2></td> 
					<td></td>                                    
				</tr>                                            
				<tr>                                             
					<td>Name : </td>                             
					<td><input type='text' value='${nameValue}' name='name'/>${nameErr}</td>
				</tr>                                             
				<tr>                                              
					<td>Std : </td>                               
					<td><input type='text' value='${stdValue }' name='std'/>${ stdErr}</td>        
				</tr>                                             
				<tr>                                              
					<td>Marks : </td>                             
					<td><input type='text' value='${ marksValue}' name='marks'/>${marksErr }</td>      
		
				</tr>                                           
				<tr>                                            
					<td> </td>                                  
					<td><input type='submit'/></td>             
				</tr>                                           
			</table>              
		</form>		
<%
	}else{
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
%>		

<%@include file="footer.jsp"%>
</body>
</html>
