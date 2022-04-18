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
        String sql = "insert into proveedor (proveedorNombre,proveedorDireccion,proveedorTelefono,proveedorCelular,proveedorFecha,proveedorCiudad,proveedorCorreo) values (?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getProveedorNombre());
            ps.setString(2, prov.getProveedorDireccion());
            ps.setString(3, prov.getProveedorTelefono());
            ps.setString(4, prov.getProveedorCelular());
            ps.setString(5, prov.getProveedorFecha());
            ps.setString(6, prov.getProveedorCiudad());
            ps.setString(7, prov.getProveedorCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public int listarId(int nitProveedor) {
        Proveedor prov = new Proveedor();
        String sql = "select * from proveedor where nitProveedor=" + nitProveedor;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        return nitProveedor;
    }

    public int actualizar(Proveedor prov) {
        String sql = "update proveedor set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where nitProveedor=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getProveedorNombre());
            ps.setString(2, prov.getProveedorDireccion());
            ps.setString(3, prov.getProveedorTelefono());
            ps.setString(4, prov.getProveedorCelular());
            ps.setString(5, prov.getProveedorFecha());
            ps.setString(6, prov.getProveedorCiudad());
            ps.setString(7, prov.getProveedorCorreo());
            ps.setString(8, prov.getNitProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int nitProveedor) {
        String sql = "delete from proveedor where nitProveedor=" + nitProveedor;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public Proveedor listarId(String idProv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
