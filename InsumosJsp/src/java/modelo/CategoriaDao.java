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
public class CategoriaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    // operaciones Crud

    public List listar() {
        String sql = "select * from categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria ca = new Categoria();
                ca.setIdCategoria(rs.getInt(1));
                ca.setCategoriaNombre(rs.getString(2));
                lista.add(ca);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Categoria ca) {
        String sql = "insert into categoria (categoriaNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            // ps.setInt(1, ca.getIdCategoria());
            ps.setString(1, ca.getCategoriaNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Categoria listarId(int idCategoria) {
        Categoria ca = new Categoria();
        String sql = "select * from categoria where idCategoria=" + idCategoria;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ca.setIdCategoria(rs.getInt(1));
                ca.setCategoriaNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return ca;
    }

    public int actualizar(Categoria ca) {
        String sql = "update categoria set CategoriaNombre=? where idCategoria=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ca.getCategoriaNombre());
            ps.setInt(2, ca.getIdCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idCategoria) {
        String sql = "delete from categoria where idCategoria=" + idCategoria;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
