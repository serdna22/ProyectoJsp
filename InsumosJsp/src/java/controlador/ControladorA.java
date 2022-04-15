/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import modelo.Usuario;
import modelo.UsuarioDao;

/**
 *
 * @author serdn
 */
public class ControladorA extends HttpServlet {

    UsuarioDao edao = new UsuarioDao();
    Usuario em = new Usuario();
    String idUsuario;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Usuario")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("usuariosLista", lista);
                    break;
                case "Agregar":
                    String tipoD = request.getParameter("txtTipoD");
                    String documento = request.getParameter("txtDocumento");
                    String nombres = request.getParameter("txtNombres");
                    String correo = request.getParameter("txtCorreo");
                    String contraseña = request.getParameter("txtContraseña");
                    String celular = request.getParameter("txtCelular");
                    String privilegio = request.getParameter("txtPrivilegio");
                    em.setUsuarioTipoIdenFK(Integer.parseInt(tipoD));
                    em.setUsuarioDocumento(documento);
                    em.setUsuarioNombre(nombres);
                    em.setEmail(correo);
                    em.setPassword(contraseña);
                    em.setUsuarioCelular(celular);
                    em.setUsuarioPrivilegio(Integer.parseInt(privilegio));
                    edao.agregar(em);
                    request.getRequestDispatcher("ControladorA?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idUsuario = request.getParameter("id");
                    Usuario e = edao.listarId(idUsuario);
                    request.setAttribute("usuario", e);
                    request.getRequestDispatcher("ControladorA?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String tipoD2 = request.getParameter("txtTipoD");
                    String documento2 = request.getParameter("txtDocumento");
                    String nombres2 = request.getParameter("txtNombres");
                    String correo2 = request.getParameter("txtCorreo");
                    String contraseña2 = request.getParameter("txtContraseña");
                    String celular2 = request.getParameter("txtCelular");
                    String privilegio2 = request.getParameter("txtPrivilegio");
                    em.setUsuarioTipoIdenFK(Integer.parseInt(tipoD2));
                    em.setUsuarioDocumento(documento2);
                    em.setUsuarioNombre(nombres2);
                    em.setEmail(correo2);
                    em.setPassword(contraseña2);
                    em.setUsuarioCelular(celular2);
                    em.setUsuarioPrivilegio(Integer.parseInt(privilegio2));
                    em.setUsuarioDocumento(idUsuario);
                    edao.actualizar(em);
                    request.getRequestDispatcher("ControladorA?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idUsuario = request.getParameter("id");
                    edao.eliminar(idUsuario);
                    request.getRequestDispatcher("ControladorA?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
