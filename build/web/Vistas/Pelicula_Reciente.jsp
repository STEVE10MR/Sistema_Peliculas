<%-- 
    Document   : Pelicula_Reciente
    Created on : Dec 1, 2021, 9:27:48 AM
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
	<title>Peliculas</title>
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
        <div class="contenedor-master">
            <main>
                <div class="contenedor-image reciente">
                    <%
                        Pelicula_DAO pelicula=new Pelicula_DAO();
                        ArrayList<Pelicula> l_pelicula=pelicula.Listar_Recientes();
                        Iterator<Pelicula>iter=l_pelicula.iterator();
                        Pelicula EN_pelicula=null;
                        while(iter.hasNext()){
                            EN_pelicula=iter.next();
                    %>
                    <a href="Controlador_P?accion=informacion&id=<%=EN_pelicula.getID()%>">
                        <div class="cube">
                            <img src="<%=EN_pelicula.getImagen()%>" alt="" class ="imagen-pelicula">
                            <h3 class="titulo-image"><%=EN_pelicula.getNombre()%></h3>
                        </div>
                    </a>
                    <%}%>
                </div>
            </main>
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
