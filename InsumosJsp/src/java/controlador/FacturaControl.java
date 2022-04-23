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
import modelo.Factura;
import modelo.FacturaDao;
import modelo.DetalleFactura;
import modelo.DetalleFacturaDao;

/**
 *
 * @author serdn
 */
public class FacturaControl extends HttpServlet {

    FacturaDao facDao = new FacturaDao();
    Factura fac = new Factura();
    DetalleFacturaDao detFacDao = new DetalleFacturaDao();
    DetalleFactura detFac = new DetalleFactura();
    String idFac;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Factura")) {
            switch (accion) {
                case "Listar":
                    List lista = facDao.listar();
                    request.setAttribute("FacturaLista", lista);
                    break;
                case "Pdf":

                    request.getRequestDispatcher("FacturaControl?menu=Factura&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("VerFactura.jsp").forward(request, response);
        }
        if (menu.equals("Ver")) {
            switch (accion) {
                case "Listar":
                    idFac = request.getParameter("id");
                    Factura factura = facDao.listarTabla(idFac);
                    request.setAttribute("FacturaListaId", factura);
                    List DF = detFacDao.listarId(idFac);
                    request.setAttribute("DetalleFacturaId", DF);
                    break;
                default:
                    request.getRequestDispatcher("VerFacturaTabla.jsp").forward(request, response);
            }
            request.getRequestDispatcher("VerFacturaTabla.jsp").forward(request, response);
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
