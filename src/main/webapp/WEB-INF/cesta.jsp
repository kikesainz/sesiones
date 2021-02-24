
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tienda de discos</title>
    <style>
    body{
    
  		font-family: Arial, Helvetica, sans-serif;

    }

    </style>
</head>
<body>

<div  align="center">
	<h1>Tu carrito</h1>
	<table border="1" cellpadding="5" align="center">
	  <tr>
	    <th>Cantidad</th>
	    <th>Descripción</th>
	    <th>Precio</th>
	    <th>Cantidad</th>
	  </tr>
	  
	
	<c:forEach items="${cesta.getItems()}" var="item">
		  <tr>
		    <td>
		      <form action="carrito" method="post">
		        <input type="hidden" name="productCode" value="${item.product.code}">
		        <input type=text size=2 name="quantity" value="${item.quantity}">
		        <input type="submit" value="Actualizar">
		      </form>
		    </td>
		    <td>
		     ${item.product.description}
		    </td>
		    <td>
		       ${item.product.price}
		    </td>
		    <td>
		     ${item.product.price * item.quantity}
				     
		    </td>
		    <td>
		      <form action="carrito" method="post">
		        <input type="hidden" name="productCode" value="${item.product.code}">
		        <input type="hidden" name="quantity" value="0">
		        <input type="submit" value="Eliminar Producto">
		      </form>
		    </td>
		  </tr>
	</c:forEach>
	
	
	
	</table>
	
	<br>
	
	<form action="index.jsp" method="post">
	  <input type="submit" name="continue" value="Continúa comprando">
	</form>
	
	<form action="checkout.jsp" method="post" style="margin-top: 20px;">
	  <input type="submit" name="checkout" value="Checkout">
	</form>
</div>
</body>
</html>