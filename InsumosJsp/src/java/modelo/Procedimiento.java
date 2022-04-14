/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Procedimiento {

    private int idProcedimiento;
    private String procedimientoNombre;

    public Procedimiento() {
    }

    public Procedimiento(int idProcedimiento, String procedimientoNombre) {
        this.idProcedimiento = idProcedimiento;
        this.procedimientoNombre = procedimientoNombre;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getProcedimientoNombre() {
        return procedimientoNombre;
    }

    public void setProcedimientoNombre(String procedimientoNombre) {
        this.procedimientoNombre = procedimientoNombre;
    }

}
