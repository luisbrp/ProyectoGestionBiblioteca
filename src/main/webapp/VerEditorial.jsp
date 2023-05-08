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
	<h2>Información del editorial:</h2>
	<p>Id: ${editorial.id_editorial}</p>
	<p>nombre: ${editorial.nombre}</p>
</div>
<a href="OpcionesDeAdministrador" class="btn btn-primary">Volver</a>

</body>
</html>