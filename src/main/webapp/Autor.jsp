<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="autor.css">

</head>
<style>
  
    h1,h2{
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
    p{
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
    .search-form input {
      width: 150px;
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

.cardAutor {
    width: 950px;
    height: 510px;

}




.cardLibro {
    justify-content: center;
    width: 350px;
    height: 500px;
    margin-left: 40px;
}

.divImgAutor {
    width: 450px;
    height: 300px;
    
}

.ImagenAutor {
    width: 100%;
    height: 100%;
}

.ImagenLibro {
    width: 100%;
    height: 100%;
}

.autorDescripcion {
  font-size: larger;
}

.VerLibro {
  text-decoration: none;
  color: black;
  font-size: larger;
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
                    <li><a class="dropdown-item" href="#">Fantasía</a></li>
                    <li><a class="dropdown-item" href="#">Ciencia Ficción</a></li>
                    <li><a class="dropdown-item" href="#">Romance</a></li>
                    <li><a class="dropdown-item" href="#">Misterio</a></li>
                    <li><a class="dropdown-item" href="#">Aventura</a></li>
                    <li><a class="dropdown-item" href="#">Erotismo</a></li>
                    <li><a class="dropdown-item" href="#">Biografía</a></li>
                    <li><a class="dropdown-item" href="#">Autobiografía</a></li>
                    <li><a class="dropdown-item" href="#">Ensayo</a></li>
                    <li><a class="dropdown-item" href="#">Poesía</a></li>
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
                <li class="nav-item">
                 <a href="#" class="nav-link">Admin</a>
                </li>
              </ul>
              <form class="d-flex search-form">
                <input class="form-control me-2" type="search" placeholder="Nombre del autor" aria-label="Buscar Autor">
                <button class="btn btn-outline-success" type="submit">Buscar Autor</button>
              </form>
            </div>
          </div>
        </nav>
      </header>
      <section id="Autor">
        <div class="cardAutor mt-5" id="autor" style="margin-left: 450px;">
          <div class="divImgAutor mt-4" style="margin-left: 240px;">
            <img class="ImagenAutor" src="https://th.bing.com/th/id/R.597ae94d87d5c9defe7d4d06bca66ffa?rik=8S7a5UtxS6K2dg&pid=ImgRaw&r=0" alt="">
          </div>
          <p style="margin-left: 240px;"></p>
          <p class="autorDescripcion mt-3 ms-3">Descripcion: Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quisquam, eos, at libero error quas dolorum iusto eveniet eum deleniti nostrum nesciunt harum aliquam eaque corporis, suscipit accusantium fuga voluptatem voluptatibus. Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil consequatur iure pariatur earum ab tempora amet soluta eum labore, ullam illum corporis quas culpa magnam ipsam possimus! Officia corrupti ratione deleniti, est soluta ad reiciendis, maiores aliquid veritatis praesentium odit.</p>
        </div>
      </section>
      <section class = "VerLibrosAutor">
        <h3 class="mt-5 ms-3">Libros (Cantidad de Libros de dicho autor)</h3>
        <c:forEach items="${libros}" var="libro">
          <div class="cardLibro mt-5">
            <img class = "ImagenLibro" src="${libro.foto}" alt="">
          </div>
          <p class="mt-2">${libro.titulo}</p>
        <a class="VerLibro mt-5" href="VerLibro?id_libro=${libro.id_libro}">Ver Libro</a>
         </c:forEach>
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
