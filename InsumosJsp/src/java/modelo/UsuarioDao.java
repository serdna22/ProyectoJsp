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
        String sql = "select usuarioDocumento,usuarioNombre,usuarioPrivilegio,email "
                + "from usuarios where email =? and password=?";
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
                em.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return em;
    }
//    operaciones Crud

    public List listar() {
        String sql = "select usuarioTipoIdenFK,usuarioDocumento,usuarioNombre,email,password,usuarioCelular,"
                + "usuarioPrivilegio,tipoDocNombre from usuarios inner join tipodocumento "
                + "on tipodocumento.idTipoDoc=usuarios.usuarioTipoIdenFK";
        List<Usuario> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario em = new Usuario();
                em.setUsuarioTipoIdenFK(rs.getInt(1));
                em.setUsuarioDocumento(rs.getString(2));
                em.setUsuarioNombre(rs.getString(3));
                em.setEmail(rs.getString(4));
                em.setPassword(rs.getString(5));
                em.setUsuarioCelular(rs.getString(6));
                em.setUsuarioPrivilegio(rs.getInt(7));
                em.setTipoDocNombre(rs.getString(8));
                lista.add(em);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public int agregar(Usuario em) {
        String sql = "insert into usuarios (usuarioTipoIdenFK,usuarioDocumento,usuarioNombre,email,password,usuarioCelular,"
                + "usuarioPrivilegio) values (?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getUsuarioTipoIdenFK());
            ps.setString(2, em.getUsuarioDocumento());
            ps.setString(3, em.getUsuarioNombre());
            ps.setString(4, em.getEmail());
            ps.setString(5, em.getPassword());
            ps.setString(6, em.getUsuarioCelular());
            ps.setInt(7, em.getUsuarioPrivilegio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public Usuario listarId(String id) {
        Usuario emp = new Usuario();
                String sql = "select usuarioTipoIdenFK,usuarioDocumento,usuarioNombre,email,password,usuarioCelular,"
                + "usuarioPrivilegio,tipoDocNombre from usuarios inner join tipodocumento "
                + "on tipodocumento.idTipoDoc=usuarios.usuarioTipoIdenFK where usuarioDocumento='" + id + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setUsuarioTipoIdenFK(rs.getInt(1));
                emp.setUsuarioDocumento(rs.getString(2));
                emp.setUsuarioNombre(rs.getString(3));
                emp.setEmail(rs.getString(4));
                emp.setPassword(rs.getString(5));
                emp.setUsuarioCelular(rs.getString(6));
                emp.setUsuarioPrivilegio(rs.getInt(7));
                emp.setTipoDocNombre(rs.getString(8));
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return emp;
    }

    public int actualizar(Usuario em,String id) {
        String sql = "update usuarios set usuarioTipoIdenFK=?, usuarioDocumento=?, usuarioNombre=?,"
                + " email=?, password=?, usuarioCelular=?, usuarioPrivilegio=? where usuarioDocumento='"+id+"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getUsuarioTipoIdenFK());
            ps.setString(2, em.getUsuarioDocumento());
            ps.setString(3, em.getUsuarioNombre());
            ps.setString(4, em.getEmail());
            ps.setString(5, em.getPassword());
            ps.setString(6, em.getUsuarioCelular());
            ps.setInt(7, em.getUsuarioPrivilegio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return res;
    }

    public void eliminar(String id) {
        String sql = "delete from usuarios where usuarioDocumento='" + id + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
