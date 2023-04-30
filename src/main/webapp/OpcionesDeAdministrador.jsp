<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Opciones de Administrador</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-3i9b9rC0vT8W1QzYj0R+G4a/4NF/4t2ZGLtVnRZSjFxsHfoNtFrqRHtM3zIn5xIFc5KB5ZXIa5b5JZ9mQeQG8Q==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
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
              <form class="d-flex search-form">
                <input class="form-control me-2" type="search" placeholder="Nombre del libro" aria-label="Buscar Libro">
                <button class="btn btn-outline-success" type="submit">Buscar Libro</button>
              </form>
            </div>
          </div>
        </nav>
      </header>
      
      <section class="ms-5" id="VerUsuarios">
        <div class="mt-5" style="text-align: center;">
            <h1>Opciones de Administrador</h1>
        </div>
        <h3 class="mt-5">Gestionar Usuarios</h3>
        <table class="table table-striped table-dark mt-5">
            <thead>
              <tr>
                <th>Id</th>
                <th>Dni</th>
                <th>Nombre</th>
                <th>Rol</th>
                <th>Lista de Usuarios<a href="InsertarUsuario" class="btn btn-primary" style="margin-left: 100px;">InsertarUsuario</a></th>
                <th><form class="d-flex search-form">
                    <input class="form-control me-2" type="search" placeholder="Buscar (Dni)" aria-label="Buscar Libro">
                    <button class="btn btn-outline-success" type="submit">Buscar Usuario</button>
                  </form></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${usuarios}" var="usuario" varStatus="loop">
					  <c:if test="${loop.index lt 5}">
					    <tr>
					      <td>${usuario.id_usuario}</td>
					      <td>${usuario.dni}</td>
					      <td>${usuario.nombre}</td>
					      <td>${usuario.rol}</td>
					      <td>
					        <a href="VerUsuario?id_usuario=${usuario.id_usuario}" class="btn btn-primary ">Ver</a>
					        <a href="ModificarUsuario?id_usuario=${usuario.id_usuario}" class="btn btn-success ">Editar</a> 
					        <a href="EliminarUsuario?id_usuario=${usuario.id_usuario}" class="btn btn-danger">Eliminar</a>
					      </td> 
					    </tr>
					  </c:if>
			</c:forEach>  
            </tbody>
          </table>
      </section>
     
      <section class="ms-5" id="VerLibros">
        <h3 class="mt-5">Gestionar Libros</h3>
        <table class="table table-striped table-dark mt-5">
            <thead>
              <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Isbn</th>
                <th>Stock</th>
                <th>Lista de libros<a href="InsertarLibro" class="btn btn-primary" style="margin-left: 100px;">InsertarLibro</a></th>
                <th><form class="d-flex search-form">
                    <input class="form-control me-2" type="search" placeholder="Buscar (isbn)" aria-label="Buscar Libro">
                    <button class="btn btn-outline-success" type="submit">Libros</button>
                  </form></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${libros}" var="libro">
              
                <tr>
                    <td>${libro.id_libro}</td>
                    <td>${libro.titulo}</td>
                   <td>${libro.isbn}</td>
                    <td>Stock</td>
                   <td><a href="VerLibro?id_libro=${libro.id_libro}" class="btn btn-primary ">Ver</a>
                    <a href="ModificarLibro?id_libro=${libro.id_libro}" class="btn btn-success ">Editar</a> 
                    <a href="EliminarLibro?id_libro=${libro.id_libro}" class="btn btn-danger">Eliminar</a></td> 
                </tr>
               
              </c:forEach>
            </tbody>
          </table>
      </section>
      
      
      
      <section class="ms-5"  id="VerAutores">
      <h3 class="mt-5">Gestionar Autores</h3>
      <table class="table table-striped table-dark mt-5">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>Lista de Autores<a href="InsertarAutor" class="btn btn-primary" style="margin-left: 100px;">InsertarAutor</a></th>
              <th><form class="d-flex search-form">
                  <input class="form-control me-2" type="search" placeholder="Buscar (id)" aria-label="Buscar Autor">
                  <button class="btn btn-outline-success" type="submit">Buscar Autor</button>
                </form></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${autores}" var="autor">
              <tr>
                  <td>${autor.id_autor}</td>
                 <td>${autor.nombre}</td>
                  <td>${autor.apellido}</td>
                <td><a href="Autor?nombre=${autor.nombre}" class="btn btn-primary ">Ver</a>
                  <a href="ModificarAutor?id_autor=${autor.id_autor}" class="btn btn-success ">Editar</a> 
                  <a href="EliminarAutor?id_autor=${autor.id_autor}" class="btn btn-danger">Eliminar</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
    </section>
    
   <section class="ms-5"  id="VerReservas">
    <h3 class="mt-5">Gestionar Reservas</h3>
    <table class="table table-striped table-dark mt-5">
        <thead>
          <tr>
            <th>Id_Libro</th>
            <th>Id_Usuario</th>
            <th>Fecha</th>
            <th>Reservas<a href="RealizarReserva" class="btn btn-primary" style="margin-left: 100px;">RealizarReserva</a></th>
            <th><form class="d-flex search-form">
                <input class="form-control me-2" type="search" placeholder="Buscar (id)" aria-label="Buscar Autor">
                <button class="btn btn-outline-success" type="submit">Buscar Reserva</button>
              </form></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${reservas}" var="reserva">
          
            <tr>
                <td>${reserva.id_libro}</td>
                <td>${reserva.id_usuario}</td>
                <td>${reserva.fecha_Reserva}</td>
                <td><a href="VerReserva?fecha_Reserva=${reserva.fecha_Reserva}&id_libro=${reserva.id_libro}&id_usuario=${reserva.id_usuario}" class="btn btn-success">Ver</a>
               <a href="ModificarReserva?fecha_Reserva=${reserva.fecha_Reserva}&id_libro=${reserva.id_libro}&id_usuario=${reserva.id_usuario}" class="btn btn-success">Editar</a>
               <a href="EliminarReserva?fecha_Reserva=${reserva.fecha_Reserva}&id_libro=${reserva.id_libro}&id_usuario=${reserva.id_usuario}" class="btn btn-danger">Eliminar</a></td>
            </tr>
      
          </c:forEach>
        </tbody>
      </table>
  </section>
    
    <section class="ms-5"  id="VerPrestamos">
    <h3 class="mt-5">Gestionar Prestamos</h3>
    <table class="table table-striped table-dark mt-5">
        <thead>
          <tr>
            <th>Id_Libro</th>
            <th>Id_Usuario</th>
            <th>Fecha</th>
            <th>Devuelto<a href="RealizarPrestamo" class="btn btn-primary" style="margin-left: 100px;">RealizarPrestamo</a></th>
            <th><form class="d-flex search-form">
                <input class="form-control me-2" type="search" placeholder="Buscar (id)" aria-label="Buscar Autor">
                <button class="btn btn-outline-success" type="submit">Buscar Prestamo</button>
              </form></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${prestamos}" var="prestamo">
          
            <tr>
                <td>${prestamo.id_libro}</td>
                <td>${prestamo.id_usuario}</td>
                <td>${prestamo.fecha_prestamo}</td>
                <td><a href="VerPrestamo?fecha_prestamo=${prestamo.fecha_prestamo}&id_libro=${prestamo.id_libro}&id_usuario=${prestamo.id_usuario}" class="btn btn-success">Ver</a>
               <a href="ModificarPrestamo?fecha_prestamo=${prestamo.fecha_prestamo}&id_libro=${prestamo.id_libro}&id_usuario=${prestamo.id_usuario}" class="btn btn-success">Editar</a>
                    <a href="AnularPrestamo?fecha_prestamo=${prestamo.fecha_prestamo}&id_libro=${prestamo.id_libro}&id_usuario=${prestamo.id_usuario}" class="btn btn-danger">Eliminar</a></td>
            </tr>
            
          </c:forEach>
        </tbody>
      </table>
  </section>
    
     <section class="ms-5"  id="VerEditoriales">
      <h3 class="mt-5">Gestionar Editoriales</h3>
      <table class="table table-striped table-dark mt-5">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Id_Libro</th>
              <th>Lista de Editoriales<a href="InsertarEditorial" class="btn btn-primary" style="margin-left: 100px;">InsertarAutor</a></th>
              <th><form class="d-flex search-form">
                  <input class="form-control me-2" type="search" placeholder="Buscar (id)" aria-label="Buscar Editorial">
                  <button class="btn btn-outline-success" type="submit">Buscar Editorial</button>
                </form></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${editoriales}" var="editorial">
            
              <tr>
                 <td>${editorial.id_editorial}</td>
                  <td>${editorial.nombre}</td>	
            <td>${editorial.id_libro}</td>
             <td><a href="VerEditorial?id_editorial=${editorial.id_editorial}" class="btn btn-primary ">Ver</a>
               <a href="ModificarEditorial?id_editorial=${editorial.id_editorial}" class="btn btn-primary ">Editar</a>
               <a href="EliminarEditorial?id_editorial=${editorial.id_editorial}" class="btn btn-danger">Eliminar</a></td>
              </tr>
           
            </c:forEach>
          </tbody>
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