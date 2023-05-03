<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="ModificarUsuario">
    <div class="form-group">
        <label for="nombre">Id:</label>
        <input type="hidden" value="${usuario.id_usuario}" id="id_usuario" name="id_usuario">
        <span class="form-control" id="id-display">${usuario.id_usuario}</span>
    </div>
    
    <div class="form-group">
        <label>Dni:</label>
        <input type="text" name="dni" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa un DNI v�lido')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.dni}"/>
    </div>
    
    <div class="form-group">
        <label>Nombre:</label>
        <input type="text" name="nombre" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa un nombre v�lido')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.nombre}"/>
    </div>
    
    <div class="form-group">
        <label>Apellido:</label>
        <input type="text" name="apellido" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa un apellido v�lido')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.apellido}"/>
    </div>
    
    <div class="form-group">
        <label>Direcci�n:</label>
        <input type="text" name="direccion" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa una direcci�n v�lida')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.direccion}"/>
    </div>
    
    <div class="form-group">
        <label>Tel�fono:</label>
        <input type="text" name="telefono" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa un tel�fono v�lido')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.telefono}"/>
    </div>
    
    <div class="form-group">
        <label>Email:</label>
        <input type="email" name="email" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa un correo electr�nico v�lido')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.email}"/>
    </div>
    
    <div class="form-group">
        <label>Rol:</label>
        <input type="text" name="rol" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa un rol v�lido')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.rol}"/>
    </div>
    
    <div class="form-group">
        <label>Contrase�a:</label>
        <input type="password" name="contrase�a" required class="form-control"
            oninvalid="this.setCustomValidity('Por favor, ingresa una contrase�a v�lida')"
            onchange="this.setCustomValidity('')" 
            value="${usuario.contrase�a}"/>
    </div>
    
    <input type="submit" value="Guardar" class="btn btn-primary mt-4"/>
</form>
	
	
</body>
</html>