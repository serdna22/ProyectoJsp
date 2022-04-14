/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class PrincipioActivo {

    private int idPrincipioActivo;
    private String principioActivoNombre;

    public PrincipioActivo() {
    }

    public PrincipioActivo(int idPrincipioActivo, String principioActivoNombre) {
        this.idPrincipioActivo = idPrincipioActivo;
        this.principioActivoNombre = principioActivoNombre;
    }

    public int getIdPrincipioActivo() {
        return idPrincipioActivo;
    }

    public void setIdPrincipioActivo(int idPrincipioActivo) {
        this.idPrincipioActivo = idPrincipioActivo;
    }

    public String getPrincipioActivoNombre() {
        return principioActivoNombre;
    }

    public void setPrincipioActivoNombre(String principioActivoNombre) {
        this.principioActivoNombre = principioActivoNombre;
    }

}
