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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc_Estiven
 */
public class SalidaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

    // operaciones Crud
    public List listar() {
        String sql = "select * from salida";
        List<Salida> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Salida sali = new Salida();
                sali.setIdSalida(rs.getString(1));
                sali.setSalidaUsuarioFK(rs.getString(2));
                sali.setSalidaConsultorioFK(rs.getInt(3));
                sali.setSalidaProcedimientoFK(rs.getInt(4));
                sali.setSalidaSala(rs.getString(5));
                sali.setSalidaPersonaRecibio(rs.getString(6));
                sali.setSalidaFecha(rs.getDate(7));
                lista.add(sali);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Salida sali) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String fecha = dateFormat.format(date);
        String sql = "insert into salida (idSalida,salidaUsuarioFK,salidaConsultorioFK,salidaProcedimientoFK,"
                + "salidaSala,salidaPersonaRecibio,salidaFecha) values (?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sali.getIdSalida());
            ps.setString(2, sali.getSalidaUsuarioFK());
            ps.setInt(3, sali.getSalidaConsultorioFK());
            ps.setInt(4, sali.getSalidaProcedimientoFK());
            ps.setString(5, sali.getSalidaSala());
            ps.setString(6, sali.getSalidaPersonaRecibio());
            ps.setString(7, fecha);
            res = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public String listarId(String idSalida) {
        String repe="";
        String sql = "select idSalida from salida where idsalida='" + idSalida +"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
              repe=rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return repe;
    }

    public int actualizar(Salida sali) {
        String sql = "update idsalida set salidaUsuarioFK=?, salidaConsultorioFK=?, salidaProcedimientoFK=?, salidaSala=?, salidaPersonaRecibio=?, salidaFecha=? where idSalida=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sali.getSalidaUsuarioFK());
            ps.setInt(2, sali.getSalidaConsultorioFK());
            ps.setInt(3, sali.getSalidaProcedimientoFK());
            ps.setString(4, sali.getSalidaSala());
            ps.setString(5, sali.getSalidaPersonaRecibio());
            ps.setDate(6, (Date) sali.getSalidaFecha());
            ps.setString(7, sali.getIdSalida());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idsalida) {
        String sql = "delete from salida where idsalida=" + idsalida;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
