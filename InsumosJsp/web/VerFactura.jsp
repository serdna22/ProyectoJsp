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
        <title>Facturas</title>
    </head>
    <body>
        <h1>Facturas</h1>
        <div class="d-flex"> 
            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Proveedor</th>
                            <th>IVA total</th>
                            <th>Descuento</th>
                            <th>Fecha</th>
                            <th>Usuario</th>
                            <th></th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="fact" items="${FacturaLista}">
                            <tr>
                                <td>${fact.getIdFactura()}</td>
                                <td>${fact.getFacturaProveedorFK()}</td>
                                <td>${fact.getFacturaIvaTotal()}</td>
                                <td>${fact.getFacturaDescuento()}</td>
                                <td>${fact.getFacturaFecha()}</td>
                                <td>${fact.getDocumentoUsuario()}</td>

                                <td>
                                    <a class="btn btn-primary" href="FacturaControl?menu=Ver&accion=Listar&id=${fact.getIdFactura()}">Ver</a>
                                </td>
                                <td>
                                    <a class="btn btn-success" href="FacturaControl?menu=Factura&accion=Pdf&id=${fact.getIdFactura()}">Descargar Pdf</a>
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
