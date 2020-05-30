<%@page import="com.bean.ProductBean"%>
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
		ArrayList<ProductBean> products = (ArrayList<ProductBean>)application.getAttribute("products");
	%>

 	<a href="AddProduct.jsp">Add Product</a>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>details</th>
			<th>Action</th>
		</tr>

		<%
			for (ProductBean p : products) {
		%>
		<tr>
			<td><%=p.getProductId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getDetails()%></td>
			<td><a href="EditUserDB1?productId=<%=p.getProductId()%>">Edit</a> | <a href="DeleteProductServlet?productId=<%=p.getProductId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>      


	</table>
</body>
</html>