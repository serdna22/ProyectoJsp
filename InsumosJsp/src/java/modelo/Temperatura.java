/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Temperatura {

    private int idTemperatura;
    private String temperaturaNombre;

    public Temperatura() {
    }

    public Temperatura(int idTemperatura, String temperaturaNombre) {
        this.idTemperatura = idTemperatura;
        this.temperaturaNombre = temperaturaNombre;
    }

    public int getIdTemperatura() {
        return idTemperatura;
    }

    public void setIdTemperatura(int idTemperatura) {
        this.idTemperatura = idTemperatura;
    }

    public String getTemperaturaNombre() {
        return temperaturaNombre;
    }

    public void setTemperaturaNombre(String temperaturaNombre) {
        this.temperaturaNombre = temperaturaNombre;
    }

}
