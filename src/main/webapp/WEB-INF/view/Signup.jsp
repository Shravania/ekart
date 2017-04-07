<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 20%;
    padding: 5px 5px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 5px 5px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 5px 5px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {
    float: left-center;
    width: 20%;
}

/* Add padding to container elements */
.container {
    padding: 5px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 20%;
    }
}
</style>
</head>
<body>
 <h2>SignUp</h2>
         <div style="width: 100%;text-align: center">
        <form:form action="addUser" method="post">
        <div class="form-group">
           <label><b>Email</b></label>
           <form:input class="form-control" type="text" name="mailId" path="mailId" /><br/><br/>
           </div>
           <div class="form-group">
            <label><b>first name</b></label>
            <form:input class="form-control" type="text" name="firstName" path="firstName"/><br/><br/>
            </div>
            <div class="form-group">
            <label><b>last name</b></label>
            <form:input class="form-control" type="text" name="lastName" path="lastName" /><br/><br/>
            </div>
            <div class="form-group">
            <label><b>phone number</b></label>
            <form:input class="form-control" type="text" name="phoneNumber" path="phoneNumber"  /><br/><br/>
            </div>
            <div class="form-group">
            <label><b> password</b></label>
            <form:input class="form-control" type="password" name="password" path="password"/><br/><br/>
            </div>
            <label><b></b></label>
            
    <div class="form-group">
      
      <button type="submit" class="signupbtn">Sign Up</button>
      <button type="cancel" class="cancelbtn">cancel</button>
    </div>
    </form:form>
  </div>
        
        
</body>
</html>