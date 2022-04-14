/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Concentracion {

    private int idConcentracion;
    private String concentracionNombre;

    public Concentracion() {
    }

    public Concentracion(int idConcentracion, String concentracionNombre) {
        this.idConcentracion = idConcentracion;
        this.concentracionNombre = concentracionNombre;
    }

    public int getIdConcentracion() {
        return idConcentracion;
    }

    public void setIdConcentracion(int idConcentracion) {
        this.idConcentracion = idConcentracion;
    }

    public String getConcentracionNombre() {
        return concentracionNombre;
    }

    public void setConcentracionNombre(String concentracionNombre) {
        this.concentracionNombre = concentracionNombre;
    }

}
