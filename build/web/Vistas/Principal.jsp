<%-- 
    Document   : Ingreso_Usuario
    Created on : Nov 19, 2021, 5:53:25 PM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Pelicula"%>
<%@page import="Modelo.Pelicula"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo_DAO.Pelicula_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet"> 
	<title>Principal</title>
    
    </head>
    <body>
        <header>
		<div class="contenedor">
			<h2 class="logotipo">CUBE</h2>
			<nav>
                            <a href="#" class="activo" id="probar" value="123">Inicio</a>
                            <a href="Controlador_P?accion=listar">Peliculas</a>
                            <a href="Controlador_P?accion=listar_reciente">Más Recientes</a>
                            <a href="Controlador_U?accion=configuracion" class="user-name" id="user_name">Configuracion</a>
                            <a href="Controlador?accion=mantenimiento" id="user_mantenimiento"><i class="fas fa-cube"></i></a>
			</nav>
		</div>
	</header>
                                
	<main>
		<div class="pelicula-principal">
                    <div class="contenedor">
			<h3 class="titulo">Nombre de Pelicula</h3>
			<p class="descripcion">
                            Descripcion
			</p>
			<button role="button" class="boton"><i class="fas fa-info-circle">Mas Informacion</i></button>
                    </div>
		</div>
	</main>
        

        <script type="text/javascript">
            
            window.onload=function Almacenar()
            {
              
                localStorage.setItem('userName', "<%=request.getAttribute("name")%>");
                localStorage.setItem('userID', "<%=request.getAttribute("id")%>");
                localStorage.setItem('userRol', "<%=request.getAttribute("rol")%>");
                    
                var aValue = localStorage.getItem('userName');
                var aRol=localStorage.getItem('userRol');
                document.getElementById('user_name').innerHTML = aValue;
                
                
                if(aRol=="1")
                {
                    document.getElementById("user_mantenimiento").style.visibility = "visible";
                }
                else if(aRol=="2")
                {
                    document.getElementById("user_mantenimiento").style.visibility = "hidden";
                }
            }
        </script>
        
    </body>
</html>
