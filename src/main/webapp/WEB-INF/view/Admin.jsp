<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<style >
.module {
      background: 
      linear-gradient(
      to bottom,
      rgba(0, 0, 0, 0),
      rgba(0, 0, 0, 0.4)
      )
       width: 100%;
 	  height: 100%;
      position:relative;
      overflow: hidden;
      margin: 20px;
     }
.module > header {
 	 position: absolute;
 	 bottom: 0;
 	 left: 0;
     width: 100%;
     padding: 20px 10px;
     }
.module > header > h1 {
    margin: 0;
    text-shadow: 0 1px 0 black;
    }
* {
    box-sizing: border-box;
    }
</style>
</head>
<body>
<div class="module">
	<center>
		<h1>Administrator Operations</h1>
		
			<h3><a href="<c:url value="/Catagory"/>">Add Catagory</a><br><br></h3>
			<h3><a href="<c:url value="/Product"/>"> Add Product</a></h3>
	</center>
  </div>	

</body>
</html>