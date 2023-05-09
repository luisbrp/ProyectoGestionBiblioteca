<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Inserta la informacion del autor</h2>
	<form method="post" action="InsertarAutor" class="mt-5">
  		<div class="form-group">
    		<div class="form-group">
		    <label>Nombre:</label>
		    <input type="text" name="nombre" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
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
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" /><br/>
		           
  		</div>
 
  		</div>
  		<input type="submit" value="Continuar" class="btn btn-primary mt-4" href="InsertarLibro"/>
  		</form>
</body>
</html>