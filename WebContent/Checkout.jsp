<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.dao.UserDao,com.bean.UserBean,java.util.ArrayList ,com.bean.CartBean,com.bean.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<style>
body {
  background: #1C1D21;
}

h1 {
  color: #EEEFF7;
  text-align: center;
}

form {
  width: 350px;
  margin: 0 auto;
}
form .half input {
  width: 165px;
  float: left;
}
form .half input:first-child {
  margin-right: 20px;
}
form input, form button {
  box-sizing: border-box;
  display: block;
  float: left;
  width: 100%;
  padding: 20px;
  font-size: 1.3em;
  margin-bottom: 20px;
  outline: none;
  border: none;
}
form input {
  color: #1C1D21;
}
form button {
  color: #1C1D21;
  background: #EEEFF7;
  font-weight: bold;
}

	</style>
	 <jsp:include page="UserCheck.jsp"></jsp:include>
		<% 
		 		int uid = (int)session.getAttribute("userId");
				int tm =0;
				
				//ArrayList<UserBean> users = (ArrayList<UserBean>)application.getAttribute("users");
				UserDao ud = new UserDao();
				ArrayList<UserBean> users = ud.getUsers();
			
				ArrayList<CartBean> carts = (ArrayList<CartBean>)application.getAttribute("carts");
				ArrayList<ProductBean> products = (ArrayList<ProductBean>)application.getAttribute("products");
				
				UserBean ub = null;
				for(UserBean u : users){
					if(u.getUserId() == uid){
						ub = u ;
					}
				}
				for(CartBean cb : carts){
					if(ub.getUserId() == cb.getUserId()){
						 tm = tm + cb.getProduct().getPrice()*cb.getQty();
					}
			
				}
				String validUser = (String)session.getAttribute("validUser");
				if(!validUser.equals("true")){
					response.sendError(404);
				}
			
				
		 %><%=uid %>
<br><br><br><br>
<!--<form>
Total Amount  :  <%=tm %><br><br>
CreditCard Number : <input type ="number" name= "creditCardNo"/><br><br>
cvv :  <input type = "number" name ="cvv"/><br><br>
Exp Date : <input  type ="date" name = "exdate"/><br><br>
<a href ="Pay.jsp"><input  type ="button" value = "Pay" /></a>
</form>



	<h1>Checkout</h1>
	<h1>Total Amount  :  <%=tm %><br><br></h1>
<form action="Pay.jsp" style=".half">
   	<input type="text" placeholder="Card number" >
    <input type="text" placeholder="Name on card">
    
      <input type="text" placeholder="MM/YY">
      <input type="text" placeholder="CVC">
    <button type="submit" value="Pay Now"></button>
    
    </form>-->
    <div class="checkout">
  
  <h1>Checkout</h1>
	<h1>Total Amount  :  <%=tm %></h1>
  <form>
    <input placeholder="Card number" type="text" /><input placeholder="Name on card" type="text" />
    <div class="half">
      <input placeholder="MM/YY" type="text" /><input placeholder="CVC" type="text" />
    </div>
    <button type="submit">Pay Now</button>
  </form>
</div>
</body>
</html>