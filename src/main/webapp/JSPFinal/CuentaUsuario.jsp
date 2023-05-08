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
.hidden {
    display: none;
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

<div class="usuario-info" style="margin-top: 100px;">
  <div class="container my-4">
    <div class="row">
      <div class="col-md-6 mx-auto">
        <div class="card">
          <div class="card-header bg-dark text-white">
            <h2 class="card-title mb-0">Hola ${usuario.nombre} ${usuario.apellido}</h2>
          </div>
          <div class="card-body">
            <form method="post" action="CuentaUsuario">
              <input type="hidden" name="id_usuario" value="${usuario.id_usuario}">
              <div class="form-group">
                <label for="nombre"><strong>Nombre:</strong></label>
                <input type="text" class="form-control" name="nombre" id="nombre" value="${usuario.nombre}"required disabled>
              </div>
              <div class="form-group">
                <label for="apellido"><strong>Apellido:</strong></label>
                <input type="text" class="form-control" name="apellido" id="apellido" value="${usuario.apellido}"required disabled>
              </div>
              <div class="form-group">
                <label for="dni"><strong>DNI:</strong></label>
                <input type="text" class="form-control" name="dni" id="dni" value="${usuario.dni}" required disabled pattern="[0-9]{8}[a-zA-Z]{1}" title="El DNI debe tener 8 números y una letra.">
              </div>
              <div class="form-group">
                <label for="direccion"><strong>Dirección:</strong></label>
                <input type="text" class="form-control" name="direccion" id="direccion" value="${usuario.direccion}"required disabled>
              </div>
              <div class="form-group">
                <label for="email"><strong>Email:</strong></label>
                <input type="email" class="form-control" name="email" id="email" value="${usuario.email}" disabled required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" title="Introduce una dirección de correo electrónico válida" >
              </div>
               <div class="form-group">
                <label for="contraseña"><strong>Contraseña:</strong></label>
                <input type="password" class="form-control" name="contraseña" id="contraseña" value="${usuario.contraseña}" required disabled pattern="(?=.*\d)(?=.*[a-zA-Z]).{8,}" title="La Contraseña debe tener al menos 8 caracteres y estar formado por una combinación de letras y números.">
              </div>
              <div class="form-group">
                <label for="telefono"><strong>Telefono:</strong></label>
                <input type="text" class="form-control" name="telefono" id="telefono" value="${usuario.telefono}" required disabled pattern="[0-9]{9}" title="El teléfono debe tener 9 números.">
              </div>
              <input type="hidden" name="rol" value="${usuario.rol}">
              <div class="d-flex justify-content-end" style="margin-top: 20px;">
                <button type="button" class="btn btn-dark mr-2" style="margin-right: 10px;">Editar</button>
                <button type="submit" class="btn btn-success mr-2" id="guardar-btn" style="margin-right: 10px;">Guardar</button>
                <button type="button" class="btn btn-secondary" id="cancelar-btn" style="margin-right: 10px;">Cancelar</button>
              </div>
          </form>
        </div>
      </div>
    </div>
  </div>
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
    <script>
    const editButton = document.querySelector(".btn-dark");
    const saveButton = document.querySelector(".btn-success");
    const cancelButton = document.querySelector(".btn-secondary");

    saveButton.classList.add("d-none");
    cancelButton.classList.add("d-none");
    // Selecciona los campos de entrada de datos
    const dniInput = document.querySelector("#dni");
    const direccionInput = document.querySelector("#direccion");
    const emailInput = document.querySelector("#email");
    const contraseñaInput = document.querySelector("#contraseña");
    const telefonoInput = document.querySelector("#telefono");
    const nombreInput = document.querySelector("#nombre");
    const apellidoInput = document.querySelector("#apellido");
    // Guarda los valores originales de los campos de entrada de datos
    const originalDni = dniInput.value;
    const originalDireccion = direccionInput.value;
    const originalEmail = emailInput.value;
    const originalContraseña = contraseñaInput.value;
    const originalTelefono = telefonoInput.value;
    const originalNombre = nombreInput.value;
    const originalApellido = apellidoInput.value;
    // Maneja el evento "click" del botón "Editar"
    editButton.addEventListener("click", () => {
      // Oculta el botón "Editar"
      editButton.classList.add("d-none");

      // Muestra los botones "Guardar" y "Cancelar"
      saveButton.classList.remove("d-none");
      cancelButton.classList.remove("d-none");

      // Habilita los campos de entrada de datos para la edición
      dniInput.disabled = false;
      direccionInput.disabled = false;
      emailInput.disabled = false;
      contraseñaInput.disabled = false;
      telefonoInput.disabled = false;
      nombreInput.disabled = false;
      apellidoInput.disabled = false;
    });

    // Maneja el evento "click" del botón "Cancelar"
    cancelButton.addEventListener("click", () => {
      // Restaura los valores originales de los campos de entrada de datos
      dniInput.value = originalDni;
      direccionInput.value = originalDireccion;
      emailInput.value = originalEmail;
      contraseñaInput.value = originalContraseña;
      telefonoInput.value = originalTelefono;
      nombreInput.value = originalNombre;
      apellidoInput.value = originalApellido;
      // Oculta los botones "Guardar" y "Cancelar"
      saveButton.classList.add("d-none");
      cancelButton.classList.add("d-none");

      // Muestra el botón "Editar"
      editButton.classList.remove("d-none");

      // Deshabilita los campos de entrada de datos
      dniInput.disabled = true;
      direccionInput.disabled = true;
      emailInput.disabled = true;
      contraseñaInput.disabled = true;
      telefonoInput.disabled = true;
      nombreInput.disabled = true;
      apellidoInput.disabled = true;
    });


  </script>
</body>
</html>