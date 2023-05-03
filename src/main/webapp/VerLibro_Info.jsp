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
	<h2>Información del LibroInfo:</h2>
	<p>Id libro: ${libro_Info.id_libro}</p>
	<p>id autor: ${libro_Info.id_autor}</p>
</div>
<a href="Libros_Info" class="btn btn-primary">Volver</a>
</body>
</html>