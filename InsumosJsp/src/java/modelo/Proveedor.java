/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Pc_Estiven
 */
public class Proveedor {

    private String nitProveedor;
    private String proveedorNombre;
    private String proveedorDireccion;
    private String proveedorTelefono;
    private String proveedorCelular;
    private String proveedorFecha;
    private String proveedorCiudad;
    private String proveedorCorreo;

    public Proveedor() {
    }

    public Proveedor(String nitProveedor, String proveedorNombre, String proveedorDireccion, String proveedorTelefono, String proveedorCelular, String proveedorFecha, String proveedorCiudad, String proveedorCorreo) {
        this.nitProveedor = nitProveedor;
        this.proveedorNombre = proveedorNombre;
        this.proveedorDireccion = proveedorDireccion;
        this.proveedorTelefono = proveedorTelefono;
        this.proveedorCelular = proveedorCelular;
        this.proveedorFecha = proveedorFecha;
        this.proveedorCiudad = proveedorCiudad; 
        this.proveedorCorreo = proveedorCorreo;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    public String getProveedorDireccion() {
        return proveedorDireccion;
    }

    public void setProveedorDireccion(String proveedorDireccion) {
        this.proveedorDireccion = proveedorDireccion;
    }

    public String getProveedorTelefono() {
        return proveedorTelefono;
    }

    public void setProveedorTelefono(String proveedorTelefono) {
        this.proveedorTelefono = proveedorTelefono;
    }

    public String getProveedorCelular() {
        return proveedorCelular;
    }

    public void setProveedorCelular(String proveedorCelular) {
        this.proveedorCelular = proveedorCelular;
    }

    public String getProveedorFecha() {
        return proveedorFecha;
    }

    public void setProveedorFecha(String proveedorFecha) {
        this.proveedorFecha = proveedorFecha;
    }

    public String getProveedorCiudad() {
        return proveedorCiudad;
    }

    public void setProveedorCiudad(String proveedorCiudad) {
        this.proveedorCiudad = proveedorCiudad;
    }

    public String getProveedorCorreo() {
        return proveedorCorreo;
    }

    public void setProveedorCorreo(String proveedorCorreo) {
        this.proveedorCorreo = proveedorCorreo;
    }

    
}
