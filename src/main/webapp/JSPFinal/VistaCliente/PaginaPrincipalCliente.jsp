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
                  <li class="nav-item">
					<a class="nav-link" href="CerrarSession">Cerrar Sesión</a>
				</li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Cuenta</a>
                </li>
              </ul>
              <form class="d-flex search-form">
                <input class="form-control me-2" type="search" placeholder="Nombre del libro" aria-label="Buscar Libro">
                <button class="btn btn-outline-success" type="submit">Buscar Libro</button>
              </form>
            </div>
          </div>
        </nav>
      </header>

      <div style="text-align: center;">
        <br>
      <h1>Generos mas buscados</h1>
      <br>
        <div style="display: inline-block;">
            <h2>Ciencia Ficción</h2>
            <div class="container-fluid carousel-container d-inline-block" style="margin-top: 0px;">
                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 1</h5>
                                <p>Información adicional sobre la imagen 1.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 2</h5>
                                <p>Información adicional sobre la imagen 2.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 3</h5>
                                <p>Información adicional sobre la imagen 3.</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators1" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
        <div style="display: inline-block;">
            <h2>Erotismo</h2>
            <div class="container-fluid carousel-container d-inline-block" style="margin-top: 0px;">
                <div id="carouselExampleIndicators1" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators1" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators1" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators1" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 1</h5>
                                <p>Información adicional sobre la imagen 1.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 2</h5>
                                <p>Información adicional sobre la imagen 2.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 3</h5>
                                <p>Información adicional sobre la imagen 3.</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators1" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators1" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
        <div style="display: inline-block;">
            <h2>Acción</h2>
            <div class="container-fluid carousel-container d-inline-block" style="margin-top: 0px;">
                <div id="carouselExampleIndicators2" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 1</h5>
                                <p>Información adicional sobre la imagen 1.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 2</h5>
                                <p>Información adicional sobre la imagen 2.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://marketplace.canva.com/EAFI171fL0M/1/0/1003w/canva-portada-de-libro-de-novela-ilustrado-color-azul-aqua-PQeWaiiK0aA.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Título de la imagen 3</h5>
                                <p>Información adicional sobre la imagen 3.</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
      </div>
   
    <section id="about" class="py-5" style="margin-top: 50px; color: rgb(0, 0, 0);background-color: rgb(206, 204, 204);">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6">
              <h2 class="fw-bold mb-4">¿Quiénes somos?</h2>
              <p class="lead">Easy Books es una biblioteca física en la que podrás encontrar una amplia selección de libros para alquilar o prestar.</p>
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