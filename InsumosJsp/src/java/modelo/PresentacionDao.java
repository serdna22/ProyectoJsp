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
public class PresentacionDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from presentacion";
        List<Presentacion> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Presentacion pre = new Presentacion();
                pre.setIdPresentacion(rs.getInt(1));
                pre.setPresentacionNombre(rs.getString(2));
                lista.add(pre);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Presentacion pre) {
        String sql = "insert into presentacion (presentacionNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pre.getPresentacionNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Presentacion listarId(int idPresentacion) {
        Presentacion pre = new Presentacion();
        String sql = "select * from presentacion where idPresentacion=" + idPresentacion;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pre.setIdPresentacion(rs.getInt(1));
                pre.setPresentacionNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return pre;
    }

    public int actualizar(Presentacion pre) {
        String sql = "update presentacion set presentacionNombre=? where idPresentacion=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pre.getPresentacionNombre());
            ps.setInt(2, pre.getIdPresentacion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idPresentacion) {
        String sql = "delete from presentacion where idPresentacion=" + idPresentacion;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
