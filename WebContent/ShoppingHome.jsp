<%@page import="com.bean.ProductBean"%>
<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
float: left;
    height: auto;
    width: 30%;
    padding: 0 20px;
 	padding-top:20px;  
}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}</style>
</head>
<body>
			
	
	<%
		ArrayList<ProductBean> products = (ArrayList<ProductBean>)application.getAttribute("products");
		String space = "                              ";
		String validUser = (String)session.getAttribute("validUser");
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		if(!validUser.equals("true")){
			response.sendError(414);
		}
	
	%>
	<a href="ViewCart.jsp"><input type="button" value="ViewCart" Onclick="ViewCart.jsp"/></a> 	
	<a href="Logout"><input type="button" value="Logout"/></a>
	<a href="EditUserServlet?userId=<%=userId%>"><input type="button" value="Password Change"/></a><br><br>
	<%=space %>
	<%
		for (ProductBean p : products) {
			System.out.println(p.getName());
			String img ="images/"  + p.getName()   + ".jpg";
	%>
	
	<div class="card">
  <img src=<%=img %> alt=<%=p.getName() %> style="width:100%" height="200px" >
  <div><h1><%=p.getDetails() %></h1></div>
  <p class="price"><%=p.getPrice() %></p>
  
  <p><a href="AddCartServlet?productId=<%=p.getProductId()%>"><button >Add to Cart</button></a></p>
</div>
  
	<%
		}
	%>

	
</body>
</html>