/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Pc_Estiven
 */
public class DetalleFactura {

    private int idDetalleFactura;
    private String DFfacturaFK;
    private int DFinsumoFK;
    private int DFcantidadInsumo;
    private String DFlote;
    private Date DFfechaVence;
    private String DFinvima;
    private float DFiva;
    private Double DFvalorUnitario;
    private Double DFvalorTotal;

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

    public int getDFinsumoFK() {
        return DFinsumoFK;
    }

    public void setDFinsumoFK(int DFinsumoFK) {
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

    public Date getDFfechaVence() {
        return DFfechaVence;
    }

    public void setDFfechaVence(Date DFfechaVence) {
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

    public DetalleFactura(int idDetalleFactura, String DFfacturaFK, int DFinsumoFK, int DFcantidadInsumo, String DFlote, Date DFfechaVence, String DFinvima, float DFiva, Double DFvalorUnitario, Double DFvalorTotal) {
        this.idDetalleFactura = idDetalleFactura;
        this.DFfacturaFK = DFfacturaFK;
        this.DFinsumoFK = DFinsumoFK;
        this.DFcantidadInsumo = DFcantidadInsumo;
        this.DFlote = DFlote;
        this.DFfechaVence = DFfechaVence;
        this.DFinvima = DFinvima;
        this.DFiva = DFiva;
        this.DFvalorUnitario = DFvalorUnitario;
        this.DFvalorTotal = DFvalorTotal;
    }

    public DetalleFactura() {
    }

}
