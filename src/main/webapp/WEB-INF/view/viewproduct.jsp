<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.niit.ekart.models.*" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <form action="Products"> 
            <table border="1" cellpadding="5">
            <caption><h2>View products</h2></caption>
            <tr>
                <th>Productname</th>
                <th>Producttype</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="p" items="${products}">
             <tr>
                         
                         <td>${p.name }</td>
                         <td>${p.description}</td>
                        <td><a href="Product?p=${p.id}">&#9745</a></td>
                        <td><a href="delete?p=${p.id}">&#x274c</a></td>                        
                        
                        
                    </tr>
                             
                 </c:forEach>
            </table>

</form> 
</body>
</html>