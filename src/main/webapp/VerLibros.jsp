<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libros</title>
</head>
<body>
<c:forEach items="${libros}" var="libro">
	<div>
		<h2>Información del del Libro:</h2>
		<p>id:${libro.id_libro}</p>
		<p>isbn:${libro.isbn}</p>
		<p>titulo${libro.titulo}</p>
		<p>num_pag:${libro.num_paginas}</p>
		<p>Fecha de publicacion: ${libro.fecha_publicacion}</p>
		<p>idioma: ${libro.idioma}</p>
		<p>stock: ${libro.stock}</p>
		<p>categoria: ${libro.categoria}</p>	
	</div>
	</c:forEach>
	<a href="VerUsuarios" class="btn btn-primary">Volver</a>
</body>
</html>