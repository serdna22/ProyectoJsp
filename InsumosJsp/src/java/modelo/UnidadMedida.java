/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class UnidadMedida {

    private int idUnidadMedida;
    private String UMmedida;

    public UnidadMedida() {
    }

    public UnidadMedida(int idUnidadMedida, String UMmedida) {
        this.idUnidadMedida = idUnidadMedida;
        this.UMmedida = UMmedida;
    }

    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getUMmedida() {
        return UMmedida;
    }

    public void setUMmedida(String UMmedida) {
        this.UMmedida = UMmedida;
    }

}
