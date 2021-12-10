<%-- 
    Document   : Actor_Princpal
    Created on : Dec 3, 2021, 12:18:41 AM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Actor"%>
<%@page import="Modelo_DAO.Actor_DAO"%>
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
                <div class="configuracion-mostrar-administracion">
                    <a class="btn-crud" href="Controlador_A?accion=registrar"><i class="fas fa-plus"></i></a> 
                    <br>
		    <div class="input-contenedor all">
                        <%
      
                            
                            Actor_DAO _actor=new Actor_DAO();
                            Iterator<Actor>iter=null;
                            ArrayList<Actor> l_actor_b=_actor.Listar();
                            iter=l_actor_b.iterator();
                        %>
                        <form action="" class="input-search">
                            <input type="text" name="txtbuscar" class="input-buscar" placeholder="Buscar"/>
                            <input type="submit" value="Buscar" class="modificar-form search"/>
                        </form>
                        <%
                            String nombuscar=request.getParameter("txtbuscar");
                  
                            if(nombuscar!=null)
                            {
                                ArrayList<Actor> l_actor_l=_actor.Buscar(nombuscar);
                                iter=l_actor_l.iterator();
                            }
                       
                        %>
                    </div>
                    <br>
                    <table class="table">
                        <tr class="content-value-p">
                            <th class="text-content"> Nombres </th>
                            <th class="text-content"> Apellidos </th>
                        </tr>
                        <%
                            Actor actor=null;
                            while(iter.hasNext()){
                                actor=iter.next();
                        %>
                        <tr class="content-value">
                            <td class="text-value"><%=actor.getElenco().getNombres()%></td>
                            <td class="text-value"><%=actor.getElenco().getApellidos()%></td>
                            <td class="text-button"> 
                                <a class="btn-crud" href="Controlador_A?accion=actualizar&id=<%=actor.getElenco().getID()%>"><i class="fas fa-wrench"></i></a> 
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
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
