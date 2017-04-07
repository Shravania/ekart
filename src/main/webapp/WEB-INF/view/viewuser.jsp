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

            <form action="/Users">
                <table border="1" cellpadding="5">
                    <caption><h2>view users</h2></caption>
                    <tr>
                        <th> user name </th>
                        <th> user phonenumber </th>
                        <th> edit</th>
                        <th> delete</th>
                    </tr>
                     <c:forEach var="q" items="${users}">
                <tr>
                    <td>${q.firstName } </td>
                    <td>${q.phoneNumber }</td>
                    
                    <td><a href="edituser?q=${q.id}">&#9745</td>
                    <td><a href="deleteuser?q=${q.id}">&#x274c</td>
                    
                </tr>
               </c:forEach>
            
                </table>
            </form>

</body>
</html>