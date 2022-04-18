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
public class ProcedimientoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from procedimiento";
        List<Procedimiento> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Procedimiento pro = new Procedimiento();
                pro.setIdProcedimiento(rs.getInt(1));
                pro.setProcedimientoNombre(rs.getString(2));
                lista.add(pro);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Procedimiento pro) {
        String sql = "insert into procedimiento (procedimientoNombre) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProcedimientoNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Procedimiento listarId(int idProcedimiento) {
        Procedimiento pro = new Procedimiento();
        String sql = "select * from procedimiento where idProcedimiento=" + idProcedimiento;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setIdProcedimiento(rs.getInt(1));
                pro.setProcedimientoNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return pro;
    }

    public int actualizar(Procedimiento pro) {
        String sql = "update procedimiento set procedimientoNombre=? where idProcedimiento=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProcedimientoNombre());
            ps.setInt(2, pro.getIdProcedimiento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idProcedimiento) {
        String sql = "delete from procedimiento where idProcedimiento=" + idProcedimiento;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
