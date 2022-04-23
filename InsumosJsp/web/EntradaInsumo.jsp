<%-- 
    Document   : EntradaInsumo
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
        <title>Entrada Insumo</title>
    </head>
    <body>
        <h2>Factura Insumo</h2>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="EntradaInsumoControl?menu=EntradaInsumo" method="POST">
                        <div class="form-group">
                            <label>CODIGO FACTURA</label>
                            ${repetido}
                            <input type="text" value="${factura.getIdFactura()}" name="txtIdFactura" class="form-control" maxlength="11" minlength="3" required>
                        </div>
                        <div class="form-group">
                            <label>Proveedor</label>
                            <select class="form-control form-select" name="txtFacturaProveedorFK" required>
                                <option value="${factura.getFacturaProveedorFK()}">${factura.getNombreProveedor()}</option>
                                <c:forEach var="pro" items="${ProveedorLista}">
                                    <option value="${pro.getNitProveedor()}">${pro.getProveedorNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Descuentos</label>
                            <input type="number" value="${factura.getFacturaDescuento()}" name="txtFacturaDescuento" class="form-control" max="300" pattern="^[1-9]" required>
                        </div>
                        <%  %>
                        <h4>Entrada de Insumos</h4>
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
                            <label>Cantidad</label>
                            <input type="number" value="1" name="txtDFcantidadInsumo" class="form-control" 
                                   min="1" max="999999" pattern="^[1-9]" placeholder="Ejemplo: 8 cajas,45 paquetes" required>
                        </div>
                        <div class="form-group">
                            <label>Unidades de:</label>
                            <input type="number" value="1" name="txtDFcantidadInsumo2" class="form-control " 
                                   min="1" max="999999999" pattern="^[1-9]" placeholder="Ejemplo: Cajas x 50 UN, paquetes x 100 UN" required>
                        </div>
                        <div class="form-group">
                            <label>Lote</label>
                            <input type="text" value="" name="txtDFlote" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Invima</label>
                            <input type="text" value="" name="txtDFinvima" class="form-control" maxlength="45" required>
                        </div>
                        <div class="form-group">
                            <label>Fecha Vencimiento</label>
                            <input type="date" value="" name="txtDFfechaVence" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>IVA</label>
                            <input type="number" value="19" name="txtDFiva" class="form-control" min="0" max="30" pattern="^[0-9]" required>
                        </div>
                        <div class="form-group">
                            <label>Valor por Unidad</label>
                            <input type="number" value="" name="txtDFvalorUnitario" class="form-control" 
                                   min="1" max="9999999999" pattern="^[1-9]" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" id="btnAgregar" class="btn btn-primary">
                        <a  class="btn btn-danger" href="EntradaInsumoControl?menu=EntradaInsumo&accion=Vaciar">Vaciar Factura</a>
                    </form>
                </div>
            </div>  
            <div class="col-sm-9">
                <a class="btn btn-success" href="EntradaInsumoControl?menu=EntradaInsumo&accion=Guardar">Guardar Factura</a>
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
                            <th>IVA</th>
                            <th>Valor Unitario</th>
                            <th>Valor Total</th>
                            <th>Quitar</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listarDF" items="${sessionScope.listaDF}" varStatus="status">
                            <tr>
                                <td><c:out value="${status.index+1}" /> </td>
                                <td>${listarDF.getNombreInsumo()}</td>
                                <td>${listarDF.getDFcantidadInsumo()}</td>
                                <td>${listarDF.getDFlote()}</td>
                                <td>${listarDF.getDFinvima()}</td>
                                <td>${listarDF.getDFfechaVence()}</td>
                                <td>${listarDF.getDFiva()}</td>
                                <td>${listarDF.getDFvalorUnitario()}</td>
                                <td>${listarDF.getDFvalorTotal()}</td>
                                <td>   
                                    <a class="btn btn-danger" href="EntradaInsumoControl?menu=EntradaInsumo&accion=Quitar&idQu=${status.index}">Quitar</a>
                                </td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-success" href="EntradaInsumoControl?menu=EntradaInsumo&accion=Guardar">Guardar Factura</a>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
