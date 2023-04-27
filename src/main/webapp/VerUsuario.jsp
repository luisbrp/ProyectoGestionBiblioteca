<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Información del usuario:</h2>
		<p>Id: ${usuario.id_usuario}</p>
		<p>Dni: ${usuario.dni}</p>
		<p>Nombre: ${usuario.nombre}</p>
		<p>Contraseña: ${usuario.contraseña}</p>
		<p>Rol: ${usuario.rol}</p>
	</div>
	<a href="OpcionesDeAdministrador" class="btn btn-primary">Volver</a>
</body>
</html>