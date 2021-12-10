<%-- 
    Document   : Cliente_Principal
    Created on : Dec 2, 2021, 11:59:22 PM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo_DAO.Cliente_DAO"%>
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
		    <div class="input-contenedor all">
                        <form action="Controlador_A" class="input-search">
                            <input type="search" name="txtbuscar" class="input-buscar" placeholder="Buscar"/>
                            <input type="submit" value="Buscar" class="modificar-form search" name="accion"/>
                        </form>
                    </div>
                    <br>
                    <table class="table">
                        <tr class="content-value-p">
                            <th class="text-content">Nombre</th>
                            <th class="text-content">Apellido</th>
                            <th class="text-content">Correo</th>
                            <th class="text-content">Estado</th>
                        </tr>
                        <%
                            Cliente_DAO _cliente=new Cliente_DAO();
                            ArrayList<Cliente> l_cliente=_cliente.Listar();
                            Iterator<Cliente>iter=l_cliente.iterator();
                            Cliente cliente=null;
                            while(iter.hasNext()){
                                cliente=iter.next();
                        %>
                        <tr class="content-value">
                            <td class="text-value"><%=cliente.getUsuario().getNombre()%></td>
                            <td class="text-value"><%=cliente.getUsuario().getApellido()%></td>
                            <td class="text-value"><%=cliente.getUsuario().getCorrego()%></td>
                            <td class="text-value"> 
                                <%
                                    if(cliente.getUsuario().getEstado()==1)
                                    {
                                        %><form action="Controlador_U?accion=Desactivar&id=<%=cliente.getUsuario().getID()%>" style="">
                                            <a class="btn-crud" href="Controlador_U?accion=desactivar&id=<%=cliente.getUsuario().getID()%>"><i class="fas fa-unlock-alt"></i></a>
                                        </form>
                                        <%
                                    }
                                    else if(cliente.getUsuario().getEstado()==0)
                                    {
                                        %><form action="Controlador_U?accion=Activar&id=<%=cliente.getUsuario().getID()%>" style="">
                                            <a class="btn-crud" href="Controlador_U?accion=activar&id=<%=cliente.getUsuario().getID()%>"><i class="fas fa-lock"></i></a>
                                        </form><%
                                    }
                                %>
                            </td>
                        </tr>
                        <%}%>
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
