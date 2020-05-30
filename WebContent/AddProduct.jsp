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
	
	<form action="AddProductServlet"  method ="post" >
		Name: <input type="text" name="pname" /><br> 
		Details<input type="text" name="details" /><br>
		Price: <input type="text" name="price" /><br> 
		 <input type="submit" value="AddProduct" /><br>

	</form>

</body>
</html>