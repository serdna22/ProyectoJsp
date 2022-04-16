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
public class MedicamentoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;

//    operaciones Crud
    
    public List listar() {
        String sql = "select * from medicamento";
        List<Medicamento> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento medi = new Medicamento();
                medi.setMedicamentoCodigoInsumo(rs.getInt(1));
                medi.setMedicamentoPrincipioActivoFK(rs.getInt(2));
                medi.setMedicamentoFormaFarmaceuticaFK(rs.getInt(3));
                medi.setMedicamentoConcentracionFK(rs.getInt(4));
                medi.setMedicamentoUnidadMedidaFK(rs.getInt(5));
                lista.add(medi);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Medicamento medi) {
        String sql = "insert into medicamento (medicamentoPrincipioActivoFK,medicamentoFormaFarmaceuticaFK,medicamentoConcentracionFK,medicamentoUnidadMedidaFK) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, medi.getMedicamentoPrincipioActivoFK());
            ps.setInt(2, medi.getMedicamentoFormaFarmaceuticaFK());
            ps.setInt(3, medi.getMedicamentoConcentracionFK());
            ps.setInt(4, medi.getMedicamentoUnidadMedidaFK());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Medicamento listarId(int medicamentoCodigoInsumo) {
        Medicamento medi = new Medicamento();
        String sql = "select * from medicamento where medicamentoCodigoInsumo=" + medicamentoCodigoInsumo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                medi.setMedicamentoPrincipioActivoFK(rs.getInt(2));
                medi.setMedicamentoFormaFarmaceuticaFK(rs.getInt(3));
                medi.setMedicamentoConcentracionFK(rs.getInt(4));
                medi.setMedicamentoUnidadMedidaFK(rs.getInt(5));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return medi;
    }

    public int actualizar(Medicamento medi) {
        String sql = "update medicamento set medicamentoPrincipioActivoFK=?, medicamentoFormaFarmaceuticaFK=?, medicamentoConcentracionFK=?, medicamentoUnidadMedidaFK=?, where medicamentoCodigoInsumo=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, medi.getMedicamentoPrincipioActivoFK());
            ps.setInt(2, medi.getMedicamentoFormaFarmaceuticaFK());
            ps.setInt(3, medi.getMedicamentoConcentracionFK());
            ps.setInt(4, medi.getMedicamentoUnidadMedidaFK());
            ps.setInt(5, medi.getMedicamentoCodigoInsumo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(int medicamentoCodigoInsumo) {
        String sql = "delete from medicamento where medicamentoCodigoInsumo=" + medicamentoCodigoInsumo;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
