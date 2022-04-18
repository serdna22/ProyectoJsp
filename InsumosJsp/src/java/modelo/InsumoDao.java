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
public class InsumoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    // operaciones Crud

    public List listar() {
        String sql = "SELECT codigoInsumo,insumoNombre,insumoMarcaFK,insumoRiesgoFK,insumoPresentacionFK,insumoObservacion, "
                + "insumoExistencia,insumoTemperaturaFK,insumoRuta,insumoInvima,insumoLote,insumoVence,insumoFichaTecnica,marcaNombre, "
                + "riesgoClasificacion,insumoPresentacionFK,temperaturaNombre "
                + "FROM insumo inner join marca on insumo.insumoMarcaFK=marca.idMarca "
                + "inner join riesgo on insumo.insumoRiesgoFK=riesgo.idRiesgo "
                + "inner join presentacion on presentacion.idPresentacion=insumo.insumoPresentacionFK "
                + "inner join temperatura on temperatura.idTemperatura=insumo.insumoTemperaturaFK";
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
                in.setInsumoVence(rs.getString(12));
                in.setInsumoFichaTecnica(rs.getString(13));
                in.setMarcaNombre(rs.getString(14));
                in.setRiesgoClasificacion(rs.getString(15));
                in.setPresentacionNombre(rs.getString(16));
                in.setTemperaturaNombre(rs.getString(17));
                lista.add(in);

            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Insumo in) {
        String sql = "insert into insumo (codigoInsumo, insumoNombre,insumoMarcaFK,insumoRiesgoFK,"
                + "insumoPresentacionFK,insumoObservacion,insumoExistencia,insumoTemperaturaFK,"
                + "insumoRuta,insumoInvima,insumoLote,insumoVence,insumoFichaTecnica)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, in.getCodigoInsumo());
            ps.setString(2, in.getInsumoNombre());
            ps.setInt(3, in.getInsumoMarcaFK());
            ps.setInt(4, in.getInsumoRiesgoFK());
            ps.setInt(5, in.getInsumoPresentacionFK());
            ps.setString(6, in.getInsumoObservacion());
            ps.setInt(7, in.getInsumoExistencia());
            ps.setInt(8, in.getInsumoTemperaturaFK());
            ps.setString(9, in.getInsumoRuta());
            ps.setString(10, in.getInsumoInvima());
            ps.setString(11, in.getInsumoLote());
            ps.setString(12, in.getInsumoVence());
            ps.setString(13, in.getInsumoFichaTecnica());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Insumo listarId(String codigoInsumo) {
        Insumo in = new Insumo();
                String sql = "SELECT codigoInsumo,insumoNombre,insumoMarcaFK,insumoRiesgoFK,insumoPresentacionFK,insumoObservacion, "
                + "insumoExistencia,insumoTemperaturaFK,insumoRuta,insumoInvima,insumoLote,insumoVence,insumoFichaTecnica,marcaNombre, "
                + "riesgoClasificacion,presentacionNombre,temperaturaNombre "
                + "FROM insumo inner join marca on insumo.insumoMarcaFK=marca.idMarca "
                + "inner join riesgo on insumo.insumoRiesgoFK=riesgo.idRiesgo "
                + "inner join presentacion on presentacion.idPresentacion=insumo.insumoPresentacionFK "
                + "inner join temperatura on temperatura.idTemperatura=insumo.insumoTemperaturaFK "
                + "where codigoInsumo='"+codigoInsumo+"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
                in.setInsumoVence(rs.getString(12));
                in.setInsumoFichaTecnica(rs.getString(13));
                in.setMarcaNombre(rs.getString(14));
                in.setRiesgoClasificacion(rs.getString(15));
                in.setPresentacionNombre(rs.getString(16));
                in.setTemperaturaNombre(rs.getString(17));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return in;
    }

    public int actualizar(Insumo in,String id) {
        String sql = "update insumo set codigoInsumo=?, InsumoNombre=?, InsumoMarcaFK=?, InsumoRiesgoFK=?, InsumoPresentacionFK=?, "
                + "InsumoObservacion=?, InsumoExistencia=?, InsumoTemperaturaFK=?, InsumoRuta=?, InsumoInvima=?, "
                + "InsumoLote=?, InsumoVence=?, InsumoFichaTecnica=? where codigoInsumo='"+id+"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, in.getCodigoInsumo());
            ps.setString(2, in.getInsumoNombre());
            ps.setInt(3, in.getInsumoMarcaFK());
            ps.setInt(4, in.getInsumoRiesgoFK());
            ps.setInt(5, in.getInsumoPresentacionFK());
            ps.setString(6, in.getInsumoObservacion());
            ps.setInt(7, in.getInsumoExistencia());
            ps.setInt(8, in.getInsumoTemperaturaFK());
            ps.setString(9, in.getInsumoRuta());
            ps.setString(10, in.getInsumoInvima());
            ps.setString(11, in.getInsumoLote());
            ps.setString(12, in.getInsumoVence());
            ps.setString(13, in.getInsumoFichaTecnica());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(String codigoInsumo) {
        String sql = "delete from insumo where codigoInsumo='" + codigoInsumo+"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
