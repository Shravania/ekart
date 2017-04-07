<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
    background:#333;
}
.form_bg {
    background-color:#eee;
    color:#666;
    padding:20px;
    border-radius:10px;
    position: absolute;
    border:1px solid #fff;
    margin: auto;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    width: 320px;
    height: 280px;
}
.align-center {
    text-align:center;

  }
</style>
</head>
<body>
<form:form action="User" method="post">
<div class="container">
    <div class="row">
        <div class="form_bg">
            
                 <h2 class="text-center">Login Page</h2>
                <br/>
                <div class="form-group">
                    <form:input type="email" class="form-control" id="userid" placeholder="User id" path="mailId"/>
                </div>
                <div class="form-group">
                    <form:input type="password" class="form-control" id="pwd" placeholder="Password" path="password"/>
                </div>
                <br/>
                <div class="align-center">
                    <button type="submit" class="btn btn-default" id="login">Login</button>
                </div>
             <p class="message">
				Not Registered? <a href="Signup" class="">Register here</a>
			</p>
        </div>
    </div>
   </div>
   </form:form>
    
</body>
</html>