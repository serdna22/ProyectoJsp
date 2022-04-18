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
import modelo.TipoDocumento;
import modelo.TipoDocumentoDao;

/**
 *
 * @author serdn
 */
public class TipoDocumentoControl extends HttpServlet {

    TipoDocumentoDao tipodocdao = new TipoDocumentoDao();
    TipoDocumento tipodoc = new TipoDocumento();
    String idTipodoc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("TipoDocumento")) {
            switch (accion) {
                case "Listar":
                    List lista = tipodocdao.listar();
                    request.setAttribute("tipodocumentoLista", lista);
                    break;
                /*case "Agregar":
                    String tipodocNombre = request.getParameter("txtTipoDocNombre");
                    tipodoc.setTipoDocNombre(tipodocNombre);
                    tipodocdao.agregar(tipodoc);
                    request.getRequestDispatcher("TipoDocumentoControl?menu=TipoDocumento&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idTipodoc = request.getParameter("idEd");
                    TipoDocumento tipodo = tipodocdao.listarId(Integer.parseInt(idTipodoc));
                    request.setAttribute("tipodocumentoEditar", tipodo);
                    request.getRequestDispatcher("TipoDocumentoControl?menu=TipoDocumento&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String tipoDocNombre2 = request.getParameter("txtTipoDocNombre");
                    tipodoc.setTipoDocNombre(tipoDocNombre2);
                    tipodoc.setIdTipoDoc(Integer.parseInt(idTipodoc));
                    tipodocdao.actualizar(tipodoc);
                    request.getRequestDispatcher("TipoDocumentoControl?menu=TipoDocumento&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idTipodoc = request.getParameter("idEli");
                    tipodocdao.eliminar(Integer.parseInt(idTipodoc));
                    request.getRequestDispatcher("TipoDocumentoControl?menu=TipoDocumento&accion=Listar").forward(request, response);
                    break;*/
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("TipoDocumento.jsp").forward(request, response);
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
