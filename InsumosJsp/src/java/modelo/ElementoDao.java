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
public class ElementoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
//    operaciones Crud

    public List listar() {
        String sql = "select * from elemento";
        List<Elemento> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Elemento elem = new Elemento();
                elem.setIdElemento(rs.getInt(1));
                elem.setElementoNombre(rs.getString(2));
                elem.setElementoPresentacion(rs.getInt(3));
                elem.setElementoCategoria(rs.getInt(4));
                elem.setElementoCantidad(rs.getInt(5));
                elem.setElementoRuta(rs.getString(6));
                lista.add(elem);

            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Elemento elem) {
        String sql = "insert into elemento (elementoNombre,elementoPresentacion,elementoCategoria,elementoCantidad,elementoRuta) values (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, elem.getElementoNombre());
            ps.setInt(2, elem.getElementoPresentacion());
            ps.setInt(3, elem.getElementoCategoria());
            ps.setInt(4, elem.getElementoCantidad());
            ps.setString(5, elem.getElementoRuta());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Elemento listarId(int IdElemento) {
        Elemento elem = new Elemento();
        String sql = "select * from elemento where set IdElemento=" + IdElemento;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                elem.setElementoNombre(rs.getString(2));
                elem.setElementoPresentacion(rs.getInt(3));
                elem.setElementoCategoria(rs.getInt(4));
                elem.setElementoCantidad(rs.getInt(5));
                elem.setElementoRuta(rs.getString(6));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return elem;
    }

    public int actualizar(Elemento elem) {
        String sql = "update elemento set elementoNombre=?, elementoPresentacion=?, elementoCategoria=?, elementoCantidad=?, elementoRuta=? where IdElemento=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, elem.getElementoNombre());
            ps.setInt(2, elem.getElementoPresentacion());
            ps.setInt(3, elem.getElementoCategoria());
            ps.setInt(4, elem.getElementoCantidad());
            ps.setString(5, elem.getElementoRuta());
            ps.setInt(6, elem.getIdElemento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int IdElemento) {
        String sql = "delete from elemento where IdElemento=" + IdElemento;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
