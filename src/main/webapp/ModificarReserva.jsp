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
              <input type="hidden" value="${reserva.fecha_Reserva}&${reserva.id_libro}&${reserva.id_usuario}">
                <span class="form-control" id="id-display">${reserva.fecha_Reserva}&${reserva.id_libro}&${reserva.id_usuario}</span>
              </div>
              
  		<div class="form-group">
    		<div class="form-group">
		    <label>Fecha de la reserva:</label>
		    <input type="Date" name="fecha_Reserva" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
		           onchange="this.setCustomValidity('')"
		           value="${reserva.fecha_Reserva}" /><br/>
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

  		
  		</div>
  		<input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
  		</form>
</body>
</html>