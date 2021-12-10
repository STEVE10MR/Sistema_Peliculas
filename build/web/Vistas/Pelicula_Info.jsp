<%-- 
    Document   : Informacion
    Created on : Nov 20, 2021, 7:52:58 PM
    Author     : USUARIO
--%>

<%@page import="Modelo.Detalle_Genero"%>
<%@page import="Modelo.Detalle_Idioma"%>
<%@page import="Modelo.Detalle_Director"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Detalle_Actor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo_DAO.Detalle_Director_DAO"%>
<%@page import="Modelo_DAO.Detalle_Director_DAO"%>
<%@page import="Modelo_DAO.Detalle_Idioma_DAO"%>
<%@page import="Modelo_DAO.Detalle_Genero_DAO"%>
<%@page import="Modelo_DAO.Detalle_Actor_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/estilos.css">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet"> 
        <title>Informacion</title>
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
        <main>
            <div class="contenedor_info">
                <form action="Controlador_AL?accion=registrar" method="Post">
                    <img src="<%=request.getAttribute("Imagen")%>" alt="" class ="imagen-i">
                    <div class="contenedor_tl">
                        <h3 class="titulo_info"><%=request.getAttribute("Nombre")%></h3>
                        <p class="descripcion_info"><%=request.getAttribute("Descripcion")%></p>
                        <h4 class="tl_info">Fecha de Estreno : <%=request.getAttribute("FechaEstreno")%></h4>
                        <h4 class="tl_info">Clasificacion : <%=request.getAttribute("Calificacion")%></h4>
                        <h4 class="tl_info">Duracion : <%=request.getAttribute("Duracion")%> min</h4>
                        <h4 class="tl_info">Actor(s)</h4>
                        <div>
                            <%
                            int ID_P=Integer.parseInt(request.getParameter("id"));
                            Detalle_Actor_DAO d_actor=new Detalle_Actor_DAO();
                            ArrayList<Detalle_Actor> l_d_actor=d_actor.LeerID(ID_P);
                            Iterator<Detalle_Actor>iter=l_d_actor.iterator();
                            Detalle_Actor EN_detalle_actor=null;
                            while(iter.hasNext()){
                                EN_detalle_actor=iter.next();
                            %>
                            <p class="td_info_d"><%=EN_detalle_actor.getActor().getElenco().getNombres()%> <%=EN_detalle_actor.getActor().getElenco().getApellidos()%> , </p>
                            <%}%>
                        </div>
                        <br>
                        <h4 class="tl_info">Director(s)</h4>
                        <div>
                            <%
                            Detalle_Director_DAO d_director=new Detalle_Director_DAO();
                            ArrayList<Detalle_Director> l_d_director=d_director.LeerID(ID_P);
                            Iterator<Detalle_Director>d_iter=l_d_director.iterator();
                            Detalle_Director EN_detalle_director=null;
                            while(d_iter.hasNext()){
                                EN_detalle_director=d_iter.next();
                            %>
                            <p class="td_info_d"><%=EN_detalle_director.getDirector().getElenco().getNombres()%> <%=EN_detalle_director.getDirector().getElenco().getApellidos()%> , </p>
                            <%}%>
                        </div>
                        <br>
                        <h4 class="tl_info">Genero(s)</h4>
                        <div>
                            <%
                            Detalle_Genero_DAO d_genero=new Detalle_Genero_DAO();
                            ArrayList<Detalle_Genero> g_d_genero=d_genero.Informacion(ID_P);
                            Iterator<Detalle_Genero>g_iter=g_d_genero.iterator();
                            Detalle_Genero EN_detalle_genero=null;
                            while(g_iter.hasNext()){
                                EN_detalle_genero=g_iter.next();
                            %>
                            <p class="td_info_d" ><%=EN_detalle_genero.getGenero().getNombre()%> , </p>
                            <%}%>
                        </div>
                        <br>
                        <h4 class="tl_info">Idioma(s)</h4>
                        <div>
                            <%
                            Detalle_Idioma_DAO d_idioma=new Detalle_Idioma_DAO();
                            ArrayList<Detalle_Idioma> l_i_idioma=d_idioma.Informacion(ID_P);
                            Iterator<Detalle_Idioma>i_iter=l_i_idioma.iterator();
                            Detalle_Idioma EN_detalle_idioma=null;
                            while(i_iter.hasNext()){
                                EN_detalle_idioma=i_iter.next();
                            %>
                            <p class="td_info_d"><%=EN_detalle_idioma.getIdioma().getNombre()%> , </p>
                            <%}%>
                        </div>
                        <br>
                        <h4 name="valor" class="valor_info">S/.<%=request.getAttribute("Valor")%></h4>
                        <br>
                        <div class="contenedor_button">
                            <button role="button" class="boton_is" href=""><i class="fas fa-shopping-cart icon"></i>Alquilar</button>
                            <button role="button" class="boton_is"><i class="fas fa-play icon"></i>Ver</button>
                        </div>
                    </div>
                    <input type="text" id="valor" name="valor" value="<%=request.getAttribute("Valor")%>"/>
                    <input type="text" id="id_pelicula" name="id_pelicula" value="<%=request.getAttribute("Id_pelicula")%>"/>
                    <input type="text" id="local_id_user" name="id_usuario" value="1"/>
                </form>
            </div>
	</main>
        <script type="text/javascript">
            
            window.onload=function Almacenar()
            {
                var aValue = localStorage.getItem('userName');
                var aRol=localStorage.getItem('userRol');
                var aId=localStorage.getItem('id');
                
                document.getElementById('user_name').innerHTML = aValue;
                document.getElementById('local_id_user').innerHTML=aId;
                
                document.getElementById("valor").style.visibility = "hidden";
                document.getElementById("id_pelicula").style.visibility = "hidden";
                document.getElementById("local_id_user").style.visibility = "hidden";
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
