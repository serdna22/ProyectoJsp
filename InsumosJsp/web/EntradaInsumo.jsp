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
                            <input type="text" value="" name="txtIdEntradaInsumo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Proveedor</label>
                            <select class="form-control form-select" name="txtEntradaInsumoPresentacion">
                                <option value=""></option>
                                <c:forEach var="pre" items="">
                                    <option value=""></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Descuentos</label>
                            <input type="number" value="" name="txtIdEntradaInsumo" class="form-control">
                        </div>
                        <h4>Entrada de Insumos</h4>
                        <div class="form-group">
                            <label>Insumos</label>
                            <select class="form-control form-select" name="txtEntradaInsumoCategoria">
                                <option value=""></option>
                                <c:forEach var="ele" items="">
                                    <option value=""></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Cantidad</label>
                            <input type="number" value="" name="txtEntradaInsumoCantidad" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Unidades de:</label>
                            <input type="number" value="" name="txtEntradaInsumoCantidad" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Lote</label>
                            <input type="text" value="" name="txtEntradaInsumoRuta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Invima</label>
                            <input type="text" value="" name="txtEntradaInsumoRuta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha Vencimiento</label>
                            <input type="date" value="" name="txtEntradaInsumoRuta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>IVA</label>
                            <input type="number" value="" name="txtEntradaInsumoRuta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Valor Unitario</label>
                            <input type="number" value="" name="txtEntradaInsumoRuta" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar Insumo" class="btn btn-primary">
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
                        <c:forEach var="ele" items="">
                            <tr>
                                <td>imagen jaj</td>
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
