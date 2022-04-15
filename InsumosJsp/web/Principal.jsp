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
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Inicio</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Insumos
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Insumo</a></li>
                                <li><a class="dropdown-item" href="#">Medicamento</a></li>
                                <li><a class="dropdown-item" href="#">Marca</a></li>
                                <li><a class="dropdown-item" href="#">Riesgo</a></li>
                                <li><a class="dropdown-item" href="#">Presentacion</a></li>
                                <li><a class="dropdown-item" href="#">Principio Activo</a></li>
                                <li><a class="dropdown-item" href="#">Forma Farmaceutica</a></li>
                                <li><a class="dropdown-item" href="#">Concentracion</a></li>
                                <li><a class="dropdown-item" href="#">Unidad de Medidada</a></li>
                                <li><a class="dropdown-item" href="#">Temperatura</a></li>
                                <li><a class="dropdown-item" href="#">Alerta</a></li>
                                <li><a class="dropdown-item" href="#">StockExcel</a></li>
                                <li><a class="dropdown-item" href="#">StockPdf</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Elementos
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Elementos</a></li>
                                <li><a class="dropdown-item" href="#">Categorias</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Personas
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Usuarios</a></li>
                                <li><a class="dropdown-item" href="#">Proveedores</a></li>
                                <li><a class="dropdown-item" href="#">Consultorios</a></li>
                                <li><a class="dropdown-item" href="#">Procedimientos</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Factura</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Salida</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="mt-4" style="height: 600px; margin-left: 10px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
