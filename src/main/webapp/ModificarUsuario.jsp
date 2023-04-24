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
	<form method="post" action="ModificarUsuario">
  		<div class="form-group">
    		<label>Dni</label>
    			<input type="text" name="dni" required class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa un nombre válido')" 
		           onchange="this.setCustomValidity('')" /><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>Nombre</label>
    			<input type="text" name="nombre" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
  		<div class="form-group">
    		<label>Apellido</label>
    			<input type="text" name="apellido" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
    	<div class="form-group">
		    <label>Direccion</label>
		    <input type="text" name="direccion" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>telefono:</label>
    			<input type="text" name="telefono" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
  		<div class="form-group">
    		<label>email:</label>
    			<input type="email" name="email" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
  		<div class="form-group">
    		<label>rol:</label>
    			<input type="text" name="rol" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
    	<div class="form-group">
    		<label>contraseña:</label>
    			<input type="password" name="contraseña" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>  
  		</div>
  		<input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
	</form>
	
</body>
</html>