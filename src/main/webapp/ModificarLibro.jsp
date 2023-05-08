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
<form method="post" action="ModificarLibro">
  		<div class="form-group">
        <label for="nombre">Id:</label>
        <input type="hidden" value="${libro.id_libro}" id="id_libro" name="id_libro">
    	</div>
  		
  		<div class="form-group">
    		<label>ISBN:</label>
    			<input type="text" name="isbn" required class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa un nombre válido')" 
		           onchange="this.setCustomValidity('')" 
		           value="${libro.isbn}"/><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>TITULO:</label>
    			<input type="text" name="titulo" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')"
		            value="${libro.titulo}" /><br/>
		           
  		</div>
  		
  		<div class="form-group">
    		<label>NUM PAGINAS:</label>
    			<input type="text" name="num_pag" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" 
		            value="${libro.num_paginas}"/><br/>
		           
  		</div>
  		
    	<div class="form-group">
		    <label>Fecha:</label>
		    <input type="Date" name="fecha" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
		           onchange="this.setCustomValidity('')" 
		            value="${libro.fecha_publicacion}"/><br/>
  		</div>
  		
  		<div class="form-group">
    		<label>idioma:</label>
    			<input type="text" name="idioma" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" 
		            value="${libro.idioma}"/><br/>
		           
  		</div>
  		
  		<div class="form-group">
    		<label>stock:</label>
    			<input type="text" name="stock" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" 
		            value="${libro.stock}"/><br/>
		           
  		</div>
  		
    	<div class="form-group">
    		<label>categoria:</label>
    			<input type="text" name="categoria" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" 
		            value="${libro.categoria}"/><br/>  
  		</div>
  		<div class="form-group">
    		<label>foto:</label>
    			<input type="text" name="foto" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
		           onchange="this.setCustomValidity('')" 
		            value="${libro.foto}"/><br/>  
  		</div>
  <input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
  </form>
</body>
</html>