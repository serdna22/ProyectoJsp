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
                sali.setIdSalida(rs.getInt(1));
                sali.setSalidaUsuarioFK(rs.getString(2));
                sali.setSalidaConsultorioFK(rs.getInt(3));
                sali.setSalidaProcedimiento(rs.getInt(4));
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
        String sql = "insert into salida (salidaUsuarioFK,salidaConsultorioFK,salidaProcedimiento,salidaSala,salidaPersonaRecibio,salidaFecha) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sali.getSalidaUsuarioFK());
            ps.setInt(2, sali.getSalidaConsultorioFK());
            ps.setInt(3, sali.getSalidaProcedimiento());
            ps.setString(4, sali.getSalidaSala());
            ps.setString(5, sali.getSalidaPersonaRecibio());
            ps.setDate(6, (Date) sali.getSalidaFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Salida listarId(int idSalida) {
        Salida sali = new Salida();
        String sql = "select * from empleado where idSalida=" + idSalida;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sali.setSalidaUsuarioFK(rs.getString(2));
                sali.setSalidaConsultorioFK(rs.getInt(3));
                sali.setSalidaProcedimiento(rs.getInt(4));
                sali.setSalidaSala(rs.getString(5));
                sali.setSalidaPersonaRecibio(rs.getString(6));
                sali.setSalidaFecha(rs.getDate(7));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return sali;
    }

    public int actualizar(Salida sali) {
        String sql = "update idsalida set salidaUsuarioFK=?, salidaConsultorioFK=?, salidaProcedimiento=?, salidaSala=?, salidaPersonaRecibio=?, salidaFecha=? where idSalida=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sali.getSalidaUsuarioFK());
            ps.setInt(2, sali.getSalidaConsultorioFK());
            ps.setInt(3, sali.getSalidaProcedimiento());
            ps.setString(4, sali.getSalidaSala());
            ps.setString(5, sali.getSalidaPersonaRecibio());
            ps.setDate(6, (Date) sali.getSalidaFecha());
            ps.setInt(7, sali.getIdSalida());
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
