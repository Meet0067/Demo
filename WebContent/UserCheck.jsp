<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String str = (String) session.getAttribute("validUser");

		if (str == null || !str.equals("true")) {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("ShoppingLogin.jsp");
			rd.forward(request, response);
		} else {
		}
	%>
</body>
</html>