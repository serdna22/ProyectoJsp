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
import modelo.Presentacion;
import modelo.PresentacionDao;

/**
 *
 * @author serdn
 */
public class PresentacionControl extends HttpServlet {

    PresentacionDao cadao = new PresentacionDao();
    Presentacion ca = new Presentacion();
    String idPre;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Presentacion")) {
            switch (accion) {
                case "Listar":
                    List lista = cadao.listar();
                    request.setAttribute("presentacionLista", lista);
                    break;
                case "Agregar":
//Autoincrement     String idPresentacion = request.getParameter("txtIdPresentacion");
                    String PresentacionNombre = request.getParameter("txtPresentacionNombre");
//                    ca.setIdPresentacion(Integer.parseInt(idPresentacion));
                    ca.setPresentacionNombre(PresentacionNombre);

                    cadao.agregar(ca);
                    request.getRequestDispatcher("PresentacionControl?menu=Presentacion&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idPre = request.getParameter("idEd");
                    Presentacion cate = cadao.listarId(Integer.parseInt(idPre));
                    request.setAttribute("PresentacionEditar", cate);
                    request.getRequestDispatcher("PresentacionControl?menu=Presentacion&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String PresentacionNombre2 = request.getParameter("txtPresentacionNombre");
                    ca.setPresentacionNombre(PresentacionNombre2);
                    ca.setIdPresentacion(Integer.parseInt(idPre));
                    cadao.actualizar(ca);
                    request.getRequestDispatcher("PresentacionControl?menu=Presentacion&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idPre = request.getParameter("idEli");
                    cadao.eliminar(Integer.parseInt(idPre));
                    request.getRequestDispatcher("PresentacionControl?menu=Presentacion&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Presentacion.jsp").forward(request, response);
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
