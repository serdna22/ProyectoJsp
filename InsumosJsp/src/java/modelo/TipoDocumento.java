/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class TipoDocumento {

    private int idTipoDoc;
    private String tipoDocNombre;

    public TipoDocumento() {
    }

    public TipoDocumento(int idTipoDoc, String tipoDocNombre) {
        this.idTipoDoc = idTipoDoc;
        this.tipoDocNombre = tipoDocNombre;
    }

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getTipoDocNombre() {
        return tipoDocNombre;
    }

    public void setTipoDocNombre(String tipoDocNombre) {
        this.tipoDocNombre = tipoDocNombre;
    }

}
