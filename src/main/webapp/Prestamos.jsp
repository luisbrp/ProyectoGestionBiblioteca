<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
 <tbody>
    <c:forEach items="${prestamos}" var="prestamo">
      <tr>
      		<td>${prestamo.fecha_prestamo}</td>	
      		<td>${prestamo.id_libro}</td>
        	<td>${prestamo.id_usuario}</td>
         	<td>${prestamo.devuelto}</td>
         	<td><a href="VerPrestamo?fecha_prestamo=${prestamo.fecha_prestamo}&id_libro=${prestamo.id_libro}&id_usuario=${prestamo.id_usuario}" class="btn btn-success">Ver</a>
         	<a href="ModificarPrestamo?fecha_prestamo=${prestamo.fecha_prestamo}&id_libro=${prestamo.id_libro}&id_usuario=${prestamo.id_usuario}" class="btn btn-success">Editar</a>
         	<a href="AnularPrestamo?fecha_prestamo=${prestamo.fecha_prestamo}&id_libro=${prestamo.id_libro}&id_usuario=${prestamo.id_usuario}" class="btn btn-success">Eliminar</a></td>
      </tr>
    </c:forEach>
    </tbody>
</table>
	
<a href="Prestamos" class="btn btn-primary">Volver</a>
</body>
</html>