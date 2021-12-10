<%-- 
    Document   : Factura
    Created on : Dec 3, 2021, 12:01:14 AM
    Author     : USUARIO
--%>

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
            <div class="contenedor account">
		<h2 class="logotipo">CUBE</h2>
            </div>
	</header>
        <main class="contenedor-master-c">
            <div class="contenedor-account-fac">
                <div class="account-title"><h1 class="title-account-p">Datos de Facturacion</h1></div>
		<div class="content-account-off">
                <div class="account-can">
                    <form>
                       <h2 class="title-account-s">Facturacion y Alquilar</h2>
                       <input type="submit" value="Cancelar" class="modificar-form xp" name="accion"/> 
                    </form>
                </div>
                <div class="caccount-re">
                    <form>
                        <table class="table win">
                            <tr class="content-value-p">
                                <th class="text-content">Fecha</th>
                                <th class="text-content">Valor</th>
                                <th class="text-content">IGV</th>
                                <th class="text-content">Total</th>
                            </tr>
                            <tr class="content-value">
                                <td class="text-value">12-12-12</td>
                                <td class="text-value">4</td>
                                <td class="text-value">18.8%</td>
                                <td class="text-value">40</td>
                            </tr>
                        </table>
                        <input type="submit" value="Registrar" class="modificar-form xp" name="accion"/> 
                    </form>
                </div>
		</div>
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