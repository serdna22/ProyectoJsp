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
public class FacturaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

    // operaciones Crud
    public List listar() {
        String sql = "select * from factura";
        List<Factura> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura fac = new Factura();
                fac.setIdFactura(rs.getString(1));
                fac.setFacturaProveedorFK(rs.getString(2));
                fac.setFacturaArchivo(rs.getString(3));
                fac.setFacturaIvaTotal(rs.getDouble(4));
                fac.setFacturaDescuento(rs.getDouble(5));
                fac.setFacturaFecha(rs.getString(6));
                fac.setFacturaUsuario(rs.getString(7));
                lista.add(fac);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Factura fac) {
        String sql = "insert into factura (facturaProveedorFK,facturaArchivo,facturaIvaTotal,facturaDescuento,facturaFecha,facturaUsuario) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fac.getFacturaProveedorFK());
            ps.setString(2, fac.getFacturaArchivo());
            ps.setDouble(3, fac.getFacturaIvaTotal());
            ps.setDouble(4, fac.getFacturaDescuento());
            ps.setString(5, fac.getFacturaFecha());
            ps.setString(6, fac.getFacturaUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Factura listarId(int idFactura) {
        Factura fac = new Factura();
        String sql = "select * from factura where idFactura=" + idFactura;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fac.setFacturaProveedorFK(rs.getString(2));
                fac.setFacturaArchivo(rs.getString(3));
                fac.setFacturaIvaTotal(rs.getDouble(4));
                fac.setFacturaDescuento(rs.getDouble(5));
                fac.setFacturaFecha(rs.getString(6));
                fac.setFacturaUsuario(rs.getString(7));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return fac;
    }

    public int actualizar(Factura fac) {
        String sql = "update factura set facturaProveedorFK=?, facturaArchivo=?, facturaIvaTotal=?, facturaDescuento=?, facturaFecha=?, facturaUsuario=?, where idFactura=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fac.getFacturaProveedorFK());
            ps.setString(2, fac.getFacturaArchivo());
            ps.setDouble(3, fac.getFacturaIvaTotal());
            ps.setDouble(4, fac.getFacturaDescuento());
            ps.setString(5, fac.getFacturaFecha());
            ps.setString(6, fac.getFacturaUsuario());
            ps.setString(7, fac.getIdFactura());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idFactura) {
        String sql = "delete from factura where IdEmpleado=" + idFactura;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
