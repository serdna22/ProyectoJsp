<%-- 
    Document   : Riesgo
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
        <title>Riesgo</title>
    </head>
    <body>
        <h1>Riesgos</h1>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="RiesgoControl?menu=Riesgo" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="number" value="${riesgoEditar.getIdRiesgo()}" name="txtIdRiesgo" class="form-control" min="1" max="999999" pattern="^[1-9]" required>
                        </div>
                        <div class="form-group">
                            <label>CLASIFICACION</label>
                            <input type="text" value="${riesgoEditar.getRiesgoClasificacion()}" name="txtRiesgoClasificacion" class="form-control" maxlength="10" required>
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
                            <th>CLASIFICACION</th>
                            <th></th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ries" items="${riesgoLista}">
                            <tr>
                                <td>${ries.getIdRiesgo()}</td>
                                <td>${ries.getRiesgoClasificacion()}</td>

                                <td>
                                    <a class="btn btn-warning" href="RiesgoControl?menu=Riesgo&accion=Editar&idEd=${ries.getIdRiesgo()}">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="RiesgoControl?menu=Riesgo&accion=Eliminar&idEli=${ries.getIdRiesgo()}">Eliminar</a>
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
