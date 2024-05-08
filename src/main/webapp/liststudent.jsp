<%@page import="jakarta.servlet.http.HttpSession" session="true"%>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>

<%
	String username = 	(String)session.getAttribute("username");
	if(username!=null)
	{
%>
	<table border='1'>
		<tr>
			<td>Rno</td>
			<td>Name</td>
			<td>Std</td>
			<td>Marks</td>
			<td>Action</td>
		</tr>
	<%
			ArrayList<StudentBean> list = (ArrayList<StudentBean>)request.getAttribute("list");
			
			for(int i = 0 ; i < list.size();i++)
			{
				StudentBean s = list.get(i);
	%>	
				<tr>
					<td><%=s.getRno()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getStd()%></td>
					<td><%=s.getMarks()%></td>
					<td><a href='EditStudentServlet?rno=<%=s.getRno()%>'>EDIT</a> | <a href='DeleteStudentServlet?rno=<%=s.getRno()%>'>DELETE</a></td>
				</tr>
		<%
			}
	}else
	{
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
		%>
	</table>
</body>
</html>