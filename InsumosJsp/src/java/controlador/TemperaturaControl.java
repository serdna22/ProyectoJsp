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
import modelo.Temperatura;
import modelo.TemperaturaDao;

/**
 *
 * @author serdn
 */
public class TemperaturaControl extends HttpServlet {

    TemperaturaDao temdao = new TemperaturaDao();
    Temperatura tem = new Temperatura();
    String idTem;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Temperatura")) {
            switch (accion) {
                case "Listar":
                    List lista = temdao.listar();
                    request.setAttribute("temperaturaLista", lista);
                    break;
                case "Agregar":
                    String idTemperatura = request.getParameter("txtIdTemperatura");
                    String temperaturaNombre = request.getParameter("txtTemperaturaNombre");
                    tem.setIdTemperatura(Integer.parseInt(idTemperatura));
                    tem.setTemperaturaNombre(temperaturaNombre);

                    temdao.agregar(tem);
                    request.getRequestDispatcher("TemperaturaControl?menu=Temperatura&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idTem = request.getParameter("idEd");
                    Temperatura temp = temdao.listarId(Integer.parseInt(idTem));
                    request.setAttribute("temperaturaEditar", temp);
                    request.getRequestDispatcher("TemperaturaControl?menu=Temperatura&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String idTemperatura2 = request.getParameter("txtIdTemperatura");
                    String temperaturaNombre2 = request.getParameter("txtTemperaturaNombre");
                    tem.setIdTemperatura(Integer.parseInt(idTemperatura2));
                    tem.setTemperaturaNombre(temperaturaNombre2);
                    tem.setIdTemperatura(Integer.parseInt(idTem));
                    temdao.actualizar(tem);
                    request.getRequestDispatcher("Temperatura?menu=Temperatura&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idTem = request.getParameter("idEli");
                    temdao.eliminar(Integer.parseInt(idTem));
                    request.getRequestDispatcher("TemperaturaControl?menu=Temperatura&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Temperatura.jsp").forward(request, response);
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
