<html xmlns="http://www.w3.org/1999/xhtml">
<%@page session="true" %> 
<head>
<title>Login Page of Admin</title>
</head>
<body>

	<%@include file="header.jsp"%>

	<form action="TestLoginCookieServlet" method="post">
		<table>
			<tr>
				<td>UserName </td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>Password </td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"/></td>
			</tr>
		</table>		
	</form>

<%@include file="footer.jsp"%>
	
</body>
</html>
