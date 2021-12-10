<%-- 
    Document   : Pelicula_Registrar
    Created on : Dec 3, 2021, 12:00:12 AM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo_DAO.Clasificacion_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
			<a href="Controlador_I?accion=principal" class="configuracion-en">Configuracion Idioma</a>
                        <br>
                        <a href="Controlador_P?accion=principal" class="configuracion-en">Configuracion Pelicula</a>
                        <br>
                        <a href="Controlador_C?accion=principal" class="configuracion-en">Configuracion Cliente</a>
                        <br>
                        <a href="Controlador_G?accion=principal" class="configuracion-en">Configuracion Genero</a>
                        <br>
                        <a href="Controlador_A?accion=principal" class="configuracion-en">Configuracion Actor</a>
                        <br>
                        <a href="Controlador_D?accion=principal" class="configuracion-en">Configuracion Director</a>
                        <br>
                        <a href="Controlador_CL?accion=principal" class="configuracion-en">Configuracion Clasificacion</a>
                        <br>
                        <a href="Controlador_F?accion=principal" class="configuracion-en">Configuracion Factura</a>
		</div>
	</main>
        <div class="configuracion-mostrar-registrar-p">
            <form action="" method="Post">
                <h1 class="configuracion-titulo">Registro de Pelicula</h1>
                    <div class="contenedor-r pe">
                        <div class="input-contenedor-r">
                            <i class="fas fa-signature icon"></i>
                            <input type="text" name="txtnombre"   placeholder="Ingrese el Nombre" maxlength="25"/>
                        </div>
                        <div class="input-contenedor-r">
                                <i class="fas fa-table icon"></i>
				<input type="date" name="DateFecha" max="2030-00-00" placeholder="Ingrese la Fecha de Estreno">          
                        </div>
                        <div class="input-contenedor-r">
                                <i class="fas fa-file-alt icon"></i>
                                <input type="text" name="txtDescripcion" placeholder="Ingrese la Descripcion" maxlength="45"/>
                        </div>
                        <div class="input-contenedor-r">
                                <i class="fas fa-coins icon"></i>
                                <input type="text" name="txtValor" placeholder="Ingrese el Costo" maxlength="45"/>
                        </div>
                        <div class="input-contenedor-r">
                                <i class="fas fa-plus icon"></i>
                                <select class="s-p">
                                    <%
                                    Clasificacion_DAO _clasificacion=new Clasificacion_DAO();
                                    ArrayList<Clasificacion> l_Clasificacion=_clasificacion.Listar();
                                    Iterator<Clasificacion>iter=l_Clasificacion.iterator();
                                    Clasificacion clasificacion=null;
                                    while(iter.hasNext()){
                                    clasificacion=iter.next();
                                    %>
                                    <option name="ID_Clasificacion" value="<%=clasificacion.getID()%>"><p><%=clasificacion.getNombre()%></p></option>
                                    <%
                                        }
                                    %>
                                </select>
                        </div>
			<div class="input-contenedor-r">
                                <i class="far fa-image icon"></i>
                                <form action="subir.php" enctype="multipart/form-data" method="post">
                                    <input name="archivo" id="archivo" type="file">
                                    <input type="submit" name="subir" value="Subir imagen">
                                </form>
                        </div>
                    </div>
                <input type="submit" value="Continuar" class="modificar-form esp" name="accion"/>
            </form>
        </div>
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
