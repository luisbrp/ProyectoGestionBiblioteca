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
		<form method="post" action="ModificarReserva">
  <div class="form-group">
    <label for="nombre">Id:</label>
  </div>
  <div class="form-group">
    <label>Fecha:</label>
    <input type="Date" name="fechaNueva" required 
       class="form-control" 
       oninvalid="this.setCustomValidity('Por favor, ingresa una fecha v�lida')" 
       onchange="this.setCustomValidity('')" 
        value="${reserva.fecha_Reserva}"/><br/>
    <input type="hidden" name="fecha" value="${reserva.fecha_Reserva}">
  </div>
  <div class="form-group">
    <label>id_usuario:</label>
      <input type="text" name="id_usuario" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingrese un id valido')" 
           onchange="this.setCustomValidity('')"
           value="${reserva.id_usuario}" /><br/>
      <input type="hidden" name="id_usuario_viejo" value="${reserva.id_usuario}">
  </div>
  <div class="form-group">
    <label>id_libro:</label>
      <input type="text" name="id_libro" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una contrase�a v�lida')" 
           onchange="this.setCustomValidity('')" 
           value="${reserva.id_libro}"/><br/>
      <input type="hidden" name="id_libro_viejo" value="${reserva.id_libro}">
  </div>  
  <input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
</form>
</body>
</html>