<%-- 
    Document   : Factura_Principal
    Created on : Dec 9, 2021, 6:56:41 AM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Factura"%>
<%@page import="Modelo.Director"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo_DAO.Factura_DAO"%>
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
                    <br>
		    <div class="input-contenedor all">
                        <form action="Controlador_A" class="input-search">
                            <input type="search" name="txtbuscar" class="input-buscar" placeholder="Buscar"/>
                            <input type="submit" value="Buscar" class="modificar-form search" name="accion"/>
                        </form>
                    </div>
	   
                    <br>
                    <table class="table">
                        <tr class="content-value-p">
                            <th class="text-content"> Nombres de Pelicula </th>
                            <th class="text-content"> Valor </th>
                            <th class="text-content"> Total </th>
                            <th class="text-content"> IGV </th> 
                            <th class="text-content"> Fecha </th>
                        </tr>
                        <%
                            Factura_DAO _factura=new Factura_DAO();
                            ArrayList<Factura> l_factura=_factura.Listar();
                            Iterator<Factura>iter=l_factura.iterator();
                            Factura factura=null;
                            while(iter.hasNext()){
                                factura=iter.next();
                        %>
                        <tr class="content-value">
                            <td class="text-value"><%=factura.getAlquiler().getPelicula().getNombre()%></td>
                            <td class="text-value"><%=factura.getValoe()%></td>
                            <td class="text-value"><%=factura.getTotal()%></td>
                            <td class="text-value"><%=factura.getIGV()%></td>
                            <td class="text-value"><%=factura.getFecha()%></td>
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
