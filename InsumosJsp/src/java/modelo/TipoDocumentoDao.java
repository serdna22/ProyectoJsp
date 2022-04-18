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
public class TipoDocumentoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    // operaciones Crud

    public List listar() {
        String sql = "select * from tipodocumento order by idTipoDoc";
        List<TipoDocumento> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDocumento ca = new TipoDocumento();
                ca.setIdTipoDoc(rs.getInt(1));
                ca.setTipoDocNombre(rs.getString(2));
                lista.add(ca);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }
    
}
