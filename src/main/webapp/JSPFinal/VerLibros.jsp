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
  .card {

  width: 190px;
  height: 254px;
  background: rgba(217, 217, 217, 0.58);
  border: 1px solid white;
  box-shadow: 12px 17px 51px rgba(0, 0, 0, 0.22);
  backdrop-filter: blur(6px);

  text-align: center;
  cursor: pointer;
  transition: all 0.5s;
  display: flex;
  align-items: center;
  justify-content: center;
  user-select: none;
  font-weight: bolder;
  color: black;
}

.card:hover {
  border: 1px solid black;
  transform: scale(1.05);
}

.card:active {
  transform: scale(0.95) rotateZ(1.7deg);
}
.custom-card-style:hover h5.card-title {
  opacity: 1;
}
.card-title {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  text-align: center;
}
:target {
  scroll-margin-top: 70px;
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
                  <a class="nav-link" aria-current="page" href="PaginaPrincipal">Pagina principal</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="VerLibros">Libros</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="VerAutores">Autores</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Categorias
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach var="categoria" items="${Todascategorias}" varStatus="status">
                    <li><a class="dropdown-item" href="http://localhost:8080/ProyectoGestionBiblioteca/VerLibros#${categoria.categoria}">${categoria.categoria}</a></li>
                      </c:forEach>
                  </ul>
                </li>
                  <li class="nav-item">
					<a class="nav-link" href="CerrarSession">Cerrar Sesión</a>
				</li>
                <li class="nav-item">
                   <a class="nav-link" href="CuentaUsuario?id_usuario=${usuariologeado.id_usuario}">Cuenta</a>
                </li>
              </ul>
            <form class="d-flex search-form" method="POST" action="PaginaPrincipal">
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
			  <input class="form-control me-2" type="search" placeholder="Introduce Titulo o Autor" aria-label="nombreBusqueda" name="nombreBusqueda" automplete="off">
			  <button class="btn btn-outline-success" type="submit" >Buscar</button>
			</form>
             
            </div>
          </div>
        </nav>
      </header>

 
  
<div style="margin-top: 60px;">

  <c:forEach var="categoria" items="${categoriasLibros}" varStatus="status">
    <h1 id="${categoria.categoria}" style="margin-left: 50px;">${categoria.categoria}</h1>

    <div style="margin-left: 50px; width: 95%; overflow-x: auto; scroll-snap-type: x mandatory;">
      <div style="display: flex; margin-left: 30px;margin-top: 20px;">
        <c:forEach var="libro" items="${categoria.libros}" varStatus="libroStatus">
          <div style="margin-right: 20px; scroll-snap-align: center;">
            <div class="card-container">
              <a href="VerLibro?id_libro=${libro.id_libro}">
                <div class="card custom-card-style" style="background-image: url('${libro.foto}'); background-size: cover; background-position: center; background-repeat: no-repeat;">
                  <div class="card-body"></div>
                </div>
              </a>
              <h5 class="card-title" style="margin-top: 20px; margin-left: 10px; max-width: 100%; text-align: center; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 200px;" title="${libro.titulo}">${libro.titulo}</h5>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </c:forEach>
</div>

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