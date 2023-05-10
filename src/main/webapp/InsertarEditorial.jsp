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
    <div class="container mt-5">
      <form method="post" action="InsertarEditorial">
        <div class="form-group">
          <label for="autor">Selecciona una editorial:</label>
          <select class="form-control" id="id_editorial" name="id_editorial" size="5">
			  <c:forEach items="${editoriales}" var="editorial">
			    <option value="${editorial.id_editorial}">${editorial.nombre}</option>
			  </c:forEach>
			</select>
          <input type="submit" value="Continuar" class="btn btn-primary mt-4" href="InsertarLibro"/>
          <c:choose>
      <c:when test="${not empty param.editorial}">
    	<input type="submit" value="Continuar" class="btn btn-primary mt-4" href="InsertarLibro"/>
      </c:when>
      <c:otherwise>
        <p class="mt-3">¿No has encontrado la editorial que buscabas?</p>
        <a href="#" id="mostrarFormulario" class="btn btn-primary">Insertar Editorial</a>
      </c:otherwise>
    </c:choose>
    
    <div id="formulario" style="display:none;">
      <div class="form-group">
        <label>Nombre de la editorial:</label>
        <input type="text" name="nombre" class="form-control" /><br/>
      </div>
     
      
      <input type="submit" value="Continuar" class="btn btn-primary mt-4" href="InsertarLibro"/>
    </div>
  </form>
</div>

<script>
  document.getElementById("mostrarFormulario").addEventListener("click", function() {
    document.getElementById("formulario").style.display = "block";
  });
</script>
  </body>
</html>