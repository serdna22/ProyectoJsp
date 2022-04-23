/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc_Estiven
 */
public class DetalleFacturaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    List<DetalleFactura> lista = new ArrayList<>();
    // operaciones Crud
    public List listar() {
        String sql = "select * from detallefactura";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleFactura DeFac = new DetalleFactura();
                DeFac.setIdDetalleFactura(rs.getInt(1));
                DeFac.setDFfacturaFK(rs.getString(2));
                DeFac.setDFinsumoFK(rs.getString(3));
                DeFac.setDFcantidadInsumo(rs.getInt(4));
                DeFac.setDFlote(rs.getString(5));
                DeFac.setDFfechaVence(rs.getString(6));
                DeFac.setDFinvima(rs.getString(7));
                DeFac.setDFiva(rs.getFloat(8));
                DeFac.setDFvalorUnitario(rs.getDouble(9));
                DeFac.setDFvalorTotal(rs.getDouble(10));
                lista.add(DeFac);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(DetalleFactura DeFac) {
        String sql = "insert into detallefactura (DFfacturaFK,DFinsumoFK,DFcantidadInsumo,DFlote,"
                + "DFfechaVence,DFinvima,DFiva,DFvalorUnitario,DFvalorTotal) values (?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, DeFac.getDFfacturaFK());
            ps.setString(2, DeFac.getDFinsumoFK());
            ps.setInt(3, DeFac.getDFcantidadInsumo());
            ps.setString(4, DeFac.getDFlote());
            ps.setString(5, DeFac.getDFfechaVence());
            ps.setString(6, DeFac.getDFinvima());
            ps.setFloat(7, DeFac.getDFiva());
            ps.setDouble(8, DeFac.getDFvalorUnitario());
            ps.setDouble(9, DeFac.getDFvalorTotal());
            res = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public List listarId(String id) {
        String sql = "select * from detallefactura where DFfacturaFK='" + id+"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleFactura DeFac = new DetalleFactura();
                DeFac.setDFfacturaFK(rs.getString(2));
                DeFac.setDFinsumoFK(rs.getString(3));
                DeFac.setDFcantidadInsumo(rs.getInt(4));
                DeFac.setDFlote(rs.getString(5));
                DeFac.setDFfechaVence(rs.getString(6));
                DeFac.setDFinvima(rs.getString(7));
                DeFac.setDFiva(rs.getFloat(8));
                DeFac.setDFvalorUnitario(rs.getDouble(9));
                DeFac.setDFvalorTotal(rs.getDouble(10));
                lista.add(DeFac);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int actualizar(DetalleFactura Defac) {
        String sql = "update detallefactura set DFfacturaFK=?, DFinsumoFK=?, DFcantidadInsumo=?, DFlote=?, DFfechaVence=?, DFinvima=?, DFiva=?, DFvalorUnitario=?, DFvalorTotal=? where idDetalleFactura=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Defac.getDFfacturaFK());
            ps.setString(2, Defac.getDFinsumoFK());
            ps.setInt(3, Defac.getDFcantidadInsumo());
            ps.setString(4, Defac.getDFlote());
            ps.setString(5,Defac.getDFfechaVence());
            ps.setString(6, Defac.getDFinvima());
            ps.setFloat(7, Defac.getDFiva());
            ps.setDouble(8, Defac.getDFvalorUnitario());
            ps.setDouble(9, Defac.getDFvalorTotal());
            ps.setInt(10, Defac.getIdDetalleFactura());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idDetalleFactura) {
        String sql = "delete from detallefactura where idDetalleFactura=" + idDetalleFactura;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
