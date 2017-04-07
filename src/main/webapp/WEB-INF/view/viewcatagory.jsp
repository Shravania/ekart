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
<style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>

</head>
<body>

            <form action="Catagorys">
                <table border="1" cellpadding="5">
                
                    <caption>
                        <h2>
                            view catagory
                        </h2>
                    </caption>
                    <tr>
                        <th> Catagory name </th>
                        <th> Catagory description </th>
                        <th> edit</th>
                        <th> delete</th>
                    </tr>
                    <c:forEach var="c" items="${catagorys}">
                <tr>
                    <td>${c.name}</td>
                    <td> ${c.description }</td>
                    <td><a href="Catagory?c=${c.id}">&#9745</td>
                    <td><a href="deletecatagory?c=${c.id}">&#x274c</td>
                    
                </tr>
               </c:forEach>
            
                </table>
            </form>
        
        
</body>
</html>