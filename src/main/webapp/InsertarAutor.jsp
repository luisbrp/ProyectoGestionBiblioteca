<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="InsertarAutor">
  		<div class="form-group">
    		<div class="form-group">
		    <label>Nombre:</label>
		    <input type="text" name="nombre" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha v�lida')" 
		           onchange="this.setCustomValidity('')" /><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>Apellido:</label>
    			<input type="text" name="apellido" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingrese un id valido')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
  		
  		
  		<div class="form-group">
    		<label>Descripcion:</label>
    			<input type="text" name="descripcion" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contrase�a v�lida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
 
  		</div>
  		<input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
  		</form>
</body>
</html>