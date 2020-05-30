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

   <div id="container-login" >
        <div id="title">
            <i class="material-icons lock">lock</i> Update Password
        </div>

        <form  action="UpdatePasswordServlet" method="post">
       
        <input type="hidden" name="userId" value="${user.userId}" /> 
        <div class="clearfix"></div>
 <br><br><br>
             <div class="input">
                <div class="input-addon">
                    <i>* * * * * New Password * * * * * </i>
                </div>
                <input id="password"  type="password" name = "password" required class="validate" autocomplete="off">
            </div>
<br>
       
          
<br>
            
            <div class="clearfix"></div>
            
            
	<br />
            <input type="submit" value="Update" />
        </form>
        

        
    </div>
</body>

</html>