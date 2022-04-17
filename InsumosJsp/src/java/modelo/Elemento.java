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

    private String idElemento;
    private String elementoNombre;
    private int elementoPresentacion;
    private int elementoCategoria;
    private int elementoCantidad;
    private String elementoRuta;
    private String presentacionNombre;
    private String categoriaNombre;

    public Elemento() {
    }

    public Elemento(String idElemento, String elementoNombre, int elementoPresentacion, int elementoCategoria, int elementoCantidad, String elementoRuta) {
        this.idElemento = idElemento;
        this.elementoNombre = elementoNombre;
        this.elementoPresentacion = elementoPresentacion;
        this.elementoCategoria = elementoCategoria;
        this.elementoCantidad = elementoCantidad;
        this.elementoRuta = elementoRuta;
    }

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
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

    public String getPresentacionNombre() {
        return presentacionNombre;
    }

    public void setPresentacionNombre(String presentacionNombre) {
        this.presentacionNombre = presentacionNombre;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

}
