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
public class PrincipioActivoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from principioactivo";
        List<PrincipioActivo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PrincipioActivo priac = new PrincipioActivo();
                priac.setIdPrincipioActivo(rs.getInt(1));
                priac.setPrincipioActivoNombre(rs.getString(2));
                lista.add(priac);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(PrincipioActivo priac) {
        String sql = "insert into principioactivo (principioActivoNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, priac.getPrincipioActivoNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public PrincipioActivo listarId(int idPrincipioActivo) {
        PrincipioActivo priac = new PrincipioActivo();
        String sql = "select * from principioactivo where idPrincipioActivo=" + idPrincipioActivo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                priac.setPrincipioActivoNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return priac;
    }

    public int actualizar(PrincipioActivo priac) {
        String sql = "update principioactivo set principioActivoNombre=? where idPrincipioActivo=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, priac.getPrincipioActivoNombre());
            ps.setInt(2, priac.getIdPrincipioActivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idPrincipioActivo) {
        String sql = "delete from principioactivo where idPrincipioActivo=" + idPrincipioActivo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
