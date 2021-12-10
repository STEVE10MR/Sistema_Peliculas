<%-- 
    Document   : Registro_Usuario
    Created on : Nov 19, 2021, 5:53:14 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet"> 
        <title>Registro de Usuario</title>
    </head>
    <body class="form">
        <form action="Controlador_C?accion=Registrar" method="Post" style="width: 500px; height: 400px" class="mostrar-form-r">
            <h1 class="configuracion-titulo-l">Registro de Usuario</h1>
            <div class="contenedor-r">
                <div class="input-contenedor-l">
                    <i class="fas fa-user icon"></i>
                    <input type="text" name="txtnombre"   placeholder="Ingrese su Nombre" maxlength="25"/>
                    </div>
                <div class="input-contenedor-l">
                    <i class="fas fa-user icon"></i>
                    <input type="text" name="txtapellido"   placeholder="Ingrese su Apellido" maxlength="45"/>
                </div>
                <div class="input-contenedor-l">
                    <i class="fas fa-envelope icon"></i>
                    <input type="text" name="txtcorreo"   placeholder="Ingrese su Correo" maxlength="25"/>
                </div>
                <div class="input-contenedor-l">
                    <i class="fas fa-key icon"></i>
                    <input type="password" name="txtcontra" placeholder="Ingrese su Contraseña" maxlength="25"/>
                </div>
            </div>
            <p class="tex">Ya tienes una Cuenta?<a class="link" href="Controlador?accion=session">Ingresa<a/></p>
            <input type="submit" value="Registrar" class="modificar-form esp" name="accion"/>
           
        </form>
    </body>
</html>
