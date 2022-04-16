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
        <title>Insumos</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#" target="myFrame">Inicio</a>
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
                                <li><a class="dropdown-item" href="#" target="myFrame">Insumo</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Medicamento</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Marca</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Riesgo</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Presentacion</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Principio Activo</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Forma Farmaceutica</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Concentracion</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Unidad de Medidada</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Temperatura</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Alerta</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">StockExcel</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">StockPdf</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Elementos
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="#" target="myFrame">Elementos</a></li>
                                <li><a class="dropdown-item" href="CategoriaControl?menu=Categoria&accion=Listar" target="myFrame">Categorias</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Personas
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="ControladorA?menu=Usuario&accion=Listar" target="myFrame">Usuarios</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Proveedores</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Consultorios</a></li>
                                <li><a class="dropdown-item" href="#" target="myFrame">Procedimientos</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" target="myFrame">Factura</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" target="myFrame">Salida</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div>
                <a class="btn btn-outline-light dropdown-toggle"
                   href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                    Perfil
                </a>
                <ul class="dropdown-menu"aria-labelledby="dropdownMenuLink" style="margin-left: 84%">
                    <li><a class="dropdown-item" href="#">${usuario.getEmail()}</a></li>
                    <li><a class="dropdown-item" href="#">${usuario.getUsuarioNombre()}</a></li>
                    <div class="dropdown-divider"></div>
                    <form action="Login" method="POST">
                        <button  name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>

                </ul>
            </div>
        </nav>
        <div class="mt-4" style="height: 900px; margin-left: 10px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
