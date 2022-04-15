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
public class FormaFarmaceuticaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from formafarmaceutica";
        List<FormaFarmaceutica> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                FormaFarmaceutica forfar = new FormaFarmaceutica();
                forfar.setIdFormaFarmaceutica(rs.getInt(1));
                forfar.setFormaFarNombre(rs.getString(2));
                lista.add(forfar);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(FormaFarmaceutica forfar) {
        String sql = "insert into formafarmaceutica (formaFarNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, forfar.getFormaFarNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public FormaFarmaceutica listarId(int idFormaFarmaceutica) {
        FormaFarmaceutica forfar = new FormaFarmaceutica();
        String sql = "select * from formafarmaceutica where idFormaFarmaceutica=" + idFormaFarmaceutica;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                forfar.setFormaFarNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return forfar;
    }

    public int actualizar(FormaFarmaceutica forfar) {
        String sql = "update formafarmaceutica set formaFarNombre=? where idFormaFarmaceutica=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, forfar.getFormaFarNombre());
            ps.setInt(2, forfar.getIdFormaFarmaceutica());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idFormaFarmaceutica) {
        String sql = "delete from formafarmaceutica where idFormaFarmaceutica=" + idFormaFarmaceutica;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
