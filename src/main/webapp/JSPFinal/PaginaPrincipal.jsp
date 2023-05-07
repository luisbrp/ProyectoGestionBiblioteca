<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 999;
}
    h1,h2{
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
     h1{
     font-size: 75px;
     }
    .search-form input {
      width: 150px;
    }
.carousel-container {
  height: 400px; /* altura fija del carrusel */
  margin-top: 50px;
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
    <header >
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <div class="container-fluid">
          <a class="navbar-brand" href="PaginaPrincipal" style="background-image: url(https://www.innovagogia.es/wp-content/uploads/2021/08/study.png); background-size: contain; background-repeat: no-repeat; display: inline-block; width: 50px; height: 50px; padding-left: 60px;"></a>
            <a class="navbar-brand" href="PaginaPrincipal">EASY BOOKS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="PaginaPrincipal">Pagina principal</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="VerLibros">Libros</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="VerAutores">Autores</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Categorias
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Fantasia">Fantasia</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Ciencia%20Ficcion">Ciencia Ficción</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Romance">Romance</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Misterio">Misterio</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Aventura">Aventura</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Erotismo">Erotismo</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Biografía">Biografía</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Autobiografía">Autobiografía</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Ensayo">Ensayo</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Poesía">Poesía</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Drama">Drama</a></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#Comedia">Comedia</a></li>
                  </ul>
                </li>
                  <li class="nav-item">
					<a class="nav-link" href="CerrarSession">Cerrar Sesión</a>
				</li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Cuenta</a>
                </li>
              </ul>
              <form class="d-flex search-form" method="POST" action="Principal">
              <c:if test="${usuariologeado.rol == 'Administrador'}">
   				 <li class="nav-item dropdown">
		       		 <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		        	    ADMIN
		      		  </a>
				        <ul class="dropdown-menu admin-option" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="#">Gestionar usuarios</a></li>
				            <li><a class="dropdown-item" href="#">Gestionar Autores</a></li>
				            <li><a class="dropdown-item" href="#">Gestionar Libros</a></li>
				            <li><a class="dropdown-item" href="#">Gestionar editoriales</a></li>
				            <li><a class="dropdown-item" href="#">Gestionar reservas</a></li>
				            <li><a class="dropdown-item" href="#">Gestionar prestamos</a></li>
				        </ul>
				    </li>
			</c:if>
			  <input class="form-control me-2" type="search" placeholder="Titulo, Autor, Categoria, ISBN..." aria-label="Buscar" name="busqueda" automplete="off">
			  <button class="btn btn-outline-success" type="submit" >Buscar</button>
			</form>
             
            </div>
          </div>
        </nav>
      </header>

      <div style="text-align: center;">
        <br>
                <br>
                        <br>
      <h1>Generos</h1>
      <br>
        <div class="sectionCategorias mt-5">
<c:forEach var="categoria" items="${categoriasLibros}" varStatus="status">
    <div style="display: inline-block;">
        <h2>${categoria.categoria}</h2>
        <div class="container-fluid carousel-container d-inline-block" style="margin-top: 0px;">
            <div id="carouselExampleIndicators${status.index}" class="carousel slide" data-bs-ride="carousel">   
               	<div class="carousel-indicators">
                    <c:forEach var="i" begin="0" end="${fn:length(categoria.libros) - 1}">
                        <button type="button" data-bs-target="#carouselExampleIndicators${status.index}" data-bs-slide-to="${i}" <c:if test="${i==0}">class="active"</c:if> aria-label="Slide ${i+1}"></button>
                    </c:forEach>
                </div>
                <div class="carousel-inner">
                    <c:forEach var="libro" items="${categoria.libros}" varStatus="libroStatus">
                        <c:if test="${not empty libro.foto}">
                            <c:choose>
                                <c:when test="${libroStatus.index==0}">
                                    <div class="carousel-item active">
                                        <a href="VerLibro?id_libro=${libro.id_libro}"><img src="${libro.foto}" class="d-block w-100" alt="${libro.titulo}"></a>
                                        <div class="carousel-caption d-none d-md-block">
                                     
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="carousel-item">
                                       <a href="VerLibro?id_libro=${libro.id_libro}"><img src="${libro.foto}" class="d-block w-100" alt="${libro.titulo}"></a>
                                       	 <div class="carousel-caption d-none d-md-block">
                           
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators${status.index}" role="button" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators${status.index}" role="button" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
    <section id="about" class="py-5" style="margin-top: 50px; color: rgb(0, 0, 0);background-color: rgb(206, 204, 204);">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6">
              <h2 class="fw-bold mb-4">¿Quiénes somos?</h2>
              <p class="lead">Easy Books es una biblioteca física en la que podrás encontrar una amplia selección de libros para alquilar o prestar (desde nuestra pagina web o presencial).</p>
              <p class="lead">Somos una empresa comprometida con la cultura y el fomento de la lectura en nuestra comunidad.</p>
              <p class="lead">Nos enorgullece ofrecer un servicio de calidad y atención personalizada para cada uno de nuestros usuarios.</p>
            </div>
            <div class="col-md-6">
              <img src="https://via.placeholder.com/500x400/007bff/ffffff?text=Imagen+de+Sobre+Nosotros" class="img-fluid" alt="Imagen de Sobre Nosotros">
            </div>
          </div>
        </div>
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
              <div class="social-icons" style="margin-left: 150px">
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/124/124010.png" alt="Facebook"></a>
                <a href="#"><img src="https://png.pngtree.com/png-vector/20221018/ourmid/pngtree-instagram-icon-png-image_6315974.png" alt="Instagram"></a>
                <a href="#"><img src="https://png.pngtree.com/png-vector/20221018/ourmid/pngtree-twitter-social-media-round-icon-png-image_6315985.png" alt="Twitter"></a>
              </div>              
            </div>
            <div class="col-md-4 mb-3">
                <h4 class="mb-4">Contáctanos</h4>
                <ul class="list-unstyled">
                  <li><i class="fas fa-phone-alt mr-2"></i> 943-439-394</li>
                  <li><i class="fas fa-envelope mr-2"></i> info@tulibreria.com</li>
                  <li><i class="fas fa-map-marker-alt mr-2"></i> Aurelio Pagogaña 13, Irun, España</li>
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