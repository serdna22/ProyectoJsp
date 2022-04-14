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
public class DetalleSalida {

    private int idDetalleSalida;
    private int DSidSalidaFK;
    private int DScodigoInsumoFK;
    private int DScantidad;
    private String DSinvima;
    private String DSlote;
    private Date DSfechaVence;

    public DetalleSalida() {
    }

    public DetalleSalida(int idDetalleSalida, int DSidSalidaFK, int DScodigoInsumoFK, int DScantidad, String DSinvima, String DSlote, Date DSfechaVence) {
        this.idDetalleSalida = idDetalleSalida;
        this.DSidSalidaFK = DSidSalidaFK;
        this.DScodigoInsumoFK = DScodigoInsumoFK;
        this.DScantidad = DScantidad;
        this.DSinvima = DSinvima;
        this.DSlote = DSlote;
        this.DSfechaVence = DSfechaVence;
    }

    public int getIdDetalleSalida() {
        return idDetalleSalida;
    }

    public void setIdDetalleSalida(int idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }

    public int getDSidSalidaFK() {
        return DSidSalidaFK;
    }

    public void setDSidSalidaFK(int DSidSalidaFK) {
        this.DSidSalidaFK = DSidSalidaFK;
    }

    public int getDScodigoInsumoFK() {
        return DScodigoInsumoFK;
    }

    public void setDScodigoInsumoFK(int DScodigoInsumoFK) {
        this.DScodigoInsumoFK = DScodigoInsumoFK;
    }

    public int getDScantidad() {
        return DScantidad;
    }

    public void setDScantidad(int DScantidad) {
        this.DScantidad = DScantidad;
    }

    public String getDSinvima() {
        return DSinvima;
    }

    public void setDSinvima(String DSinvima) {
        this.DSinvima = DSinvima;
    }

    public String getDSlote() {
        return DSlote;
    }

    public void setDSlote(String DSlote) {
        this.DSlote = DSlote;
    }

    public Date getDSfechaVence() {
        return DSfechaVence;
    }

    public void setDSfechaVence(Date DSfechaVence) {
        this.DSfechaVence = DSfechaVence;
    }

}
