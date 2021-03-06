/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Usuario {

    private int usuarioTipoIdenFK;
    private String usuarioDocumento;
    private String usuarioNombre;
    private String email;
    private String password;
    private String usuarioCelular;
    private int usuarioPrivilegio;
    private String tipoDocNombre;

    public Usuario() {
    }

    public Usuario(int usuarioTipoIdenFK, String usuarioDocumento, String usuarioNombre, String email, String password,
            String usuarioCelular, int usuarioPrivilegio) {
        this.usuarioTipoIdenFK = usuarioTipoIdenFK;
        this.usuarioDocumento = usuarioDocumento;
        this.usuarioNombre = usuarioNombre;
        this.email = email;
        this.password = password;
        this.usuarioCelular = usuarioCelular;
        this.usuarioPrivilegio = usuarioPrivilegio;
    }

    public int getUsuarioTipoIdenFK() {
        return usuarioTipoIdenFK;
    }

    public void setUsuarioTipoIdenFK(int usuarioTipoIdenFK) {
        this.usuarioTipoIdenFK = usuarioTipoIdenFK;
    }

    public String getUsuarioDocumento() {
        return usuarioDocumento;
    }

    public void setUsuarioDocumento(String usuarioDocumento) {
        this.usuarioDocumento = usuarioDocumento;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuarioCelular() {
        return usuarioCelular;
    }

    public void setUsuarioCelular(String usuarioCelular) {
        this.usuarioCelular = usuarioCelular;
    }

    public int getUsuarioPrivilegio() {
        return usuarioPrivilegio;
    }

    public void setUsuarioPrivilegio(int usuarioPrivilegio) {
        this.usuarioPrivilegio = usuarioPrivilegio;
    }

    public String getTipoDocNombre() {
        return tipoDocNombre;
    }

    public void setTipoDocNombre(String tipoDocNombre) {
        this.tipoDocNombre = tipoDocNombre;
    }

}
