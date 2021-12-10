<%-- 
    Document   : Configracion_Actualizar
    Created on : Nov 19, 2021, 12:53:14 AM
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
	<title>Configuracion</title>
    </head>
    <body>
        <header>
            <div class="contenedor">
		<h2 class="logotipo">CUBE</h2>
		<nav>
                    <a href="Controlador?accion=principal">Inicio</a>
                    <a href="Controlador_P?accion=listar">Peliculas</a>
                    <a href="Controlador_P?accion=listar_reciente">Más Recientes</a>
                    <a href="Controlador_U?accion=configuracion" class="user-name" id="user_name">Configuracion</a>
                    <a href="Controlador?accion=mantenimiento" id="user_mantenimiento"><i class="fas fa-cube"></i></a>
                </nav>
            </div>
	</header>
        
        <main class="contenedor-master-c">
            <div class="contenedor-configuracion">
		<a href="#" class="configuracion-en">Actualizar Perfil</a>
                <br>
                <a href="Controlador_U?accion=modificar" class="configuracion-en">Cambiar Contraseña</a>
                <br>
                <a href="Controlador_U?accion=ayuda" class="configuracion-en">Ayuda</a>
                <br>
                <a href="Controlador_U?accion=cerrarsession" class="configuracion-en">Cerrar Sesion</a>
            </div>
              
            
            <div class="configuracion-mostrar">
		<form action="Controlador_U?accion=Actualizar&id=<%=request.getParameter("id")%>" method="post"  style="width: 500px; height: 400px" class="mostrar-form">
                    <h1 class="configuracion-titulo">Cambiar Perfil</h1>
                    <div class="contenedor-c">
                        <div class="input-contenedor">
                            <i class="fas fa-user-edit icon"></i>
                            <input type="text" name="txtnnombre"   placeholder="Nuevo Nombre"/>
                        </div>
                        <div class="input-contenedor">
                            <i class="fas fa-user-edit icon"></i>
                            <input type="text" name="txtnpellido" placeholder="Nueva Apellido"/>
                        </div>
                        <input type="submit" value="Guardar Cambios" class="modificar-form"/>
                    </div>
                </form>
            </div>
	</main>
        <script type="text/javascript">
            
            window.onload=function Almacenar()
            {
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
