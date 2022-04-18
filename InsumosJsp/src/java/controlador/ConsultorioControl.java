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
import modelo.Consultorio;
import modelo.ConsultorioDao;

/**
 *
 * @author serdn
 */
public class ConsultorioControl extends HttpServlet {

    ConsultorioDao consdao = new ConsultorioDao();
    Consultorio cons = new Consultorio();
    String idCons;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Consultorio")) {
            switch (accion) {
                case "Listar":
                    List lista = consdao.listar();
                    request.setAttribute("consultorioLista", lista);
                    break;
                case "Agregar":
                    String consultorioNombre = request.getParameter("txtConsultorioNombre");
                    cons.setConsultorioNombre(consultorioNombre);
                    consdao.agregar(cons);
                    request.getRequestDispatcher("ConsultorioControl?menu=Consultorio&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idCons = request.getParameter("idEd");
                    Consultorio consu = consdao.listarId(Integer.parseInt(idCons));
                    request.setAttribute("consultorioEditar", consu);
                    request.getRequestDispatcher("ConsultorioControl?menu=Consultorio&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String consultorioNombre2 = request.getParameter("txtConsultorioNombre");
                    cons.setConsultorioNombre(consultorioNombre2);
                    cons.setIdConsultorio(Integer.parseInt(idCons));
                    consdao.actualizar(cons);
                    request.getRequestDispatcher("ConsultorioControl?menu=Consultorio&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idCons = request.getParameter("idEli");
                    consdao.eliminar(Integer.parseInt(idCons));
                    request.getRequestDispatcher("ConsultorioControl?menu=Consultorio&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Consultorio.jsp").forward(request, response);
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
