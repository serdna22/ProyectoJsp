/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc_Estiven
 */
public class ProveedorDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

    // operaciones Crud
    public List listar() {
        String sql = "select * from proveedor";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setNitProveedor(rs.getString(1));
                prov.setProveedorNombre(rs.getString(2));
                prov.setProveedorDireccion(rs.getString(3));
                prov.setProveedorTelefono(rs.getString(4));
                prov.setProveedorCelular(rs.getString(5));
                prov.setProveedorFecha(rs.getString(6));
                prov.setProveedorCiudad(rs.getString(7));
                prov.setProveedorCorreo(rs.getString(8));
                lista.add(prov);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Proveedor prov) {
        String sql = "insert into proveedor (nitProveedor,proveedorNombre,proveedorDireccion,proveedorTelefono,proveedorCelular,proveedorFecha,proveedorCiudad,proveedorCorreo) values (?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNitProveedor());
            ps.setString(2, prov.getProveedorNombre());
            ps.setString(3, prov.getProveedorDireccion());
            ps.setString(4, prov.getProveedorTelefono());
            ps.setString(5, prov.getProveedorCelular());
            ps.setString(6, prov.getProveedorFecha());
            ps.setString(7, prov.getProveedorCiudad());
            ps.setString(8, prov.getProveedorCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Proveedor listarId(String nitProveedor) {
        Proveedor prov = new Proveedor();
        String sql = "select * from proveedor where nitProveedor='" + nitProveedor + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prov.setNitProveedor(rs.getString(1));
                prov.setProveedorNombre(rs.getString(2));
                prov.setProveedorDireccion(rs.getString(3));
                prov.setProveedorTelefono(rs.getString(4));
                prov.setProveedorCelular(rs.getString(5));
                prov.setProveedorFecha(rs.getString(6));
                prov.setProveedorCiudad(rs.getString(7));
                prov.setProveedorCorreo(rs.getString(8));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return prov;
    }

    public int actualizar(Proveedor prov, String id) {
        String sql = "update proveedor set nitProveedor=?, proveedorNombre=?, proveedorDireccion=?, proveedorTelefono=?, proveedorCelular=?, proveedorFecha=?, proveedorCiudad=?,\n"
                + "proveedorCorreo=? where nitProveedor='" + id + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNitProveedor());
            ps.setString(2, prov.getProveedorNombre());
            ps.setString(3, prov.getProveedorDireccion());
            ps.setString(4, prov.getProveedorTelefono());
            ps.setString(5, prov.getProveedorCelular());
            ps.setString(6, prov.getProveedorFecha());
            ps.setString(7, prov.getProveedorCiudad());
            ps.setString(8, prov.getProveedorCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(String nitProveedor) {
        String sql = "delete from proveedor where nitProveedor=" + nitProveedor;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
