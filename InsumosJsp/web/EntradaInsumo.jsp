<%-- 
    Document   : EntradaInsumo
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
        <title>EntradaInsumo</title>
    </head>
    <body>
        <h1>FACTURA INSUMOS</h1>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body"> 
                    <form action="EntradaInsumoControl?menu=EntradaInsumo" method="POST">
                        <div class="form-group">
                            <label>CODIGO FACTURA</label>
                            <input type="text" value="" name="txtIdFactura" class="form-control" maxlength="11" minlength="3" required>
                        </div>
                        <div class="form-group">
                            <label>Proveedor</label>
                            <select class="form-control form-select" name="txtFacturaProveedorFK" required>
                                <option value="">Seleccionar</option>
                                <c:forEach var="pro" items="${ProveedorLista}">
                                    <option value="${pro.getNitProveedor()}">${pro.getProveedorNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Descuentos</label>
                            <input type="number" value="" name="txtFacturaDescuento" class="form-control" max="3" pattern="^[1-9]">
                        </div>
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
                            <input type="number" value="" name="txtDFcantidadInsumo" class="form-control" 
                                   min="1" max="999999" pattern="^[1-9]" placeholder="Ejemplo: 8 cajas,45 paquetes">
                        </div>
                        <div class="form-group">
                            <label>Unidades de:</label>
                            <input type="number" value="" name="txtDFcantidadInsumo2" class="form-control" 
                                   min="1" max="999999999" pattern="^[1-9]" placeholder="Ejemplo: Cajas x 50 UN, paquetes x 100 UN">
                        </div>
                        <div class="form-group">
                            <label>Lote</label>
                            <input type="text" value="" name="txtDFlote" class="form-control" maxlength="45">
                        </div>
                        <div class="form-group">
                            <label>Invima</label>
                            <input type="text" value="" name="txtDFinvima" class="form-control" maxlength="45">
                        </div>
                        <div class="form-group">
                            <label>Fecha Vencimiento</label>
                            <input type="date" value="" name="txtDFfechaVence" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>IVA</label>
                            <input type="number" value="" name="txtDFiva" class="form-control" min="1" max="3" pattern="^[1-9]">
                        </div>
                        <div class="form-group">
                            <label>Valor Unitario</label>
                            <input type="number" value="" name="txtDFvalorUnitario" class="form-control" min="1" max="999999999" pattern="^[1-9]">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                        <input type="submit" name="accion" value="Vaciar Factura" class="btn btn-danger">
                    </form>
                </div>
            </div>  

            <div class="col-sm-9">
                <label>Factura</label>
                <label>Proveedor</label>
                <label>Subtotal</label>
                <label>Neto</label>
                <table class="table table-hover">
                    <input type="submit" name="accion" value="Guardar Factura" class="btn btn-success">
                    <thead>
                        <tr>
                            <th>Imagen</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Unidades</th>
                            <th>Presentacion</th>
                            <th>Observacion</th>
                            <th>Lote</th>
                            <th>Invima</th>
                            <th><img src="img/relojdearena.png" alt=""/></th>
                            <th>IVA</th>
                            <th>Valor Unitario</th>
                            <th>Valor Total</th>
                            <th>Quitar</th>
                    
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ele" items="${agregarInsumoListas}">
                            <tr>
                                <td>${ele.getIdFactura()}</td>
                                <td>n</td>
                                <td>c</td>
                                <td>un</td>
                                <td>pr</td>
                                <td>ob</td>
                                <td>lot</td>
                                <td>invi</td>
                                <td>vence</td>
                                <td>vence</td>
                                <td>iv</td>
                                <td>vu</td>
                                <td>vt</td>
                                <td>   
                                    <a class="btn btn-warning" href="#">Quitar</a>
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
