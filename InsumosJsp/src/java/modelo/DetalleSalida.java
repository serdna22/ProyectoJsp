/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class DetalleSalida {

    private int idDetalleSalida;
    private String DSidSalidaFK;
    private String DScodigoInsumoFK;
    private int DScantidad;
    private String DSinvima;
    private String DSlote;
    private String DSfechaVence;
    private String nombreInsumo;
    
    public DetalleSalida() {
    }

    public DetalleSalida(int idDetalleSalida, String DSidSalidaFK, String DScodigoInsumoFK, int DScantidad, String DSinvima, String DSlote, String DSfechaVence) {
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

    public String getDSidSalidaFK() {
        return DSidSalidaFK;
    }

    public void setDSidSalidaFK(String DSidSalidaFK) {
        this.DSidSalidaFK = DSidSalidaFK;
    }

    public String getDScodigoInsumoFK() {
        return DScodigoInsumoFK;
    }

    public void setDScodigoInsumoFK(String DScodigoInsumoFK) {
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

    public String getDSfechaVence() {
        return DSfechaVence;
    }

    public void setDSfechaVence(String DSfechaVence) {
        this.DSfechaVence = DSfechaVence;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

}
