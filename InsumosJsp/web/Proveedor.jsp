<%-- 
    Document   : Usuario
    Created on : 13/04/2022, 9:09:37 a. m.
    Author     : serdn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Proveedor</title>
    </head>
    <body>
        <h1>Proveedor</h1>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="ProveedorControl?menu=Proveedor" method="POST">
                        <div class="form-group">
                            <label>NIT</label>
                            <input type="text" value="${proveedorEditar.getNitProveedor()}" name="txtNitProveedor" class="form-control" maxlength="20" required>
                        </div>
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${proveedorEditar.getProveedorNombre()}" name="txtProveedorNombre" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>DIRECCION</label>
                            <input type="text" value="${proveedorEditar.getProveedorDireccion()}" name="txtProveedorDireccion" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>TELEFONO</label>
                            <input type="number" value="${proveedorEditar.getProveedorTelefono()}" name="txtProveedorTelefono" class="form-control" pattern="^[1-9]" min="1" "maxlength="30" required>
                        </div>
                        <div class="form-group">
                            <label>CELULAR</label>
                            <input type="number" value="${proveedorEditar.getProveedorCelular()}" name="txtProveedorCelular" class="form-control" pattern="^[1-9]" min="1" "maxlength="30" required>
                        </div>
                        <div class="form-group">
                            <label>FECHA</label>
                            <input type="date" value="${proveedorEditar.getProveedorFecha()}" name="txtProveedorFecha" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>CIUDAD</label>
                            <input type="text" value="${proveedorEditar.getProveedorCiudad()}" name="txtProveedorCiudad" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>CORREO</label>
                            <input type="email" value="${proveedorEditar.getProveedorCorreo()}" name="txtProveedorCorreo" class="form-control" maxlength="45" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>  
                </div>
            </div>  

            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>NIT</th>
                            <th>NOMBRE</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>CELULAR</th>
                            <th>FECHA</th>
                            <th>CIUDAD</th>
                            <th>CORREO</th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${proveedorLista}">
                            <tr>
                                <td>${em.getNitProveedor()}</td>
                                <td>${em.getProveedorNombre()}</td>
                                <td>${em.getProveedorDireccion()}</td>
                                <td>${em.getProveedorTelefono()}</td>
                                <td>${em.getProveedorCelular()}</td>
                                <td>${em.getProveedorFecha()}</td>
                                <td>${em.getProveedorCiudad()}</td>
                                <td>${em.getProveedorCorreo()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ProveedorControl?menu=Proveedor&accion=Editar&idEd=${em.getNitProveedor()}">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="ProveedorControl?menu=Proveedor&accion=Eliminar&idEli=${em.getNitProveedor()}">Eliminar</a>
                                </td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
