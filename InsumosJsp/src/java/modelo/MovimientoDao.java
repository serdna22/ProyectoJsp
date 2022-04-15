/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc_Estiven
 */
public class MovimientoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

    // operaciones Crud
    public List listar() {
        String sql = "select * from movimiento";
        List<Movimiento> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movimiento mov = new Movimiento();
                mov.setIdMovimiento(rs.getInt(1));
                mov.setMovimientoFecha(rs.getDate(2));
                mov.setMovimientoHora(rs.getDate(3));
                mov.setMovimientoTipo(rs.getString(4));
                mov.setMovimientoEntidad(rs.getString(5));
                mov.setMovimientoUsuario(rs.getString(6));
                mov.setMovimientoDato(rs.getString(7));
                lista.add(mov);

            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Movimiento mov) {
        String sql = "insert into movimiento (movimientoFecha,movimientoHora,movimientoTipo,movimientoEntidad,movimientoUsuario,movimientoDato) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) mov.getMovimientoFecha());
            ps.setDate(2, (Date) mov.getMovimientoHora());
            ps.setString(3, mov.getMovimientoTipo());
            ps.setString(4, mov.getMovimientoEntidad());
            ps.setString(5, mov.getMovimientoUsuario());
            ps.setString(6, mov.getMovimientoDato());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Movimiento listarId(int IdMovimiento) {
        Movimiento mov = new Movimiento();
        String sql = "select * from movimiento where IdMovimiento=" + IdMovimiento;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mov.setMovimientoFecha(rs.getDate(2));
                mov.setMovimientoHora(rs.getDate(3));
                mov.setMovimientoTipo(rs.getString(4));
                mov.setMovimientoEntidad(rs.getString(5));
                mov.setMovimientoUsuario(rs.getString(6));
                mov.setMovimientoDato(rs.getString(7));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return mov;
    }

    public int actualizar(Movimiento mov) {
        String sql = "update movimiento set movimientoFecha=?, movimientoHora=?, movimientoTipo=?, movimientoEntidad=?, movimientoUsuario=?, movimientoDato=? where idMovimiento=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) mov.getMovimientoFecha());
            ps.setDate(2, (Date) mov.getMovimientoHora());
            ps.setString(3, mov.getMovimientoTipo());
            ps.setString(4, mov.getMovimientoEntidad());
            ps.setString(5, mov.getMovimientoUsuario());
            ps.setString(6, mov.getMovimientoDato());
            ps.setInt(7, mov.getIdMovimiento());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int idMovimiento) {
        String sql = "delete from movimiento where idMovimiento=" + idMovimiento;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
