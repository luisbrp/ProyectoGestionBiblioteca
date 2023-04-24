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
    <c:forEach items="${libros_Info}" var="libro_Info">
      <tr>
      		<td>${libro_Info.id_autor}</td>	
      		<td>${libro_Info.id_libro}</td>
         	<td><a href="VerLibro_Info?id_autor=${libro_Info.id_autor}&id_libro=${libro_Info.id_libro}" class="btn btn-primary ">Ver</a>
         	<a href="ModificarLibro_Info?id_autor=${libro_Info.id_autor}&id_libro=${libro_Info.id_libro}" class="btn btn-primary ">Editar</a>
         	<a href="EliminarLibro_Info?id_autor=${libro_Info.id_autor}&id_libro=${libro_Info.id_libro}" class="btn btn-success">Eliminar</a></td>
      </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>