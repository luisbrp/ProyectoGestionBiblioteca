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
<div>
<h2>Información del reserva:</h2>
		<p>Id: ${reserva.fecha_Reserva}</p>
		<p>Id_Libro: ${reserva.id_usuario}</p>
		<p>Id_Usuario: ${reserva.id_libro}</p>

	</div>
	<a href="Prestamos" class="btn btn-primary">Volver</a>
</body>
</html>