/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Elemento {

    private int idElemento;
    private String elementoNombre;
    private int elementoPresentacion;
    private int elementoCategoria;
    private int elementoCantidad;
    private String elementoRuta;

    public Elemento() {
    }

    public Elemento(int idElemento, String elementoNombre, int elementoPresentacion, int elementoCategoria, int elementoCantidad, String elementoRuta) {
        this.idElemento = idElemento;
        this.elementoNombre = elementoNombre;
        this.elementoPresentacion = elementoPresentacion;
        this.elementoCategoria = elementoCategoria;
        this.elementoCantidad = elementoCantidad;
        this.elementoRuta = elementoRuta;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public String getElementoNombre() {
        return elementoNombre;
    }

    public void setElementoNombre(String elementoNombre) {
        this.elementoNombre = elementoNombre;
    }

    public int getElementoPresentacion() {
        return elementoPresentacion;
    }

    public void setElementoPresentacion(int elementoPresentacion) {
        this.elementoPresentacion = elementoPresentacion;
    }

    public int getElementoCategoria() {
        return elementoCategoria;
    }

    public void setElementoCategoria(int elementoCategoria) {
        this.elementoCategoria = elementoCategoria;
    }

    public int getElementoCantidad() {
        return elementoCantidad;
    }

    public void setElementoCantidad(int elementoCantidad) {
        this.elementoCantidad = elementoCantidad;
    }

    public String getElementoRuta() {
        return elementoRuta;
    }

    public void setElementoRuta(String elementoRuta) {
        this.elementoRuta = elementoRuta;
    }

}
