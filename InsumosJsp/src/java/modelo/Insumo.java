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
public class Insumo {

    private int codigoInsumo;
    private String insumoNombre;
    private int insumoMarcaFK;
    private int insumoRiesgoFK;
    private int insumoPresentacionFK;
    private String insumoObservacion;
    private int insumoExistencia;
    private int insumoTemperaturaFK;
    private String insumoRuta;
    private String insumoInvima;
    private String insumoLote;
    private Date insumoVence;
    private String insumoFichaTecnica;

    public Insumo() {
    }

    public Insumo(int codigoInsumo, String insumoNombre, int insumoMarcaFK, int insumoRiesgoFK, int insumoPresentacionFK, String insumoObservacion, int insumoExistencia, int insumoTemperaturaFK, String insumoRuta, String insumoInvima, String insumoLote, Date insumoVence, String insumoFichaTecnica) {
        this.codigoInsumo = codigoInsumo;
        this.insumoNombre = insumoNombre;
        this.insumoMarcaFK = insumoMarcaFK;
        this.insumoRiesgoFK = insumoRiesgoFK;
        this.insumoPresentacionFK = insumoPresentacionFK;
        this.insumoObservacion = insumoObservacion;
        this.insumoExistencia = insumoExistencia;
        this.insumoTemperaturaFK = insumoTemperaturaFK;
        this.insumoRuta = insumoRuta;
        this.insumoInvima = insumoInvima;
        this.insumoLote = insumoLote;
        this.insumoVence = insumoVence;
        this.insumoFichaTecnica = insumoFichaTecnica;
    }

    public int getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(int codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getInsumoNombre() {
        return insumoNombre;
    }

    public void setInsumoNombre(String insumoNombre) {
        this.insumoNombre = insumoNombre;
    }

    public int getInsumoMarcaFK() {
        return insumoMarcaFK;
    }

    public void setInsumoMarcaFK(int insumoMarcaFK) {
        this.insumoMarcaFK = insumoMarcaFK;
    }

    public int getInsumoRiesgoFK() {
        return insumoRiesgoFK;
    }

    public void setInsumoRiesgoFK(int insumoRiesgoFK) {
        this.insumoRiesgoFK = insumoRiesgoFK;
    }

    public int getInsumoPresentacionFK() {
        return insumoPresentacionFK;
    }

    public void setInsumoPresentacionFK(int insumoPresentacionFK) {
        this.insumoPresentacionFK = insumoPresentacionFK;
    }

    public String getInsumoObservacion() {
        return insumoObservacion;
    }

    public void setInsumoObservacion(String insumoObservacion) {
        this.insumoObservacion = insumoObservacion;
    }

    public int getInsumoExistencia() {
        return insumoExistencia;
    }

    public void setInsumoExistencia(int insumoExistencia) {
        this.insumoExistencia = insumoExistencia;
    }

    public int getInsumoTemperaturaFK() {
        return insumoTemperaturaFK;
    }

    public void setInsumoTemperaturaFK(int insumoTemperaturaFK) {
        this.insumoTemperaturaFK = insumoTemperaturaFK;
    }

    public String getInsumoRuta() {
        return insumoRuta;
    }

    public void setInsumoRuta(String insumoRuta) {
        this.insumoRuta = insumoRuta;
    }

    public String getInsumoInvima() {
        return insumoInvima;
    }

    public void setInsumoInvima(String insumoInvima) {
        this.insumoInvima = insumoInvima;
    }

    public String getInsumoLote() {
        return insumoLote;
    }

    public void setInsumoLote(String insumoLote) {
        this.insumoLote = insumoLote;
    }

    public Date getInsumoVence() {
        return insumoVence;
    }

    public void setInsumoVence(Date insumoVence) {
        this.insumoVence = insumoVence;
    }

    public String getInsumoFichaTecnica() {
        return insumoFichaTecnica;
    }

    public void setInsumoFichaTecnica(String insumoFichaTecnica) {
        this.insumoFichaTecnica = insumoFichaTecnica;
    }

}
