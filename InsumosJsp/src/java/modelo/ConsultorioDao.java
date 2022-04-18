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
public class ConsultorioDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    public List listar() {
        String sql = "select * from consultorio";
        List<Consultorio> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consultorio consu = new Consultorio();
                consu.setIdConsultorio(rs.getInt(1));
                consu.setConsultorioNombre(rs.getString(2));
                lista.add(consu);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Consultorio consu) {
        String sql = "insert into consultorio (consultorioNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, consu.getConsultorioNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Consultorio listarId(int idConsultorio) {
        Consultorio consu = new Consultorio();
        String sql = "select * from consultorio where idConsultorio=" + idConsultorio;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                consu.setIdConsultorio(rs.getInt(1));
                consu.setConsultorioNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return consu;
    }

    public int actualizar(Consultorio consu) {
        String sql = "update consultorio set consultorioNombre=? where idConsultorio=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, consu.getConsultorioNombre());
            ps.setInt(2, consu.getIdConsultorio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idConsultorio) {
        String sql = "delete from consultorio where idConsultorio=" + idConsultorio;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
