<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="description" content="Login - Register Template">
    <meta name="author" content="Lorenzo Angelino aka MrLolok">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Pmain.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            background-color: #303641;
        }
    </style>
</head>

<body style="padding-top: 50px;">
<%
		String emailError = (String)request.getAttribute("emailError");
		String passwordError = (String)request.getAttribute("passwordError");
		String email = (String)request.getAttribute("email");
		String pwd = (String)request.getAttribute("password");
		String LError = (String)request.getAttribute("LoginError");
		String notValid  =(String)request.getAttribute("ValidUser");
	
	
	%>


    <div id="container-login" >
        <div id="title">
            <i class="material-icons lock">lock</i> Login
        </div>

        <form  action="Authenticate" method="post"><%= notValid!=null? notValid :"" %>
            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">face</i>
                </div>
                <input id="username" placeholder="Email" type="text" name = "email" value="<%= email==null?"":email %>"  required class="validate" autocomplete="off"><%= emailError ==null?"":emailError %>
            </div>

            <div class="clearfix"></div>

            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">vpn_key</i>
                </div>
                <input id="password" placeholder="Password" type="password" name="password" required class="validate" autocomplete="off" "password" value="<%= pwd ==null?"":pwd %>"><%= passwordError ==null?"":passwordError%>
            </div>

            
	<br />
            <input type="submit" value="Log In" />
        </form>
        <div class="privacy">
            <a href="#">Privacy Policy</a>
        </div>

        <div class="register">
            Don't have an account yet?
            <a href="signup.jsp"><button id="register-link">Register here</button></a><br><br><%= LError ==null?"": LError %>
        </div>
    </div>
</body>

</html>