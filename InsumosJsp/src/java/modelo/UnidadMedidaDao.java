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
public class UnidadMedidaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from unidadmedida";
        List<UnidadMedida> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UnidadMedida Ume = new UnidadMedida();
                Ume.setIdUnidadMedida(rs.getInt(1));
                Ume.setUMmedida(rs.getString(2));
                lista.add(Ume);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(UnidadMedida ume) {
        String sql = "insert into unidadmedida (UMmedida) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ume.getUMmedida());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public UnidadMedida listarId(int idUnidadMedida) {
        UnidadMedida ume = new UnidadMedida();
        String sql = "select * from unidadmedida where idUnidadMedida=" + idUnidadMedida;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ume.setUMmedida(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return ume;
    }

    public int actualizar(UnidadMedida ume) {
        String sql = "update unidadmedida set UMmedida=? where idUnidadMedida=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ume.getUMmedida());
            ps.setInt(2, ume.getIdUnidadMedida());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idUnidadMedida) {
        String sql = "delete from unidadmedida where idUnidadMedida=" + idUnidadMedida;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
