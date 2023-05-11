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
<h2>Información del prestamo:</h2>
		<p>Id: ${prestamo.fecha_prestamo}</p>
		<p>Id_Libro: ${prestamo.id_usuario}</p>
		<p>Id_Usuario: ${prestamo.id_libro}</p>
		<p>Devuelto: ${prestamo.devuelto}</p>
	</div>
	<a href="OpcionesDeAdministrador" class="btn btn-primary">Volver</a>
</body>
</html>