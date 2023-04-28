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
<form method="post" action="ModificarLibro_Info">
  <div class="form-group">
    <label for="nombre">Ids:</label>
    <input type="hidden" value="${libro_Info.id_libro}&${libro_Info.id_autor}">
    <span class="form-control" id="id-display">${libro_Info.id_libro}&amp;${libro_Info.id_autor}</span>
  </div>

  <div class="form-group">
    <label>id_Libro:</label>
    <input type="text" name="id_libro" required 
      class="form-control" 
      oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
      onchange="this.setCustomValidity('')" 
      value="${libro_Info.id_libro}" /><br/>
  </div>

  <div class="form-group">
    <label>id_autor:</label>
    <input type="text" name="id_autor" required 
      class="form-control" 
      oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
      onchange="this.setCustomValidity('')"
      value="${libro_Info.id_autor}" /><br/>
  </div>

  <div class="form-group">
    <label>nuevo_id_Libro:</label>
    <input type="text" name="nuevo_id_libro" required 
      class="form-control" 
      oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
      onchange="this.setCustomValidity('')" 
      value="" /><br/>
  </div>

  <div class="form-group">
    <label>nuevo_id_autor:</label>
    <input type="text" name="nuevo_id_autor" required 
      class="form-control" 
      oninvalid="this.setCustomValidity('Por favor, ingresa una fecha válida')" 
      onchange="this.setCustomValidity('')"
      value="" /><br/>
  </div>

  <input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
</form>

  		
</body>
</html>