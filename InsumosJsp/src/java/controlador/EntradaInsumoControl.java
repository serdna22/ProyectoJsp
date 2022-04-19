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

/**
 *
 * @author serdn
 */
public class EntradaInsumoControl extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("EntradaInsumo")) {
            switch (accion) {
                case "Listar":
                    request.getRequestDispatcher("EntradaInsumo.jsp").forward(request, response);
                    break;
                case "Agregar":
//                    String idEntradaInsumo = request.getParameter("txtIdEntradaInsumo");
//                    String EntradaInsumoNombre = request.getParameter("txtEntradaInsumoNombre");
//                    String EntradaInsumoPresentacion = request.getParameter("txtEntradaInsumoPresentacion");
//                    String EntradaInsumoCategoria = request.getParameter("txtEntradaInsumoCategoria");
//                    String EntradaInsumoCantidad = request.getParameter("txtEntradaInsumoCantidad");
//                    String EntradaInsumoRuta = request.getParameter("txtEntradaInsumoRuta");
//                    ele.setIdEntradaInsumo(idEntradaInsumo);
//                    ele.setEntradaInsumoNombre(EntradaInsumoNombre);
//                    ele.setEntradaInsumoPresentacion(Integer.parseInt(EntradaInsumoPresentacion));
//                    ele.setEntradaInsumoCategoria(Integer.parseInt(EntradaInsumoCategoria));
//                    ele.setEntradaInsumoCantidad(Integer.parseInt(EntradaInsumoCantidad));
//                    ele.setEntradaInsumoRuta(EntradaInsumoRuta);
//                    eleDao.agregar(ele);
//                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;
                case "Editar":
//                    idEleme = request.getParameter("idEd");
//                    EntradaInsumoControl e = eleDao.listarId(idEleme);
//                    request.setAttribute("EntradaInsumo", e);
//                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
////                    String idEntradaInsumo2 = request.getParameter("txtIdEntradaInsumo");
////                    String EntradaInsumoNombre2 = request.getParameter("txtEntradaInsumoNombre");
////                    String EntradaInsumoPresentacion2 = request.getParameter("txtEntradaInsumoPresentacion");
////                    String EntradaInsumoCategoria2 = request.getParameter("txtEntradaInsumoCategoria");
////                    String EntradaInsumoCantidad2 = request.getParameter("txtEntradaInsumoCantidad");
////                    String EntradaInsumoRuta2 = request.getParameter("txtEntradaInsumoRuta");
////                    ele.setIdEntradaInsumo(idEntradaInsumo2);
////                    ele.setEntradaInsumoNombre(EntradaInsumoNombre2);
////                    ele.setEntradaInsumoPresentacion(Integer.parseInt(EntradaInsumoPresentacion2));
////                    ele.setEntradaInsumoCategoria(Integer.parseInt(EntradaInsumoCategoria2));
////                    ele.setEntradaInsumoCantidad(Integer.parseInt(EntradaInsumoCantidad2));
////                    ele.setEntradaInsumoRuta(EntradaInsumoRuta2);
////                    eleDao.actualizar(ele,idEleme);
////                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;
//                case "Eliminar":
//                    idEntradaInsumo = request.getParameter("idEl");
//                    eleDao.eliminar(idEntradaInsumo);
//                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
//                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("EntradaInsumo.jsp").forward(request, response);
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
