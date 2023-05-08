<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	<style>
		.container {
			margin-top: 40px;
			margin-bottom: 20px;
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

		.card-body {
			padding: 50px;
		}

		.form-group {
			margin-bottom: 10px;
		}

		.form-control {
			border-radius: 30px;
			height: 40px;
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
		.container {
  max-width: 100%;
}
	</style>
</head>
<body style="background-image: url('https://www.elplural.com/uploads/s1/86/21/24/dia-del-libro.jpeg'); background-repeat: no-repeat; background-size: cover; height: 100vh;">

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-5 col-md-8">
				<div class="card">
					<div class="card-header">
						Registro
					</div>
					<div class="card-body">
						<form method="post" action="Registrarse">
						  <div class="form-group">
							<label for="dni"><i class="fas fa-id-card"></i> DNI</label>
							<input type="text" class="form-control" id="dni" name="dni"  pattern="[0-9]{8}[a-zA-Z]{1}" title="El DNI debe tener 8 números y una letra." placeholder="Ingrese su número de identificación" required>
						  </div>
						  <div class="form-group">
							<label for="nombre"><i class="fas fa-user"></i> Nombre</label>
							<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre" required>
						  </div>
						  <div class="form-group">
							<label for="apellido"><i class="fas fa-user"></i> Apellido</label>
							<input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese su apellido" required>
						  </div>
						  <div class="form-group">
							<label for="direccion"><i class="fas fa-map-marker-alt"></i> Dirección</label>
							<input type="text" class="form-control" id="direccion" name="direccion" placeholder="Ingrese su dirección" required>
						  </div>
						  <div class="form-group">
							<label for="telefono"><i class="fas fa-phone"></i> Teléfono</label>
							<input type="text" class="form-control" id="telefono" name="telefono" placeholder="Ingrese su número de teléfono" required   pattern="[0-9]{9}" title="El teléfono debe tener 9 números.">
						  </div>
						  <div class="form-group">
							<label for="email"><i class="fas fa-envelope"></i> Email</label>
							<input type="email" class="form-control" id="email" name="email" placeholder="Ingrese su correo electrónico" required   pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" title="Introduce una dirección de correo electrónico válida">
						  </div>
						  <div class="form-group">
							<label for="password"><i class="fas fa-lock"></i> Contraseña</label>
							<input type="password" class="form-control" id="password" name="password" pattern="(?=.*\d)(?=.*[a-zA-Z]).{8,}" title="La Contraseña debe tener al menos 8 caracteres y estar formado por una combinación de letras y números." placeholder="Ingrese su contraseña" required>
						  </div>
						  <div class="form-group">
							<button type="submit" class="btn btn-dark" onclick="return validateForm()"><i class="fas fa-sign-in-alt"></i> Ingresar</button>
						  </div>
						</form>
						<a href="Login" style="display: block; text-align: center; color: black;">¿Ya te has registrado? Inicia sesion aquí.</a>							
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
	</div>
</body>
</html>