/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Presentacion {

    private int idPresentacion;
    private String presentacionNombre;

    public Presentacion() {
    }

    public Presentacion(int idPresentacion, String presentacionNombre) {
        this.idPresentacion = idPresentacion;
        this.presentacionNombre = presentacionNombre;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getPresentacionNombre() {
        return presentacionNombre;
    }

    public void setPresentacionNombre(String presentacionNombre) {
        this.presentacionNombre = presentacionNombre;
    }

}
