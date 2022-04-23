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
public class Salida {

    private String idSalida;
    private String salidaUsuarioFK;
    private int salidaConsultorioFK;
    private int salidaProcedimientoFK;
    private String salidaSala;
    private String salidaPersonaRecibio;
    private Date salidaFecha;
    private String nombreUsuario;
    private String nombreConsultorio;
    private String nombreProcedimiento;

    public Salida() {
    }

    public Salida(String idSalida, String salidaUsuarioFK, int salidaConsultorioFK, int salidaProcedimientoFK, String salidaSala, String salidaPersonaRecibio, Date salidaFecha) {
        this.idSalida = idSalida;
        this.salidaUsuarioFK = salidaUsuarioFK;
        this.salidaConsultorioFK = salidaConsultorioFK;
        this.salidaProcedimientoFK = salidaProcedimientoFK;
        this.salidaSala = salidaSala;
        this.salidaPersonaRecibio = salidaPersonaRecibio;
        this.salidaFecha = salidaFecha;
    }

    public String getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public String getSalidaUsuarioFK() {
        return salidaUsuarioFK;
    }

    public void setSalidaUsuarioFK(String salidaUsuarioFK) {
        this.salidaUsuarioFK = salidaUsuarioFK;
    }

    public int getSalidaConsultorioFK() {
        return salidaConsultorioFK;
    }

    public void setSalidaConsultorioFK(int salidaConsultorioFK) {
        this.salidaConsultorioFK = salidaConsultorioFK;
    }

    public int getSalidaProcedimientoFK() {
        return salidaProcedimientoFK;
    }

    public void setSalidaProcedimientoFK(int salidaProcedimientoFK) {
        this.salidaProcedimientoFK = salidaProcedimientoFK;
    }

    public String getSalidaSala() {
        return salidaSala;
    }

    public void setSalidaSala(String salidaSala) {
        this.salidaSala = salidaSala;
    }

    public String getSalidaPersonaRecibio() {
        return salidaPersonaRecibio;
    }

    public void setSalidaPersonaRecibio(String salidaPersonaRecibio) {
        this.salidaPersonaRecibio = salidaPersonaRecibio;
    }

    public Date getSalidaFecha() {
        return salidaFecha;
    }

    public void setSalidaFecha(Date salidaFecha) {
        this.salidaFecha = salidaFecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreConsultorio() {
        return nombreConsultorio;
    }

    public void setNombreConsultorio(String nombreConsultorio) {
        this.nombreConsultorio = nombreConsultorio;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

}
