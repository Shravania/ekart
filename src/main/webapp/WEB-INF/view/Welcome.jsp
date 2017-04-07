<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.niit.ekart.models.*" %>
<%@page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style >

.navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
.jumbotron {
      margin-bottom: 0;
    }
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
</style>
            
</head>
<body>
  
<div class="jumbotron text-center">
  <h1>Welcome Page</h1>
  
</div>


 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="aboutUs">about us</a></li>
        <li> <a href="Login"> Login </a> </li>
        
               
        <li> <a href="Signup"> SignUp </a> </li>
        
        
        
        
      </ul>
      
    </div>
  </div>
</nav>

<!--   
<div class="container">
  <div class="row">
    <div class="col-sm-3">
      
      <a href="Catagorys" class="btn btn-info" role="button">view catagorys</a>
      </div>
           <div class="col-sm-3">
      
      <a href="Users" class="btn btn-info" role="button">view users</a>
      </div>
      <div class="col-sm-3">
     
      <a href="Products" class="btn btn-info" role="button">view products</a>
      </div>
      <div class="col-sm-3">
      
       <a href="Cart" class="btn btn-info" role="button">view cart</a>
      </div>
      
      </div>
      </div> -->
                  
<footer class="container-fluid text-center">
  <p>Online Store Copyright</p>  
  <form class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Sign Up</button>
  </form>
</footer>
                  

</body>
</html>