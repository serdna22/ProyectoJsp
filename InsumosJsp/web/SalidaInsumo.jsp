<%-- 
    Document   : SalidaInsumo
    Created on : 13/04/2022, 9:09:37 a. m.
    Author     : serdn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <c:if test="${usuario.getUsuarioDocumento()==null}">
        <% response.sendRedirect("index.jsp"); %>
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>SalidaInsumo</title>
    </head>
    <body>
        <h2>Salida INSUMOS</h2>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="SalidaInsumoControl?menu=SalidaInsumo" method="POST">
                        <div class="form-group">
                            <label>Codigo Salida</label>
                            ${repetido}
                            <input type="text" value="${Salida.getIdSalida()}" name="txtIdSalida" class="form-control" maxlength="11" minlength="3" required>
                        </div>
                        <div class="form-group">
                            <label>Consultorio</label>
                            <select class="form-control form-select" name="txtSalidaConsultorioFK" required>
                                <option value="${Salida.getSalidaConsultorioFK()}">${Salida.getNombreConsultorio()}</option>
                                <c:forEach var="conS" items="${ConsultorioLista}">
                                    <option value="${conS.getIdConsultorio()}">${conS.getConsultorioNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Procedimiento</label>
                            <select class="form-control form-select" name="txtSalidaProcedimientoFK" required>
                                <option value="${Salida.getSalidaProcedimientoFK()}">${Salida.getNombreProcedimiento()}</option>
                                <c:forEach var="proS" items="${ProcedimientoLista}">
                                    <option value="${proS.getIdProcedimiento()}">${proS.getProcedimientoNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Sala</label>
                            <input type="text" value="${Salida.getSalidaSala()}" name="txtSalidaSala" class="form-control" minlength="3" maxlength="10"  required>
                        </div>
                        <div class="form-group">
                            <label>Persona que Recibe</label>
                            <input type="text" value="${Salida.getSalidaPersonaRecibio()}" name="txtSalidaPersonaRecibio" class="form-control" minlength="5" maxlength="45"  required>
                        </div>

                        <h4>Salida de Insumos</h4>
                        <div class="form-group">
                            <label>Insumos</label>
                            <select class="form-control form-select" name="txtDFinsumoFK" required>
                                <option value="">Seleccionar</option>
                                <c:forEach var="ins" items="${InsumoLista}">
                                    <option value="${ins.getCodigoInsumo()}">${ins.getInsumoNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Cantidad Actual</label>
                            <input type="number" value="${insumoActual.getInsumoExistencia()}" name="txtDScantidad" class="form-control" disabled>                          
                        </div>
                        <div class="form-group">
                            <label>Cantidad</label>
                            <input type="number" value="1" name="txtDScantidad" class="form-control" 
                                   min="1" max="999999" pattern="^[1-9]" placeholder="Ejemplo: 8 cajas,45 paquetes" required>
                        </div>
                        <div class="form-group">
                            <label>Unidades de:</label>
                            <input type="number" value="1" name="txtDScantidad2" class="form-control " 
                                   min="1" max="999999999" pattern="^[1-9]" placeholder="Ejemplo: Cajas x 50 UN, paquetes x 100 UN" required>
                        </div>
                        <div class="form-group">
                            <label>Lote</label>
                            <input type="text" value="${insumoActual.getInsumoLote()}" name="txtDSlote" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Invima</label>
                            <input type="text" value="${insumoActual.getInsumoInvima()}" name="txtDSinvima" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Fecha Vencimiento</label>
                            <input type="date" value="${insumoActual.getInsumoVence()}" name="txtDSfechaVence" class="form-control" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" id="btnAgregar" class="btn btn-primary">
                        <a  class="btn btn-danger" href="SalidaInsumoControl?menu=SalidaInsumo&accion=Vaciar">Vaciar Salida</a>
                    </form>
                </div>
            </div>  
            <div class="col-sm-9">
                <a class="btn btn-success" href="SalidaInsumoControl?menu=SalidaInsumo&accion=Guardar">Guardar Salida</a>
                <br><br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Lote</th>
                            <th>Invima</th>
                            <th>Vencimiento</th>
                            <th>Quitar</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listarDS" items="${sessionScope.listaDS}" varStatus="status">
                            <tr>
                                <td><c:out value="${status.index+1}" /> </td>
                                <td>${listarDS.getNombreInsumo()}</td>
                                <td>${listarDS.getDScantidad()}</td>
                                <td>${listarDS.getDSlote()}</td>
                                <td>${listarDS.getDSinvima()}</td>
                                <td>${listarDS.getDSfechaVence()}</td>
                                <td>   
                                    <a class="btn btn-danger" href="SalidaInsumoControl?menu=SalidaInsumo&accion=Quitar&idQu=${status.index}">Quitar</a>
                                </td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-success" href="SalidaInsumoControl?menu=SalidaInsumo&accion=Guardar">Guardar Salida</a>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
