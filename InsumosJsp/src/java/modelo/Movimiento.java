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
public class Movimiento {

    private int idMovimiento;
    private Date movimientoFecha;
    //revisar Time para movimientoHora
    private Date movimientoHora;
    private String movimientoTipo;
    private String movimientoEntidad;
    private String movimientoUsuario;
    private String movimientoDato;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, Date movimientoFecha, Date movimientoHora, String movimientoTipo, String movimientoEntidad, String movimientoUsuario, String movimientoDato) {
        this.idMovimiento = idMovimiento;
        this.movimientoFecha = movimientoFecha;
        this.movimientoHora = movimientoHora;
        this.movimientoTipo = movimientoTipo;
        this.movimientoEntidad = movimientoEntidad;
        this.movimientoUsuario = movimientoUsuario;
        this.movimientoDato = movimientoDato;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getMovimientoFecha() {
        return movimientoFecha;
    }

    public void setMovimientoFecha(Date movimientoFecha) {
        this.movimientoFecha = movimientoFecha;
    }

    public Date getMovimientoHora() {
        return movimientoHora;
    }

    public void setMovimientoHora(Date movimientoHora) {
        this.movimientoHora = movimientoHora;
    }

    public String getMovimientoTipo() {
        return movimientoTipo;
    }

    public void setMovimientoTipo(String movimientoTipo) {
        this.movimientoTipo = movimientoTipo;
    }

    public String getMovimientoEntidad() {
        return movimientoEntidad;
    }

    public void setMovimientoEntidad(String movimientoEntidad) {
        this.movimientoEntidad = movimientoEntidad;
    }

    public String getMovimientoUsuario() {
        return movimientoUsuario;
    }

    public void setMovimientoUsuario(String movimientoUsuario) {
        this.movimientoUsuario = movimientoUsuario;
    }

    public String getMovimientoDato() {
        return movimientoDato;
    }

    public void setMovimientoDato(String movimientoDato) {
        this.movimientoDato = movimientoDato;
    }

}
