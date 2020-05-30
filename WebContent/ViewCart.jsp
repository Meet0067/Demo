<%@page import="org.omg.CORBA.portable.ApplicationException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.CartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ShoppingIndex.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="UserCheck.jsp"></jsp:include>
	<a href="Logout"><input type="button" value="Logout" /><br></a>
	<br>
	<form >
	<a href="Checkout.jsp">
  		 <input type="button" value="Checkout" />
	</a>
	</form>
	<br>
	

	<%
		ArrayList<CartBean> carts = (ArrayList<CartBean>)application.getAttribute("carts");
		Integer uid = (Integer)session.getAttribute("userId");
		String  blank = "                      ";
		String validUser = (String)session.getAttribute("validUser");
	/*	if(!validUser.equals("true")){
			response.sendError(404);
		}
	*/
	%>
	<% for(CartBean c : carts){
	%>
	<%
				if(c.getUserId() == uid){
					String img ="images/"  + c.getProduct().getName()   + ".jpg";
					
	%>
	
	<img border="0" src=<%=img %> width="280" height="200">
	
	|									<%=c.getProduct().getName() %>
	|      								<%= c.getProduct().getPrice() %>
	|									<%= c.getQty() %>
	<BR><br>
	<%
				}
	%>
	
	<%		}
	%>
	
</body>
</html>