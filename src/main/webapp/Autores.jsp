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
    <c:forEach items="${autores}" var="autor">
      <tr>
      		<td>${autor.id_autor}</td>	
      		<td>${autor.nombre}</td>
        	<td>${autor.apellido}</td>
         	<td>${autor.descripcion}</td>
         	<td><a href="EliminarAutor?id_autor=${autor.id_autor}" class="btn btn-success">Eliminar</a></td>
      </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>