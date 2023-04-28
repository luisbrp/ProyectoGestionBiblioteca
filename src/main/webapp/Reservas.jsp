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
    <c:forEach items="${reservas}" var="reserva">
      <tr>
      		<td>${reserva.fecha_Reserva}</td>	
      		<td>${reserva.id_libro}</td>
        	<td>${reserva.id_usuario}</td>
         	<td><a href="VerReserva?fecha_Reserva=${reserva.fecha_Reserva}&id_libro=${reserva.id_libro}&id_usuario=${reserva.id_usuario}" class="btn btn-success">Ver</a>
         	<a href="ModificarReserva?fecha_Reserva=${reserva.fecha_Reserva}&id_libro=${reserva.id_libro}&id_usuario=${reserva.id_usuario}" class="btn btn-success">Editar</a>
         	<a href="EliminarReserva?fecha_Reserva=${reserva.fecha_Reserva}&id_libro=${reserva.id_libro}&id_usuario=${reserva.id_usuario}" class="btn btn-success">Eliminar</a></td>
      </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>