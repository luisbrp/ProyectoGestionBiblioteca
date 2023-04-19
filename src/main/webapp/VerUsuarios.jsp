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
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.id_usuario}</td>
         <td>${usuario.dni}</td>
        <td>${usuario.nombre}</td>
         <td>${usuario.rol}</td>
         <td><a href="VerUsuario?id=${usuario.id_usuario}" class="btn btn-primary ">Ver</a>
      	 <a href="ModificarUsuario?id=${usuario.id_usuario}" class="btn btn-success ">Editar</a> 
      	<a href="EliminarUsuario?id=${usuario.id_usuario}" class="btn btn-danger" >eliminar </a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>