<%-- 
    Document   : Categoria
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
        <title>Procedimiento</title>
    </head>
    <body>
        <h1>Procedimientos</h1>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="ProcedimientoControl?menu=Procedimiento" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="number" value="${procedimientoEditar.getIdProcedimiento()}" name="txtIdProcedimiento" class="form-control" min="1" max="99999999" pattern="^[1-9]" disabled>
                        </div>
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${procedimientoEditar.getProcedimientoNombre()}" name="txtProcedimientoNombre" class="form-control" maxlength="45" required>
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
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th></th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="proc" items="${procedimientoLista}">
                            <tr>
                                <td>${proc.getIdProcedimiento()}</td>
                                <td>${proc.getProcedimientoNombre()}</td>

                                <td>
                                    <a class="btn btn-warning" href="ProcedimientoControl?menu=Procedimiento&accion=Editar&idEd=${proc.getIdProcedimiento()}">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="ProcedimientoControl?menu=Procedimiento&accion=Eliminar&idEli=${proc.getIdProcedimiento()}">Eliminar</a>
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
