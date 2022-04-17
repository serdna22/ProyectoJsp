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
public class InsumoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    // operaciones Crud

    public List listar() {
        String sql = "select * from insumo";
        List<Insumo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Insumo in = new Insumo();
                // in.setId(rs.getInt(1));
                in.setCodigoInsumo(rs.getString(1));
                in.setInsumoNombre(rs.getString(2));
                in.setInsumoMarcaFK(rs.getInt(3));
                in.setInsumoRiesgoFK(rs.getInt(4));
                in.setInsumoPresentacionFK(rs.getInt(5));
                in.setInsumoObservacion(rs.getString(6));
                in.setInsumoExistencia(rs.getInt(7));
                in.setInsumoTemperaturaFK(rs.getInt(8));
                in.setInsumoRuta(rs.getString(9));
                in.setInsumoInvima(rs.getString(10));
                in.setInsumoLote(rs.getString(11));
                in.setInsumoVence(rs.getDate(12));
                in.setInsumoFichaTecnica(rs.getString(13));
                lista.add(in);

            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Insumo in) {
        String sql = "insert into insumo (insumoNombre,insumoMarcaFK,insumoRiesgoFK,insumoPresentacionFK,insumoObservacion,insumoExistencia,insumoTemperaturaFK,insumoRuta,insumoInvima,insumoLote,insumoVence,insumoFichaTecnica) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, in.getInsumoNombre());
            ps.setInt(2, in.getInsumoMarcaFK());
            ps.setInt(3, in.getInsumoRiesgoFK());
            ps.setInt(4, in.getInsumoPresentacionFK());
            ps.setString(5, in.getInsumoObservacion());
            ps.setInt(6, in.getInsumoExistencia());
            ps.setInt(7, in.getInsumoTemperaturaFK());
            ps.setString(8, in.getInsumoRuta());
            ps.setString(9, in.getInsumoInvima());
            ps.setString(10, in.getInsumoLote());
            ps.setDate(11, (Date) in.getInsumoVence());
            ps.setString(12, in.getInsumoFichaTecnica());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Insumo listarId(int codigoInsumo) {
        Insumo in = new Insumo();
        String sql = "select * from insumo where codigoInsumo=" + codigoInsumo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                in.setInsumoNombre(rs.getString(2));
                in.setInsumoMarcaFK(rs.getInt(3));
                in.setInsumoRiesgoFK(rs.getInt(4));
                in.setInsumoPresentacionFK(rs.getInt(5));
                in.setInsumoObservacion(rs.getString(6));
                in.setInsumoExistencia(rs.getInt(7));
                in.setInsumoTemperaturaFK(rs.getInt(8));
                in.setInsumoRuta(rs.getString(9));
                in.setInsumoInvima(rs.getString(10));
                in.setInsumoLote(rs.getString(11));
                in.setInsumoVence(rs.getDate(12));
                in.setInsumoFichaTecnica(rs.getString(13));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return in;
    }

    public int actualizar(Insumo in) {
        String sql = "update insumo set InsumoNombre=?, InsumoMarcaFK=?, InsumoRiesgoFK=?, InsumoPresentacionFK=?, InsumoObservacion=?, InsumoExistencia=?, InsumoTemperaturaFK=?, InsumoRuta=?, InsumoInvima=?, InsumoLote=?, InsumoVence=?, InsumoFichaTecnica where codigoInsumo=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, in.getInsumoNombre());
            ps.setInt(2, in.getInsumoMarcaFK());
            ps.setInt(3, in.getInsumoRiesgoFK());
            ps.setInt(4, in.getInsumoPresentacionFK());
            ps.setString(5, in.getInsumoObservacion());
            ps.setInt(6, in.getInsumoExistencia());
            ps.setInt(7, in.getInsumoTemperaturaFK());
            ps.setString(8, in.getInsumoRuta());
            ps.setString(9, in.getInsumoInvima());
            ps.setString(10, in.getInsumoLote());
            ps.setDate(11, (Date) in.getInsumoVence());
            ps.setString(12, in.getInsumoFichaTecnica());
            ps.setString(13, in.getCodigoInsumo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int codigoInsumo) {
        String sql = "delete from insumo where codigoInsumo=" + codigoInsumo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
