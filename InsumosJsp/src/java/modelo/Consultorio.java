/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Consultorio {

    private int idConsultorio;
    private String consultorioNombre;

    public Consultorio() {
    }

    public Consultorio(int idConsultorio, String consultorioNombre) {
        this.idConsultorio = idConsultorio;
        this.consultorioNombre = consultorioNombre;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getConsultorioNombre() {
        return consultorioNombre;
    }

    public void setConsultorioNombre(String consultorioNombre) {
        this.consultorioNombre = consultorioNombre;
    }

}
