/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author serdn
 */
public class UsuarioDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int res;
    
        public Usuario login(String usuario, String password) {
        Usuario em = new Usuario();
        String sql = "select usuarioDocumento,usuarioNombre,usuarioPrivilegio from usuario where email =? and password=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setUsuarioDocumento(rs.getString("usuarioDocumento"));
                em.setUsuarioNombre(rs.getString("usuarioNombre"));
                em.setUsuarioPrivilegio(rs.getInt("usuarioPrivilegio"));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return em;
    }
//    operaciones Crud
}
