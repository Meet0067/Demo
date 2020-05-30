<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminCheck.jsp"></jsp:include>
		<%
			
			ArrayList<UserBean> users = (ArrayList<UserBean>)request.getAttribute("users");
		
		%>
		<table border="1">
		<tr>
				<th>UserId</th>
				<th>FirstName</th>
				<th>Email</th>
				<th>Action</th>
		</tr>
		<%
			for(UserBean ub : users){
		%>
		<tr>
			<td><%=ub.getUserId() %></td>
			<td><%=ub.getFirstName() %></td>
			<td><%=ub.getEmail() %></td>
			<td><a href="EditUserServlet?userId=<%=ub.getUserId()%>"> Edit</a>|<a
				href="DeleteUserServlet?userId=<%=ub.getUserId()%>">Delete</a>></td>
		
		</tr>
		
		<%	} %>
		
		
		
		</table>
</body>
</html>