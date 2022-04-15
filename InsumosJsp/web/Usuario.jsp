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
        <title>Usuario</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="ControladorA?menu=Usuario" method="POST">
                        <select class="form-control form-select" name="txtTipoD">
                            <option selected>Tipo Documento</option>
                            <c:forEach var="em" items="${usuariosLista}">
                                <option value="${em.getUsuarioTipoIdenFK()}">${em.getUsuarioDocumento()}</option>
                            </c:forEach>
                        </select>
                        <div class="form-group">
                            <label>Documento</label>
                            <input type="number" value="${usuario.getUsuarioDocumento()}" name="txtDocumento" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${usuario.getUsuarioNombre()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="${usuario.getEmail()}" name="txtCorreo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" value="${usuario.getPassword()}" name="txtContraseña" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Celular</label>
                            <input type="number" value="${usuario.getUsuarioCelular()}" name="txtCelular" class="form-control">
                        </div>
                        <select class="form-select form-control" name="txtPrivilegio">
                            <option selected>Tipo Privilegio</option>        
                            <option value="${usuario.getUsuarioPrivilegio()}">Administrador</option>
                            <option value="2">Usuario</option>
                            <option value="3">Supervisor</option>
                        </select>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>  

            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>TIPO DOCUMENTO</th>
                            <th>DOCUMENTO</th>
                            <th>NOMBRES</th>
                            <th>EMAIL</th>
                            <th>CONTRASEÑA</th>
                            <th>CELULAR</th>
                            <th>PRIVILEGIO</th>
                            <th></th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${usuariosLista}">
                            <tr>
                                <td>${em.getUsuarioTipoIdenFK()}</td>
                                <td>${em.getUsuarioDocumento()}</td>
                                <td>${em.getUsuarioNombre()}</td>
                                <td>${em.getEmail()}</td>
                                <td>${em.getPassword()}</td>
                                <td>${em.getUsuarioCelular()}</td>
                                <td>${em.getUsuarioPrivilegio()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ControladorA?menu=Usuario&accion=Editar&id=${em.getUsuarioDocumento()}">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="ControladorA?menu=Usuario&accion=Eliminar&id=${em.getUsuarioDocumento()}">Eliminar</a>
                                </td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
