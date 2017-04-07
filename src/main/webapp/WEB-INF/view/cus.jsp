<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 20%;
    padding: 5px 5px;
    margin: 5px 0;
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
.btn {
    float: left;
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
.cancelbtn, .submitbtn{
          width: 20%;
    }
}
</style>
</head>
<body>

            
               <form action="edituser?q=${x.id}" method="post">
               <div class="form-group">
           <label><b>first Name</b></label>
           <input class="form-control" type="text" name="first Name" path="firstName" /><br/><br/>
           </div>
           <div class="form-group">
            <label><b>last Name</b></label>
            <input class="form-control" type="text" name="last Name" path="lastName" /><br/><br/>
            </div>
            <div class="form-group">
            <label><b>mailId</b></label>
            <input class="form-control" type="text" name="mailId"  path="mailId"/><br/><br/>
            </div>
            <div class="form-group">
            <label><b>phone Number</b></label>
            <input class="form-control" type="text" name="phone Number" path="phoneNumber" /><br/><br/>
            </div>
            <div class="form-group">
            <label><b>password</b></label>
            <input class="form-control" type="text" name="password" path="password" /><br/><br/>
            </div>
            
            <label><b></b></label>
            <div class="form-group">
      
      <button type="submit" class="submitbtn">Submit</button>
      <button type="cancel" class="cancelbtn">Cancel</button>
    </div>
            
        </form>
       

</body>
</html>