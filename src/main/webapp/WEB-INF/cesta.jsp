
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
		        <input type="hidden" name="productcodigo" value="${item.producto.codigo}">
		        <input type=text size=2 name="cantidad" value="${item.cantidad}">
		        <input type="submit" value="Actualizar">
		      </form>
		    </td>
		    <td>
		     ${item.producto.descripcion}
		    </td>
		    <td>
		       ${item.producto.precio}
		    </td>
		    <td>
		     ${item.producto.precio * item.cantidad}
				     
		    </td>
		    <td>
		      <form action="carrito" method="post">
		        <input type="hidden" name="codigoProducto" value="${item.producto.codigo}">
		        <input type="hidden" name="cantidad" value="0">
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
	
	<form action="checkout" method="post" style="margin-top: 20px;">
	  <input type="submit" name="checkout" value="Checkout">
	</form>
</div>
</body>
</html>