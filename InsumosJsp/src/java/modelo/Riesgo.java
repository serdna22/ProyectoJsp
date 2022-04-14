/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Riesgo {

    private int idRiesgo;
    private String riesgoClasificacion;

    public Riesgo() {
    }

    public Riesgo(int idRiesgo, String riesgoClasificacion) {
        this.idRiesgo = idRiesgo;
        this.riesgoClasificacion = riesgoClasificacion;
    }

    public int getIdRiesgo() {
        return idRiesgo;
    }

    public void setIdRiesgo(int idRiesgo) {
        this.idRiesgo = idRiesgo;
    }

    public String getRiesgoClasificacion() {
        return riesgoClasificacion;
    }

    public void setRiesgoClasificacion(String riesgoClasificacion) {
        this.riesgoClasificacion = riesgoClasificacion;
    }

}
