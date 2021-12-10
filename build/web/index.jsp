<%-- 
    Document   : index
    Created on : Nov 19, 2021, 12:16:16 AM
    Author     : USUARIO
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet"> 
	<title>Inicio de Sesion</title>
    </head>
    <body class="form">
        <form  action="Controlador?accion=verificar" method="Post" style="width: 500px; height: 400px" class="mostrar-form-l">
            <h1 class="configuracion-titulo-l">Inicio de Sesion</h1>
            <div class="contenedor-l">
                <div class="input-contenedor-l">
                    <i class="fas fa-envelope icon"></i>
                    <input type="text" name="txtcorreo"   placeholder="Ingrese su Correo" maxlength="25"/>
                </div>
                <div class="input-contenedor-l">
                    <i class="fas fa-key icon"></i>
                    <input type="password" name="txtcontra" placeholder="Ingrese su Contraseña" maxlength="25"/>
                </div>
            </div>
            <input type="submit" value="Iniciar Sesion" class="modificar-form esp"/>
            <p class="tex">No tienes un Cuenta?<a class="link" href="Controlador_C?accion=agregar">Registrate<a/></p>
        </form
    </body>
</html>
