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
	<form method="post" action="RealizarPrestamo">
  		<div class="form-group">
    		<div class="form-group">
		    <label>Fecha del prestamo:</label>
		    <input type="Date" name="fecha_prestamo" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>id_usuario:</label>
    			<input type="text" name="id_usuario" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingrese un id valido')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
  		
  		<div class="form-group">
    		<label>id_libro:</label>
    			<input type="text" name="id_libro" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
    	<div class="form-group">
		    <label>devuelto:</label>
		    <input type="text" name="devuelto" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
  		</div>
  		
  		</div>
  		<input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
  		</form>
</body>
</html>