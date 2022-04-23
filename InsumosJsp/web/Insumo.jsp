<%-- 
    Document   : Insumo
    Created on : 13/04/2022, 9:09:37 a. m.
    Author     : serdn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${usuario.getUsuarioDocumento()==null}">
        <% response.sendRedirect("index.jsp"); %>
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Insumo</title>
    </head>
    <body>
        <h1>Insumo</h1>
        <div class="d-flex">
            <div class="card col-sm-2">
                <div class="card-body"> 
                    <form action="InsumoControl?menu=Insumo" method="POST">
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" value="${Insumo.getCodigoInsumo()}" name="txtCodigoInsumo" class="form-control" minlength="3" maxlength="11" required>
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${Insumo.getInsumoNombre()}" name="txtInsumoNombre" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Marca</label>
                            <select class="form-control form-select" name="txtInsumoMarcaFK" required>
                                <option value="${Insumo.getInsumoMarcaFK()}">${Insumo.getMarcaNombre()}</option>
                                <c:forEach var="mar" items="${MarcaLista}">
                                    <option value="${mar.getIdMarca()}">${mar.getMarcaNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Riesgo</label>
                            <select class="form-control form-select" name="txtInsumoRiesgoFK" required>
                                <option value="${Insumo.getInsumoRiesgoFK()}">${Insumo.getRiesgoClasificacion()}</option>
                                <c:forEach var="rie" items="${RiesgoLista}">
                                    <option value="${rie.getIdRiesgo()}">${rie.getRiesgoClasificacion()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Presentacion</label>
                            <select class="form-control form-select" name="txtInsumoPresentacionFK" required>
                                <option value="${Insumo.getInsumoPresentacionFK()}">${Insumo.getPresentacionNombre()}</option>
                                <c:forEach var="pre" items="${PresentacionLista}">
                                    <option value="${pre.getIdPresentacion()}">${pre.getPresentacionNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Observacion</label>
                            <input type="text" value="${Insumo.getInsumoObservacion()}" name="txtInsumoObservacion" class="form-control" maxlength="100" required>
                        </div>
                        <div class="form-group">
                            <label>Existencia</label>
                            <input type="number" value="${Insumo.getInsumoExistencia()}" name="txtInsumoExistencia" class="form-control" min="0" max="9999999999" pattern="^[0-9]" required>
                        </div>
                        <div class="form-group">
                            <label>Temperatura</label>
                            <select class="form-control form-select" name="txtInsumoTemperaturaFK" required>
                                <option value="${Insumo.getInsumoTemperaturaFK()}">${Insumo.getTemperaturaNombre()}</option>
                                <c:forEach var="tem" items="${TemperaturaLista}">
                                    <option value="${tem.getIdTemperatura()}">${tem.getTemperaturaNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Imagen</label>
                            <input type="text" value="${Insumo.getInsumoRuta()}" name="txtInsumoRuta" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Invima</label>
                            <input type="text" value="<c:if test="${Insumo.getInsumoInvima()==null}">N/A</c:if> <c:if test="${Insumo.getInsumoInvima()!=null}">${Insumo.getInsumoInvima()}</c:if>"
                                   name="txtInsumoInvima" class="form-control" maxlength="50" required>
                            </div>
                            <div class="form-group">
                                <label>Lote</label>
                                    <input type="text" value="<c:if test="${Insumo.getInsumoLote()==null}">N/A</c:if><c:if test="${Insumo.getInsumoLote()!=null}">${Insumo.getInsumoLote()}</c:if>"
                                       name="txtInsumoLote" class="form-control" maxlength="45" required>
                            </div>
                            <div class="form-group">
                                <label>Vencimiento</label>
                                    <input type="date" value="${Insumo.getInsumoVence()}" name="txtInsumoVence" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Ficha Tecnica</label>
                            <input type="text" value="${Insumo.getInsumoFichaTecnica()}" name="txtInsumoFichaTecnica" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Ficha Tecnica</label>
                            <input type="number" value="${Insumo.getPorcentaje()}" name="txtPorcentaje" class="form-control" maxlength="45" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>  

            <div class="col-sm-14">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>MARCA</th>
                            <th>RIESGO</th>
                            <th>PRESENTACION</th>
                            <th>OBSERVACION</th>
                            <th>EXISTENCIA</th>
                            <th>TEMPERATURA</th>
                            <th>IMAGEN</th>
                            <th>INVIMA</th>
                            <th>LOTE</th>
                            <th>VENCIMIENTO</th>
                            <th>FICHA TECNICA</th>
                            <th>IVA</th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ins" items="${InsumoLista}">
                            <tr>
                                <td>${ins.getCodigoInsumo()}</td>
                                <td>${ins.getInsumoNombre()}</td>
                                <td>${ins.getMarcaNombre()}</td>
                                <td>${ins.getRiesgoClasificacion()}</td>
                                <td>${ins.getPresentacionNombre()}</td>
                                <td>${ins.getInsumoObservacion()}</td>
                                <td>${ins.getInsumoExistencia()}</td>
                                <td>${ins.getTemperaturaNombre()}</td>
                                <td>${ins.getInsumoRuta()}</td>
                                <td>${ins.getInsumoInvima()}</td>
                                <td>${ins.getInsumoLote()}</td>
                                <td>${ins.getInsumoVence()}</td>
                                <td>${ins.getInsumoFichaTecnica()}</td>
                                <td>${ins.getPorcentaje()}</td>
                                <td>   
                                    <a class="btn btn-warning" href="InsumoControl?menu=Insumo&accion=Editar&idEd=${ins.getCodigoInsumo()}">Editar</a>
                                    <a class="btn btn-danger" href="InsumoControl?menu=Insumo&accion=Eliminar&idEl=${ins.getCodigoInsumo()}">Eliminar</a>
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
