 <%-- 
    Document   : Principal
    Created on : 12/04/2022, 3:57:36 p. m.
    Author     : serdn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border:none"  class="btn btn-outline-light" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none"  class="btn btn-outline-light" href="ControladorE?menu=Producto" target="myFrame">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ControladorE?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ControladorE?menu=Clientes" target="myFrame">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ControladorE?menu=RegistrarVenta" target="myFrame">Nueva Venta</a>
                    </li>
                </ul>
            </div>
            <div>
                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton " 
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Perfil
                    </button>
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                            <img src="images/iot.jpg" alt="60" width="60"/>
                        </a>
                        <a class="dropdown-item" href="#">${usuario.getNom()}</a>
                        <a class="dropdown-item" href="#">${usuario.getDni()}</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button  name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
                        <div class="mt-4" style="height: 600px; margin-left: 10px">
                            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
                        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
