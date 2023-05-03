<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina Principal</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-3i9b9rC0vT8W1QzYj0R+G4a/4NF/4t2ZGLtVnRZSjFxsHfoNtFrqRHtM3zIn5xIFc5KB5ZXIa5b5JZ9mQeQG8Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>Resultados de b�squeda</title>
	<style type="text/css">
		table {
			border-collapse: collapse;
			width: 100%;
		}
		th, td {
			text-align: left;
			padding: 8px;
			border-bottom: 1px solid #ddd;
		}
		tr:hover {
			background-color:#f5f5f5;
		}
		.thumbnail {
			max-width: 100px;
			max-height: 100px;
			display: block;
			margin: auto;
		}
	</style>
</head>
<body>
<style>
    h1,h2{
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
    .search-form input {
      width: 300px;
    }
    .carousel-container {
     margin-top: 50px; /* ajusta seg�n el espacio deseado */
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
                  <a class="nav-link" href="#">Libros</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Autores</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Categorias
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="#">Fantas�a</a></li>
                    <li><a class="dropdown-item" href="#">Ciencia Ficci�n</a></li>
                    <li><a class="dropdown-item" href="#">Romance</a></li>
                    <li><a class="dropdown-item" href="#">Misterio</a></li>
                    <li><a class="dropdown-item" href="#">Aventura</a></li>
                    <li><a class="dropdown-item" href="#">Erotismo</a></li>
                    <li><a class="dropdown-item" href="#">Biograf�a</a></li>
                    <li><a class="dropdown-item" href="#">Autobiograf�a</a></li>
                    <li><a class="dropdown-item" href="#">Ensayo</a></li>
                    <li><a class="dropdown-item" href="#">Poes�a</a></li>
                    <li><a class="dropdown-item" href="#">Drama</a></li>
                    <li><a class="dropdown-item" href="#">Comedia</a></li>
                  </ul>
                </li>
                <li>
                    <div class="sidebar">
                        <ul>
                          <li><a href="#">Libros</a></li>
                          <li><a href="#">Autores</a></li>
                          <li><a href="#">Editoriales</a></li>
                          <li><a href="#">Usuarios</a></li>
                        </ul>
                      </div>

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
	<c:if test="${not empty librosEncontrados}">
		<table class="mt-5">
			<thead>
				<tr>
					<th>T�tulo</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>ISBN</th>
					<th>Categor�a</th>
					<th>Stock</th>
					<th>Foto</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="libro" items="${librosEncontrados}">
					<tr>
						<td>${libro.titulo}</td>
						<td>${libro.autor.nombre} ${libro.autor.apellido}</td>
						<td>${libro.editorial.nombre}</td>
						<td>${libro.isbn}</td>
						<td>${libro.categoria}</td>
						<td>${libro.stock}</td>
						<td><img src="${libro.foto}" alt="Portada del libro ${libro.titulo}" class="thumbnail"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<footer class="bg-dark text-light py-5" style="margin-top: 50px;">
        <div class="container">
          <div class="row">
            <div class="col-md-4 mb-3">
              <h4 class="mb-4">Navegaci�n</h4>
              <ul class="list-unstyled">
                <li><a class="text-light" href="#">Inicio</a></li>
                <li><a class="text-light" href="#">Libros</a></li>
                <li><a class="text-light" href="#">Autores</a></li>
              </ul>
            </div>
            <div class="col-md-4 mb-3">
              <h4 class="mb-4">S�guenos</h4>
              <div class="social-icons">
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/124/124010.png" alt="Facebook"></a>
                <a href="#"><img src="https://png.pngtree.com/png-vector/20221018/ourmid/pngtree-instagram-icon-png-image_6315974.png" alt="Instagram"></a>
                <a href="#"><img src="https://png.pngtree.com/png-vector/20221018/ourmid/pngtree-twitter-social-media-round-icon-png-image_6315985.png" alt="Twitter"></a>
              </div>              
            </div>
            <div class="col-md-4 mb-3">
                <h4 class="mb-4">Cont�ctanos</h4>
                <ul class="list-unstyled">
                  <li><i class="fas fa-phone-alt mr-2"></i> 123-456-7890</li>
                  <li><i class="fas fa-envelope mr-2"></i> info@tulibreria.com</li>
                  <li><i class="fas fa-map-marker-alt mr-2"></i> Calle 123, Ciudad, Pa�s</li>
                </ul>
              </div>
          </div>
          <hr class="bg-light">
          <div class="text-center">
            <small>Todos los derechos reservados � 2023</small>
          </div>
        </div>
      </footer>
</body>
</html>
