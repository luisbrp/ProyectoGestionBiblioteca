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
	<form method="post" action="ModificarAutor">
  		<div class="form-group">
                <label for="nombre">Id:</label>
               <input type="hidden" value="${autor.id_autor}" id="id_autor" name="id_autor">
                <span class="form-control" id="id-display">${autor.id_autor}</span>
              </div>
  		
  		<div class="form-group">
    		<div class="form-group">
		    <label>Nombre:</label>
		    <input type="text" name="nombre" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa un nombre valido')" 
		           onchange="this.setCustomValidity('')" 
		           value="${autor.nombre}"><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>Apellido:</label>
    			<input type="text" name="apellido" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingrese un valor valido')" 
		           onchange="this.setCustomValidity('')"
		           value="${autor.apellido}"/><br/>
		           
  		</div>
  		
  		
  		<div class="form-group">
    		<label>Descripcion:</label>
    			<input type="text" name="descripcion" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa un valor valido')" 
		           onchange="this.setCustomValidity('')"
		            value="${autor.descripcion}" /><br/>
		           
  		</div>
  		</div>
  		<input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
  		</form>
</body>
</html>