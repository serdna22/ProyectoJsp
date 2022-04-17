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
import modelo.Riesgo;
import modelo.RiesgoDao;

/**
 *
 * @author serdn
 */
public class RiesgoControl extends HttpServlet {

    RiesgoDao riesdao = new RiesgoDao();
    Riesgo ries = new Riesgo();
    String idRies;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Riesgo")) {
            switch (accion) {
                case "Listar":
                    List lista = riesdao.listar();
                    request.setAttribute("riesgoLista", lista);
                    break;
                case "Agregar":
                    String riesgoClasificacion = request.getParameter("txtRiesgoClasificacion");
                    ries.setRiesgoClasificacion(riesgoClasificacion);
                    riesdao.agregar(ries);
                    request.getRequestDispatcher("RiesgoControl?menu=Riesgo&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idRies = request.getParameter("idEd");
                    Riesgo riess = riesdao.listarId(Integer.parseInt(idRies));
                    request.setAttribute("riesgoEditar", riess);
                    request.getRequestDispatcher("RiesgoControl?menu=Riesgo&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String riesgoClasificacion2 = request.getParameter("txtRiesgoClasificacion");
                    ries.setRiesgoClasificacion(riesgoClasificacion2);
                    ries.setIdRiesgo(Integer.parseInt(idRies));
                    riesdao.actualizar(ries);
                    request.getRequestDispatcher("RiesgoControl?menu=Riesgo&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idRies = request.getParameter("idEli");
                    riesdao.eliminar(Integer.parseInt(idRies));
                    request.getRequestDispatcher("RiesgoControl?menu=Riesgo&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Riesgo.jsp").forward(request, response);
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
