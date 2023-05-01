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
	<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th>Id</th>
      <th>Dni</th>
      <th>Nombre</th>
      <th>rol</th>
      <th>Acciones <a href="InsertarUsuario" class="btn btn-primary" style="margin-left: 40px;">InsertarUsuario</a></th>
      <th><a href="Prestamos" class="btn btn-primary" style="margin-left: 20px;">Prestamos</a></th>
      <th><a href="Autores" class="btn btn-primary" style="margin-left: 20px;">Autores</a></th>
      <th><a href="Editoriales" class="btn btn-primary" style="margin-left: 20px;">Editoriales</a></th>
      <th><a href="VerLibros" class="btn btn-primary" style="margin-left: 20px;">Libros</a></th>
      <th><a href="Reservas" class="btn btn-primary" style="margin-left: 20px;">Reservas</a></th>
      <th><a href="Prestamos" class="btn btn-primary" style="margin-left: 20px;">Prestamos</a></th>
      <th><a href="Libros_Info" class="btn btn-primary" style="margin-left: 20px;">Libros_Info</a></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.id_usuario}</td>
         <td>${usuario.dni}</td>
        <td>${usuario.nombre}</td>
         <td>${usuario.rol}</td>
         <td><a href="VerUsuario?id_usuario=${usuario.id_usuario}" class="btn btn-primary ">Ver</a>
      	 <a href="ModificarUsuario?id_usuario=${usuario.id_usuario}" class="btn btn-success ">Editar</a> 
   		<a href="EliminarUsuario?id_usuario=${usuario.id_usuario}" class="btn btn-success ">Eliminar</a></td> 
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>