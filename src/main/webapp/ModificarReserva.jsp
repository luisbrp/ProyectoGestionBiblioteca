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
    <input type="hidden" name="fechaRVieja" value="${reserva.fecha_Reserva}">
  </div>
  
  <div class="form-group">
    <label>Fecha:</label>
    <input type="Date" name="fecha" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
           onchange="this.setCustomValidity('')" 
            value="${reserva.fecha_Reserva}"/><br/>
  </div>
  
  <div class="form-group">
    <label>id_usuario:</label>
      <input type="text" name="id_usuario" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingrese un id valido')" 
           onchange="this.setCustomValidity('')"
           value="${reserva.id_usuario}" /><br/>
           
  </div>
  
  <div class="form-group">
    <label>id_libro:</label>
      <input type="text" name="id_libro" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
           onchange="this.setCustomValidity('')" 
           value="${reserva.id_libro}"/><br/>
           
  </div>
  
  <!-- Input oculto para fechaRVieja -->
  <input type="hidden" name="fechaRVieja" value="${reserva.fecha_Reserva}">
  
  <p>"${reserva.fecha_Reserva}"</p>
  <!-- Input oculto para id_usuarioViejo -->
  <input type="hidden" name="id_usuarioViejo" value="${reserva.id_usuario}">
  
  <!-- Input oculto para id_libroViejo -->
  <input type="hidden" name="id_libroViejo" value="${reserva.id_libro}">
  
  <input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
</form>
</body>
</html>