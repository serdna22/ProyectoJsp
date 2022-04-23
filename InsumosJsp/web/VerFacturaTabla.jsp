<%-- 
    Document   : Facturas
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
        <title>Detalle Factura</title>
    </head>
    <body>
        <h1>Factura</h1>
        <h1 class="h2">Encabezado h1 con estilo h2</h1>
        <div class="d-flex">
            <label class="btn-primary">Factura: ${FacturaListaId.getIdFactura()}</label>
        </div>
        <div class="d-flex">
            <label class="btn-primary">Proveedor: ${FacturaListaId.getFacturaProveedorFK()}</label>  
        </div>
        <div class="d-flex">
            <label class="btn-primary">IVA Total: ${FacturaListaId.getFacturaIvaTotal()}</label>
        </div>
        <div class="d-flex">
            <label class="btn-primary">Descuento: ${FacturaListaId.getFacturaDescuento()}</label>
        </div>
        <div class="d-flex">
            <label class="btn-primary">Fecha: ${FacturaListaId.getFacturaFecha()}</label>
        </div>
        <div class="d-flex">
            <label class="btn-primary">Usuario Responsable: ${FacturaListaId.getDocumentoUsuario()}</label> 
        </div>
        <h1>Detalle Factura</h1>
        <div class="d-flex"> 
            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Insumo</th>
                            <th>Cantidad</th>
                            <th>Lote</th>
                            <th>Vencimiento</th>
                            <th>Invima</th>
                            <th>Iva</th>
                            <th>Valor por Unidad</th>
                            <th>Valor Total</th>
                            <th></th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detfact" items="${DetalleFacturaId}" varStatus="status">
                            <tr>
                                <td><c:out value="${status.index+1}" /> </td>
                                <td>${detfact.getDFinsumoFK()}</td>
                                <td>${detfact.getDFcantidadInsumo()}</td>
                                <td>${detfact.getDFlote()}</td>
                                <td>${detfact.getDFfechaVence()}</td>
                                <td>${detfact.getDFinvima()}</td>
                                <td>${detfact.getDFiva()}</td>
                                <td>${detfact.getDFvalorUnitario()}</td>
                                <td>${detfact.getDFvalorTotal()}</td>

                                <td>
                                    <a class="btn btn-primary" href="FacturaControl?menu=Ver&accion=Editar&id=${detfac.getDFfacturaFK()}">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-success" href="FacturaControl?menu=Factura&accion=Eliminar&id=${detfac.getDFfacturaFK()}">Eliminar</a>
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
