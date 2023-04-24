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
    <c:forEach items="${editoriales}" var="editorial">
      <tr>
      		<td>${editorial.nombre}</td>	
      		<td>${editorial.id_libro}</td>
         	<td><a href="VerEditorial?id_editorial=${editorial.id_editorial}" class="btn btn-primary ">Ver</a>
         	<a href="ModificarEditorial?id_editorial=${editorial.id_editorial}" class="btn btn-primary ">Editar</a>
         	<a href="EliminarEditorial?id_editorial=${editorial.id_editorial}" class="btn btn-success">Eliminar</a></td>
      </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>