<%-- 
    Document   : Elemento
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
        <title>Elemento</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="ControladorA?menu=Elemento" method="POST">
                        <label>Tipo Documento</label>
                        <select class="form-control form-select" name="txtTipoD">
                            <option value="${Elemento.getElementoTipoIdenFK()}">${Elemento.getTipoDocNombre()}</option>
                            <c:forEach var="tip" items="${tipoDocumentoLista}">
                                <option value="${tip.getIdTipoDoc()}">${tip.getTipoDocNombre()}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <div class="form-group">
                            <label>Documento</label>
                            <input type="number" value="${Elemento.getElementoDocumento()}" name="txtDocumento" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${Elemento.getElementoNombre()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="${Elemento.getEmail()}" name="txtCorreo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" value="${Elemento.getPassword()}" name="txtContraseña" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Celular</label>
                            <input type="number" value="${Elemento.getElementoCelular()}" name="txtCelular" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Privilegio</label>
                            <select class="form-control form-select" name="txtPrivilegio">
                                <option value="${Elemento.getElementoPrivilegio()}">Seleccionar</option>
                                <option value="1">Administrador</option>
                                <option value="2">Elemento</option>
                            </select>                
                        </div>
                        <br>
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
                        <c:forEach var="em" items="${ElementosLista}">
                            <tr>
                                <td>${em.getTipoDocNombre()}</td>
                                <td>${em.getElementoDocumento()}</td>
                                <td>${em.getElementoNombre()}</td>
                                <td>${em.getEmail()}</td>
                                <td>${em.getPassword()}</td>
                                <td>${em.getElementoCelular()}</td>
                                <td> <c:if test="${em.getElementoPrivilegio()==1}">
                                        Administrador
                                    </c:if>
                                    <c:if test="${em.getElementoPrivilegio()==2}">
                                        Elemento
                                    </c:if></td> 
                                <td>
                                    <a class="btn btn-warning" href="ControladorA?menu=Elemento&accion=Editar&id=${em.getElementoDocumento()}">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="ControladorA?menu=Elemento&accion=Eliminar&id=${em.getElementoDocumento()}">Eliminar</a>
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
