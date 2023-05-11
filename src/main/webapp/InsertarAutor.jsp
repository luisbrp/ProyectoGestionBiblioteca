<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario de autores</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </head>
<body>
<h1>Insertar Autor</h1>
  <div class="container mt-5">
  <form method="post" action="InsertarAutor" id="form_seleccion_autor">
   <div class="form-group">
  <label for="autor">Selecciona un autor:</label>
  <select class="form-control" id="autor" name="id_autor" size="5" required>
    <option value="">--Selecciona un autor--</option>
    <c:forEach items="${autores}" var="autor">
      <option value="${autor.id_autor}">${autor.nombre} ${autor.apellido}</option>
    </c:forEach>
  </select>
</div>

    <input type="submit" value="Continuar" class="btn btn-primary mt-3" name="continuar_autor_existente"/>
    <input type="hidden" name="id_autor" value="${autor.id_autor}" />
    
    <div class="mt-3">¿No has encontrado el autor que buscabas?</div>
    <a href="#" id="mostrarFormulario" class="btn btn-primary">Insertar autor</a>
  </form>
  
  <form method="post" action="InsertarAutor" id="form_insertar_autor" style="display:none;">
    <div class="form-group">
      <label>Nombre:</label>
      <input type="text" name="nombre" class="form-control" required /><br/>
    </div>
      
    <div class="form-group">
      <label>Apellido:</label>
      <input type="text" name="apellido" class="form-control" required /><br/>
    </div>
      
    <div class="form-group">
      <label>Descripcion:</label>
      <input type="text" name="descripcion" class="form-control" required /><br/>
    </div>
      
    <input type="submit" value="Continuar" class="btn btn-primary mt-4" name="continuar_insertar_autor"/>
  </form>
</div>
 <script>
$(document).ready(function() {
  $("#mostrarFormulario").click(function(event) {
    event.preventDefault();
    $("#form_seleccion_autor").hide();
    $("#form_insertar_autor").show();
  });
});
</script>

  
</body>
</html>