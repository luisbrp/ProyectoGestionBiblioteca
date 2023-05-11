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
<form method="post" action="ModificarEditorial">
  		<div class="form-group">
                <label for="nombre">Id:</label>
               <input type="hidden" value="${editorial.id_editorial}" id="id_editorial" name="id_editorial">
                <span class="form-control" id="id-display">${editorial.id_editorial}</span>
              </div>
  		
  		<div class="form-group">
    		<div class="form-group">
		    <label>Nombre:</label>
		    <input type="text" name="nombre" required 
		           class="form-control" 
		           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha valida')" 
		           onchange="this.setCustomValidity('')"
		           value="${editorial.nombre}" /><br/>
  		</div>
  		
  		</div>
  		<input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
  		</form>
</body>
</html>