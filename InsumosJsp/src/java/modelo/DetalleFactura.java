/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author Pc_Estiven
 */
public class DetalleFactura {

    private int idDetalleFactura;
    private String DFfacturaFK;
    private String DFinsumoFK;
    private int DFcantidadInsumo;
    private String DFlote;
    private String DFfechaVence;
    private String DFinvima;
    private float DFiva;
    private Double DFvalorUnitario;
    private Double DFvalorTotal;
    private String nombreInsumo;

    public DetalleFactura() {
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public String getDFfacturaFK() {
        return DFfacturaFK;
    }

    public void setDFfacturaFK(String DFfacturaFK) {
        this.DFfacturaFK = DFfacturaFK;
    }

    public String getDFinsumoFK() {
        return DFinsumoFK;
    }

    public void setDFinsumoFK(String DFinsumoFK) {
        this.DFinsumoFK = DFinsumoFK;
    }

    public int getDFcantidadInsumo() {
        return DFcantidadInsumo;
    }

    public void setDFcantidadInsumo(int DFcantidadInsumo) {
        this.DFcantidadInsumo = DFcantidadInsumo;
    }

    public String getDFlote() {
        return DFlote;
    }

    public void setDFlote(String DFlote) {
        this.DFlote = DFlote;
    }

    public String getDFfechaVence() {
        return DFfechaVence;
    }

    public void setDFfechaVence(String DFfechaVence) {
        this.DFfechaVence = DFfechaVence;
    }

    public String getDFinvima() {
        return DFinvima;
    }

    public void setDFinvima(String DFinvima) {
        this.DFinvima = DFinvima;
    }

    public float getDFiva() {
        return DFiva;
    }

    public void setDFiva(float DFiva) {
        this.DFiva = DFiva;
    }

    public Double getDFvalorUnitario() {
        return DFvalorUnitario;
    }

    public void setDFvalorUnitario(Double DFvalorUnitario) {
        this.DFvalorUnitario = DFvalorUnitario;
    }

    public Double getDFvalorTotal() {
        return DFvalorTotal;
    }

    public void setDFvalorTotal(Double DFvalorTotal) {
        this.DFvalorTotal = DFvalorTotal;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }
    
}
