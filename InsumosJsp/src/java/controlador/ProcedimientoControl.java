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
import modelo.Procedimiento;
import modelo.ProcedimientoDao;

/**
 *
 * @author serdn
 */
public class ProcedimientoControl extends HttpServlet {

    ProcedimientoDao prodao = new ProcedimientoDao();
    Procedimiento pro = new Procedimiento();
    String idPro;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Procedimiento")) {
            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("procedimientoLista", lista);
                    break;
                case "Agregar":
                    String procedimientoNombre = request.getParameter("txtProcedimientoNombre");
                    pro.setProcedimientoNombre(procedimientoNombre);
                    prodao.agregar(pro);
                    request.getRequestDispatcher("ProcedimientoControl?menu=Procedimiento&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idPro = request.getParameter("idEd");
                    Procedimiento proce = prodao.listarId(Integer.parseInt(idPro));
                    request.setAttribute("procedimientoEditar", proce);
                    request.getRequestDispatcher("ProcedimientoControl?menu=Procedimiento&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String procedimientoNombre2 = request.getParameter("txtProcedimientoNombre");
                    pro.setProcedimientoNombre(procedimientoNombre2);
                    pro.setIdProcedimiento(Integer.parseInt(idPro));
                    prodao.actualizar(pro);
                    request.getRequestDispatcher("ProcedimientoControl?menu=Procedimiento&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idPro = request.getParameter("idEli");
                    prodao.eliminar(Integer.parseInt(idPro));
                    request.getRequestDispatcher("ProcedimientoControl?menu=Procedimiento&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Procedimiento.jsp").forward(request, response);
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
