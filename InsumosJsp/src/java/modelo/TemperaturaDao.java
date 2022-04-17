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
public class TemperaturaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from temperatura";
        List<Temperatura> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Temperatura tem = new Temperatura();
                tem.setIdTemperatura(rs.getInt(1));
                tem.setTemperaturaNombre(rs.getString(2));
                lista.add(tem);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Temperatura tem) {
        String sql = "insert into temperatura (temperaturaNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tem.getTemperaturaNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Temperatura listarId(int idTemperatura) {
        Temperatura tem = new Temperatura();
        String sql = "select * from temperatura where idTemperatura=" + idTemperatura;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tem.setIdTemperatura(rs.getInt(1));
                tem.setTemperaturaNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return tem;
    }

    public int actualizar(Temperatura tem) {
        String sql = "update temperatura set temperaturaNombre=? where idTemperatura=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tem.getTemperaturaNombre());
            ps.setInt(2, tem.getIdTemperatura());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idTemperatura) {
        String sql = "delete from temperatura where idTemperatura=" + idTemperatura;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
