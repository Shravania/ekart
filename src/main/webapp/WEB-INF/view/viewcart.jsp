<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Shopping Zone</title>

<style>
.table>tbody>tr>td, 
.table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and( max-width:20px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
</style>
</head>
<body>
<!-- <style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style> -->

</head>
<%-- <body>

            <form action="Cart">
                <table border="1" cellpadding="5">
                
                    <caption>
                        <h2>
                            view cart
                        </h2>
                    </caption>
                    <tr>
                        <th> product name</th>
                        
                        <th> price</th>
                        <th> quantity</th>
                        
                        <th> delete</th>
                    </tr>
                    <c:forEach var="k" items="${cartItems}">
                <tr>
                    <td>${k.cartGroupId.productId.name}</td>
                    <td> ${k.cartGroupId.productId.price}</td>
                    <td> ${k.quantity}</td>
                    <td><a href="../deletecart/${k.cartGroupId.productId.id}">&#x274c</td>
                    
                </tr>
               </c:forEach>
            
                </table>
            </form>
        
        

</body>
</html> --%>
<body>
 <form action="Cart">
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
				    <tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="k" items="${cartItems}">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
									<div class="col-sm-10">
										<h4 class="nomargin">${k.cartGroupId.productId.name}</h4>
										
									</div>
								</div>
							</td>
							<td data-th="Price"> ${k.cartGroupId.productId.price}</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="${k.quantity}"  min='1' max='5'> <button class="fa fa-refresh"></button>
								
							</td>
							<td data-th="Subtotal" class="text-center">${k.cartGroupId.productId.price}</td>
							<td class="actions" data-th="">
								
								<a href="<c:url value='../deletecart/${k.cartGroupId.productId.id}'/>" class="btn btn-danger btn-sm"> <i class="fa fa-trash-o"></i></a>								
							</td>
						</tr>
	  					</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong><span id="sum">total</span></strong></td>
						</tr>
						<tr>
							<td><a href="../" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"></td>
							
						</tr>
					</tfoot>
				</table>
            </div>
            
           </form>
           
      </body>
      </html>