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

    private String codigoInsumo;
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
    private String insumoVence;
    private String insumoFichaTecnica;
    private String marcaNombre;
    private String riesgoClasificacion;
    private String presentacionNombre;
    private String temperaturaNombre;

    public Insumo() {
    }

    public Insumo(String codigoInsumo, String insumoNombre, int insumoMarcaFK, int insumoRiesgoFK, int insumoPresentacionFK, String insumoObservacion, int insumoExistencia, int insumoTemperaturaFK, String insumoRuta, String insumoInvima, String insumoLote, String insumoVence, String insumoFichaTecnica) {
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

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
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

    public String getInsumoVence() {
        return insumoVence;
    }

    public void setInsumoVence(String insumoVence) {
        this.insumoVence = insumoVence;
    }

    public String getInsumoFichaTecnica() {
        return insumoFichaTecnica;
    }

    public void setInsumoFichaTecnica(String insumoFichaTecnica) {
        this.insumoFichaTecnica = insumoFichaTecnica;
    }

    public String getMarcaNombre() {
        return marcaNombre;
    }

    public void setMarcaNombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }

    public String getRiesgoClasificacion() {
        return riesgoClasificacion;
    }

    public void setRiesgoClasificacion(String riesgoClasificacion) {
        this.riesgoClasificacion = riesgoClasificacion;
    }

    public String getPresentacionNombre() {
        return presentacionNombre;
    }

    public void setPresentacionNombre(String presentacionNombre) {
        this.presentacionNombre = presentacionNombre;
    }

    public String getTemperaturaNombre() {
        return temperaturaNombre;
    }

    public void setTemperaturaNombre(String temperaturaNombre) {
        this.temperaturaNombre = temperaturaNombre;
    }

}
