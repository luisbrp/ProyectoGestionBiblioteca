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
<table>
  <tbody>
    <c:forEach items="${libros}" var="libro">
      <tr>
		<td>${libro.id_libro}</td> 
		<td>${libro.isbn}</td> 
		<td>${libro.titulo}</td> 
		<td>${libro.num_paginas}</td> 
		<td>${libro.fecha_publicacion}</td> 
		<td>${libro.idioma}</td> 
		<td>${libro.stock}</td> 
		<td>${libro.categoria}</td>
		 <td>${libro.foto}</td>
         <td><a href="VerLibro?id_libro=${libro.id_libro}" class="btn btn-primary ">Ver</a>
      	 <a href="ModificarLibro?id_libro=${libro.id_libro}" class="btn btn-success ">Editar</a> 
   		<a href="EliminarLibro?id_libro=${libro.id_libro}" class="btn btn-success ">Eliminar</a></td> 
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>