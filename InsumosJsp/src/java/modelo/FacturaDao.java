/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
                fac.setFacturaIvaTotal(rs.getDouble(3));
                fac.setFacturaDescuento(rs.getDouble(4));
                fac.setFacturaFecha(rs.getString(5));
                fac.setFacturaUsuario(rs.getString(6));
                lista.add(fac);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Factura fac) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String fecha = dateFormat.format(date);
        String sql = "insert into factura (idFactura,facturaProveedorFK,facturaIvaTotal,facturaDescuento,facturaFecha,facturaUsuario) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fac.getIdFactura());
            ps.setString(2, fac.getFacturaProveedorFK());
            ps.setDouble(3, 30);
            ps.setDouble(4, fac.getFacturaDescuento());
            ps.setString(5, fecha);
            ps.setString(6, fac.getDocumentoUsuario());
            res = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public String listarId(String idFactura) {
        String repet = "";
        String sql = "select idFactura from factura where idFactura='" + idFactura + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                repet = rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return repet;
    }

    public Factura listarTabla(String idFactura) {
        Factura fac = new Factura();
        String sql = "select * from factura where idFactura='" + idFactura + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                fac.setIdFactura(rs.getString(1));
                fac.setFacturaProveedorFK(rs.getString(2));
                fac.setFacturaIvaTotal(rs.getDouble(3));
                fac.setFacturaDescuento(rs.getDouble(4));
                fac.setFacturaFecha(rs.getString(5));
                fac.setFacturaUsuario(rs.getString(6));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return fac;
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
