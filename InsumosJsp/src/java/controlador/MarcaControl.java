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
import modelo.Marca;
import modelo.MarcaDao;

/**
 *
 * @author serdn
 */
public class MarcaControl extends HttpServlet {

    MarcaDao mardao = new MarcaDao();
    Marca mar = new Marca();
    String idMar;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Marca")) {
            switch (accion) {
                case "Listar":
                    List lista = mardao.listar();
                    request.setAttribute("marcaLista", lista);
                    break;
                case "Agregar":
                    String marcaNombre = request.getParameter("txtMarcaNombre");
                    mar.setMarcaNombre(marcaNombre);
                    mardao.agregar(mar);
                    request.getRequestDispatcher("MarcaControl?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idMar = request.getParameter("idEd");
                    Marca marc = mardao.listarId(Integer.parseInt(idMar));
                    request.setAttribute("marcaEditar", marc);
                    request.getRequestDispatcher("MarcaControl?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String marcaNombre2 = request.getParameter("txtMarcaNombre");
                    mar.setMarcaNombre(marcaNombre2);
                    mar.setIdMarca(Integer.parseInt(idMar));
                    mardao.actualizar(mar);
                    request.getRequestDispatcher("MarcaControl?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idMar = request.getParameter("idEli");
                    mardao.eliminar(Integer.parseInt(idMar));
                    request.getRequestDispatcher("MarcaControl?menu=Marca&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Marca.jsp").forward(request, response);
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
