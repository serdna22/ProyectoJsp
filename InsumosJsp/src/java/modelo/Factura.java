/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Factura {

    private String idFactura;
    private String facturaProveedorFK;
    private String facturaArchivo;
    private Double facturaIvaTotal;
    private Double facturaDescuento;
    private String facturaFecha;
    private String facturaUsuario;

    public Factura() {
    }

    public Factura(String idFactura, String facturaProveedorFK, String facturaArchivo, Double facturaIvaTotal, Double facturaDescuento, String facturaFecha, String facturaUsuario) {
        this.idFactura = idFactura;
        this.facturaProveedorFK = facturaProveedorFK;
        this.facturaArchivo = facturaArchivo;
        this.facturaIvaTotal = facturaIvaTotal;
        this.facturaDescuento = facturaDescuento;
        this.facturaFecha = facturaFecha;
        this.facturaUsuario = facturaUsuario;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getFacturaProveedorFK() {
        return facturaProveedorFK;
    }

    public void setFacturaProveedorFK(String facturaProveedorFK) {
        this.facturaProveedorFK = facturaProveedorFK;
    }

    public String getFacturaArchivo() {
        return facturaArchivo;
    }

    public void setFacturaArchivo(String facturaArchivo) {
        this.facturaArchivo = facturaArchivo;
    }

    public Double getFacturaIvaTotal() {
        return facturaIvaTotal;
    }

    public void setFacturaIvaTotal(Double facturaIvaTotal) {
        this.facturaIvaTotal = facturaIvaTotal;
    }

    public Double getFacturaDescuento() {
        return facturaDescuento;
    }

    public void setFacturaDescuento(Double facturaDescuento) {
        this.facturaDescuento = facturaDescuento;
    }

    public String getFacturaFecha() {
        return facturaFecha;
    }

    public void setFacturaFecha(String facturaFecha) {
        this.facturaFecha = facturaFecha;
    }

    public String getFacturaUsuario() {
        return facturaUsuario;
    }

    public void setFacturaUsuario(String facturaUsuario) {
        this.facturaUsuario = facturaUsuario;
    }

}
