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
public class DetalleSalidaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    // operaciones Crud

    public List listar() {
        String sql = "select * from detallesalida";
        List<DetalleSalida> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleSalida DeSa = new DetalleSalida();
                DeSa.setDSidSalidaFK(rs.getString(2));
                DeSa.setDScodigoInsumoFK(rs.getString(3));
                DeSa.setDScantidad(rs.getInt(4));
                DeSa.setDSinvima(rs.getString(5));
                DeSa.setDSlote(rs.getString(6));
                DeSa.setDSfechaVence(rs.getString(7));
                lista.add(DeSa);

            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(DetalleSalida DeSa) {
        String sql = "insert into detallesalida (DSidSalidaFK,DScodigoInsumoFK,DScantidad,DSinvima,"
                + "DSlote,DSfechaVence) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, DeSa.getDSidSalidaFK());
            ps.setString(2, DeSa.getDScodigoInsumoFK());
            ps.setInt(3, DeSa.getDScantidad());
            ps.setString(4, DeSa.getDSinvima());
            ps.setString(5, DeSa.getDSlote());
            ps.setString(6,DeSa.getDSfechaVence());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public DetalleSalida listarId(int idDetalleSalida) {
        DetalleSalida DeSa = new DetalleSalida();
        String sql = "select * from detallesalida where idDetalleSalida=" + idDetalleSalida;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DeSa.setDSidSalidaFK(rs.getString(2));
                DeSa.setDScodigoInsumoFK(rs.getString(3));
                DeSa.setDScantidad(rs.getInt(4));
                DeSa.setDSinvima(rs.getString(5));
                DeSa.setDSlote(rs.getString(6));
                DeSa.setDSfechaVence(rs.getString(7));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return DeSa;
    }

    public int actualizar(DetalleSalida DeSa) {
        String sql = "update detallesalida set DSidSalidaFK=?, DScodigoInsumoFK=?, DScantidad=?, DSinvima=?, DSlote=?, DSfechaVence=? where idDetalleSalida=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, DeSa.getDSidSalidaFK());
            ps.setString(2, DeSa.getDScodigoInsumoFK());
            ps.setInt(3, DeSa.getDScantidad());
            ps.setString(4, DeSa.getDSinvima());
            ps.setString(5, DeSa.getDSlote());
            ps.setString(6, DeSa.getDSfechaVence());
            ps.setInt(7, DeSa.getIdDetalleSalida());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idDetalleSalida) {
        String sql = "delete from detallesalida where idDetalleSalida=" + idDetalleSalida;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
