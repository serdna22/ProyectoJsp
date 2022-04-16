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
public class RiesgoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from riesgo";
        List<Riesgo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Riesgo ries = new Riesgo();
                ries.setIdRiesgo(rs.getInt(1));
                ries.setRiesgoClasificacion(rs.getString(2));
                lista.add(ries);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Riesgo ries) {
        String sql = "insert into riesgo (riesgoClasificacion) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ries.getRiesgoClasificacion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Riesgo listarId(int idRiesgo) {
        Riesgo ries = new Riesgo();
        String sql = "select * from riesgo where idRiesgo=" + idRiesgo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ries.setRiesgoClasificacion(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return ries;
    }

    public int actualizar(Riesgo ries) {
        String sql = "update riesgo set riesgoClasificacion=? where idRiesgo=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ries.getRiesgoClasificacion());
            ps.setInt(2, ries.getIdRiesgo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idRiesgo) {
        String sql = "delete from riesgo where idRiesgo=" + idRiesgo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
}
