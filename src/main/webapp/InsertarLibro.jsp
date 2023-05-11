<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
  <head>
    <title>Formulario de inserción de libro</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container">
      <h2>Formulario de inserción de libro</h2>
      <form action="InsertarLibro" method="post">
        <div class="form-group">
          <label for="isbn">ISBN:</label>
          <input type="text" class="form-control" id="isbn" name="isbn" required>
        </div>
        <div class="form-group">
          <label for="titulo">Título:</label>
          <input type="text" class="form-control" id="titulo" name="titulo" required>
        </div>
        <div class="form-group">
          <label for="num_pag">Número de páginas:</label>
          <input type="number" class="form-control" id="num_pag" name="num_pag" required>
        </div>
        <div class="form-group">
          <label for="fecha_pub">Fecha de publicación:</label>
          <input type="date" class="form-control" id="fecha" name="fecha" required>
        </div>
        <div class="form-group">
          <label for="idioma">Idioma:</label>
          <input type="text" class="form-control" id="idioma" name="idioma" required>
        </div>
        <div class="form-group">
          <label for="stock">Stock:</label>
          <input type="number" class="form-control" id="stock" name="stock" required>
        </div>
        <div class="form-group">
          <label for="categoria">Categoría:</label>
          <select class="form-control" id="categoria" name="categoria" required>
            <option value="">Seleccionar categoría</option>
            <option value="Fantasia">Fantasía</option>
            <option value="Ciencia Ficcion">Ciencia Ficción</option>
            <option value="Romance">Romance</option>
            <option value="Misterio">Misterio</option>
            <option value="Aventura">Aventura</option>
            <option value="Biografia">Biografía</option>
            <option value="Autobiografia">Autobiografía</option>
            <option value="Ensayo">Ensayo</option>
            <option value="Poesia">Poesía</option>
            <option value="Drama">Drama</option>
            <option value="Comedia">Comedia</option>
          </select>
          <div class="form-group">
          <label for="idioma">Foto:</label>
          <input type="text" class="form-control" id="foto" name="foto" required>
        </div>
        </div>
        <div class="form-group">
	  <label for="descripcion">Descripción:</label>
	  <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
	</div>
		<div class="form-group">
  <label>id_editorial:</label>
  <input type="text" name="id_editorial" required class="form-control"
        oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')"
        onchange="this.setCustomValidity('')"
        value="${tieneEditorialCompleta ? editorialCompleta.id_editorial : id_editorial}"/><br/>  
</div>

		
		
			<c:if test="${not empty id_autor}">
		  		<input type="hidden" name="id_autor" value="${id_autor}" />
			</c:if>
	
		<input type="submit" value="guardar" class="btn btn-primary mt-4"/>
	</form>
	</div>
  </body>
</html>
 