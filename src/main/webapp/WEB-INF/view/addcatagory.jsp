<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
/* Full-width input fields */
input[type=text], input[type=text] {
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
            
</head>
<body>
<div class="container">
  <div class="panel panel-default">
    <div class="panel-heading">New Catagory</div>
    <div class="panel-body">
    <form action="Catagory" method="post">
               <div class="form-group">
           <label><b>Name</b></label>
           <input class="form-control" type="text" name="Name" path="name" /><br/><br/>
           </div>
           <div class="form-group">
            <label><b>description</b></label>
            <input class="form-control" type="text" name="description" path="description"/><br/><br/>
            </div>
            <div class="form-group">
    	<button type="submit" class="btn btn-primary">Add Catagory</button>
   	</div>
            </form>
    
 	<%-- <form:form action="Catagory" method="post" enctype="multipart/form-data" >
    <div class="form-group">
      <label for="inputdefault">Catagory Name</label>
      <form:input class="form-control" path="Name" value="${command.name}" type="text"/>
    </div>
    <div class="form-group">
      <label for="inputlg">Description</label>
      <form:input class="form-control" path="description" value="${command.description}" type="text"/>
    </div>
    
   
    <div class="form-group">
    	<button type="submit" class="btn btn-primary">Add Catagory</button>
   	</div>
  	</form:form> --%>
  	</div>
   <br>
	<h3>Category List</h3>
	
	<c:if test="${not empty Categoryitems}">
		<table class="tg">
			<tr>
				
				<th width="120">Category Name</th>
				<th width="200">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach var="c" items="${Categoryitems}">
                <tr>
                    <td>${c.name}</td>
                    <td> ${c.description }</td>
                    <td><a href="Catagory/edit?c=${c.id}">&#9745</td>
                    <td><a href="Catagory/delete?c=${c.id}">&#x274c</td>
                    
                </tr>
               </c:forEach>
		</table>
		</c:if>


</body>
</html>