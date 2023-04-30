<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina Principal</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-3i9b9rC0vT8W1QzYj0R+G4a/4NF/4t2ZGLtVnRZSjFxsHfoNtFrqRHtM3zIn5xIFc5KB5ZXIa5b5JZ9mQeQG8Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    

</head>
<style>
    h1,h2{
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
    .search-form input {
      width: 300px;
    }
    .carousel-container {
     margin-top: 50px; /* ajusta según el espacio deseado */
     width: 300px;
     max-width: 100%;
}
.social-icons {
  display: flex;
}

.social-icons a {
  margin-right: 10px;
}

.social-icons img {
  width: 30px;
  height: 30px;
  border-radius: 50%;
}
.social-icons a:hover img {
  transform: rotate(360deg);
  transition: transform 1s ease-in-out;
}



@keyframes spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>

<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">EASY BOOKS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">Pagina principal</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="">Libros</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Autores</a>
                </li>
              <li class="nav-item dropdown">
  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
    Categorias
  </a>
  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Fantasia">Fantasía</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Ciencia%20Ficcion">Ciencia Ficción</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Romance">Romance</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Misterio">Misterio</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Aventura">Aventura</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Erotismo">Erotismo</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Biografia">Biografía</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Autobiografia">AutoBiografía</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Ensayo">Ensayo</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Poesia">Poesía</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Drama">Drama</a></li>
    <li><a class="dropdown-item" href="Principal?categoriaSeleccionada=Comedia">Comedia</a></li>
  </ul>
</li>
              
                
                <li class="nav-item">
                  <a class="nav-link" href="#">Cuenta</a>
                </li>
              </ul>
              <form class="d-flex search-form" method="POST" action="Principal">
			  <input class="form-control me-2" type="search" placeholder="Titulo, Autor, Categoria, ISBN..." aria-label="Buscar" name="busqueda">
			  <button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>
            </div>
          </div>
        </nav>
      </header>
			<section>
				<h1>Libros por categoría</h1>
			    <table>
			        <tr>
			            <th>ID</th>
			            <th>ISBN</th>
			            <th>Título</th>
			            <th>Número de páginas</th>
			            <th>Fecha de publicación</th>
			            <th>Idioma</th>
			            <th>Stock</th>
			            <th>Categoría</th>
			            <th>Foto</th>
			        </tr>
			        <c:forEach items="${librosPorCategoria}" var="libro">
			            <tr>
			                <td>${libro.id_libro}</td>
			                <td>${libro.isbn}</td>
			                <td>${libro.titulo}</td>
			                <td>${libro.num_paginas}</td>
			                <td>${libro.fecha_publicacion}</td>
			                <td>${libro.idioma}</td>
			                <td>${libro.stock}</td>
			                <td>${libro.categoria}</td>
			                <td><img src="${libro.foto}" alt="${libro.titulo}" height="100"></td>
			            </tr>
			        </c:forEach>
			    </table>
				</section>
				<footer class="bg-dark text-light py-5" style="margin-top: 50px;">
        <div class="container">
          <div class="row">
            <div class="col-md-4 mb-3">
              <h4 class="mb-4">Navegación</h4>
              <ul class="list-unstyled">
                <li><a class="text-light" href="#">Inicio</a></li>
                <li><a class="text-light" href="#">Libros</a></li>
                <li><a class="text-light" href="#">Autores</a></li>
              </ul>
            </div>
            <div class="col-md-4 mb-3">
              <h4 class="mb-4">Síguenos</h4>
              <div class="social-icons">
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/124/124010.png" alt="Facebook"></a>
                <a href="#"><img src="https://png.pngtree.com/png-vector/20221018/ourmid/pngtree-instagram-icon-png-image_6315974.png" alt="Instagram"></a>
                <a href="#"><img src="https://png.pngtree.com/png-vector/20221018/ourmid/pngtree-twitter-social-media-round-icon-png-image_6315985.png" alt="Twitter"></a>
              </div>              
            </div>
            <div class="col-md-4 mb-3">
                <h4 class="mb-4">Contáctanos</h4>
                <ul class="list-unstyled">
                  <li><i class="fas fa-phone-alt mr-2"></i> 123-456-7890</li>
                  <li><i class="fas fa-envelope mr-2"></i> info@tulibreria.com</li>
                  <li><i class="fas fa-map-marker-alt mr-2"></i> Calle 123, Ciudad, País</li>
                </ul>
              </div>
          </div>
          <hr class="bg-light">
          <div class="text-center">
            <small>Todos los derechos reservados © 2023</small>
          </div>
        </div>
      </footer>
      
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>
    
</body>
</html>
    