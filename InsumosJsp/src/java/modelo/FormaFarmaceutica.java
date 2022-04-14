/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class FormaFarmaceutica {

    private int idFormaFarmaceutica;
    private String formaFarNombre;

    public FormaFarmaceutica() {
    }

    public FormaFarmaceutica(int idFormaFarmaceutica, String formaFarNombre) {
        this.idFormaFarmaceutica = idFormaFarmaceutica;
        this.formaFarNombre = formaFarNombre;
    }

    public int getIdFormaFarmaceutica() {
        return idFormaFarmaceutica;
    }

    public void setIdFormaFarmaceutica(int idFormaFarmaceutica) {
        this.idFormaFarmaceutica = idFormaFarmaceutica;
    }

    public String getFormaFarNombre() {
        return formaFarNombre;
    }

    public void setFormaFarNombre(String formaFarNombre) {
        this.formaFarNombre = formaFarNombre;
    }

}
