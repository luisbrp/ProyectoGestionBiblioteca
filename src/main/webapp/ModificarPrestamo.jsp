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
		<form method="post" action="ModificarPrestamo">
  <div class="form-group">
    <label for="nombre">Id:</label>
  </div>
  <div class="form-group">
    <label>Fecha:</label>
    <input type="date" name="fecha_prestamo" required 
       class="form-control" 
       oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
       onchange="this.setCustomValidity('')" 
        value="${prestamo.fecha_prestamo}"/><br/>
    <input type="hidden" name="fecha" value="${prestamo.fecha_prestamo}">
  </div>
  <div class="form-group">
    <label>id_usuario:</label>
      <input type="text" name="id_usuario" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingrese un id valido')" 
           onchange="this.setCustomValidity('')"
           value="${prestamo.id_usuario}" /><br/>
      <input type="hidden" name="id_usuario_viejo" value="${prestamo.id_usuario}">
  </div>
  <div class="form-group">
    <label>id_libro:</label>
      <input type="text" name="id_libro" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
           onchange="this.setCustomValidity('')" 
           value="${prestamo.id_libro}"/><br/>
      <input type="hidden" name="id_libro_viejo" value="${prestamo.id_libro}">
  </div>  
  <div class="form-group">
    <label>Devuelto:</label>
      <input type="text" name="devuelto" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
           onchange="this.setCustomValidity('')" 
           value="${prestamo.devuelto}"/><br/>
      <input type="hidden" name="devuelto_viejo" value="${prestamo.devuelto}">
  </div> 
  <input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
</form>
		
</body>
</html>