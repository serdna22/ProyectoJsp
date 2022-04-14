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

    private int idSalida;
    private String salidaUsuarioFK;
    private int salidaConsultorioFK;
    private int salidaProcedimiento;
    private String salidaSala;
    private String salidaPersonaRecibio;
    private Date salidaFecha;

    public Salida() {
    }

    public Salida(int idSalida, String salidaUsuarioFK, int salidaConsultorioFK, int salidaProcedimiento, String salidaSala, String salidaPersonaRecibio, Date salidaFecha) {
        this.idSalida = idSalida;
        this.salidaUsuarioFK = salidaUsuarioFK;
        this.salidaConsultorioFK = salidaConsultorioFK;
        this.salidaProcedimiento = salidaProcedimiento;
        this.salidaSala = salidaSala;
        this.salidaPersonaRecibio = salidaPersonaRecibio;
        this.salidaFecha = salidaFecha;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
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

    public int getSalidaProcedimiento() {
        return salidaProcedimiento;
    }

    public void setSalidaProcedimiento(int salidaProcedimiento) {
        this.salidaProcedimiento = salidaProcedimiento;
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

}
