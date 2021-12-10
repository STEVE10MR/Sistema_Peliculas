<%-- 
    Document   : Peliculas
    Created on : Nov 18, 2021, 3:54:09 PM
    Author     : USUARIO
--%>


<%@page import="Modelo.Genero"%>
<%@page import="Modelo_DAO.Genero_DAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Pelicula"%>
<%@page import="Modelo_DAO.Pelicula_DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
                <div class="contenedor-image">
                    <%
                        Pelicula_DAO pelicula=new Pelicula_DAO();
                        ArrayList<Pelicula> l_pelicula=pelicula.Listar();
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
            <aside class="contenedor-genero">
                <div class="input-contenedor all">
                        <form action="" class="input-search">
                            <input type="search" name="txtbuscar" class="input-buscar" placeholder="Buscar"/>
                            <input type="submit" value="Buscar" class="modificar-form search" name="accion"/>
                        </form>
                </div>
                <h3 class="contenedor-titulo">Genero</h3>
                <div class="genero-lis">
                    <%
                        Genero_DAO genero=new Genero_DAO();
                        ArrayList<Genero> l_genero=genero.Listar();
                        Iterator<Genero>iter_g=l_genero.iterator();
                        Genero EN_genero=null;
                        while(iter_g.hasNext()){
                            EN_genero=iter_g.next();
                    %>
                    <a  class="genero-item" style="text-decoration:none"><%=EN_genero.getNombre()%><a/>
                    <%}%>
                </div>
            </aside>
        </div>
        <script type="text/javascript">
            
            window.onload=function Almacenar()
            {
                var aValue = localStorage.getItem('userName');
                var aRol=localStorage.getItem('userRol');
                document.getElementById('user_name').innerHTML = aValue;
                if(aRol==="1")
                {
                    document.getElementById("user_mantenimiento").style.visibility = "visible";
                }
                else if(aRol==="2")
                {
                    document.getElementById("user_mantenimiento").style.visibility = "hidden";
                }
            }
        </script>
    </body>
</html>
