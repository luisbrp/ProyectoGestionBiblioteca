<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio de sesión</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	<style>
		.container {
			margin-top: 50px;
		}

		.card {
			box-shadow: 0px 1px 10px rgba(0, 0, 0, 0.3);
			border-radius: 10px;
			border: none;
		}

		.card-header {
			background-color: #000000;
			color: white;
			border-radius: 10px 10px 0px 0px;
			border: none;
			text-align: center;
			font-size: 30px;
			font-weight: bold;
			padding-top: 20px;
			padding-bottom: 20px;
		}
html, body {
    height: 100%;
}
		.card-body {
			padding: 50px;
		}

		.form-group {
			margin-bottom: 30px;
		}

		.form-control {
			border-radius: 30px;
			height: 50px;
			font-size: 18px;
		}

		.btn-dark {
			border-radius: 30px;
			height: 50px;
			font-size: 18px;
			background-color: #000000;
			border: none;
			width: 100%;
			margin-top: 20px;
			transition: all 0.2s ease-in-out;
		}

		.btn-dark:hover {
			background-color: #8b1818;
		}

		.btn-forgot {
			font-size: 16px;
			color: #b92929;
			margin-top: 10px;
			display: block;
			text-align: center;
		}

		.btn-forgot:hover {
			color: #833c3c;
		}

		.error {
			color: red;
			font-size: 14px;
			margin-top: 10px;
		}
		
	</style>
</head>
<body style="background-image: url('https://www.elplural.com/uploads/s1/86/21/24/dia-del-libro.jpeg'); background-repeat: no-repeat; background-size: cover; height: 100vh;">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-5 col-md-8">
				<div class="card">
					<div class="card-header">
						Iniciar sesión
					</div>
					<div style=""><c:if test="${not empty mensaje}">
  <div class="alert alert-danger">${mensaje}</div>
</c:if></div>
					 
					<div class="card-body">
                        <form method="post" action="Login">
                            <div class="form-group">
                                <label for="Dni"><i class="fas fa-id-card"></i> DNI</label>
                                <input type="text" class="form-control" id="Dni" name="Dni" placeholder="Ingrese su Dni de usuario" required>
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="fas fa-lock"></i> Contraseña</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-dark" onclick="return validateForm()"><i class="fas fa-sign-in-alt"></i> Ingresar</button>
                            </div>
                          
                            </form>
                            <a href="Registrarse" style="display: block; text-align: center; color: black;">Aun no te has registrado? Registrate.</a>							
                        </div>
                    </div>
                    
                    <script>
                    function validateForm() {
                        var username = document.getElementById("username").value;
                        var password = document.getElementById("password").value;
                        if (username == "" || password == "") {
                            alert("Por favor, complete todos los campos.");
                            return false;
                        }
                        return true;
                    }
                    </script>
				</div>
			</div>
		</div>

	
</body>
</html>