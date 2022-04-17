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
import modelo.Categoria;
import modelo.CategoriaDao;

/**
 *
 * @author serdn
 */
public class CategoriaControl extends HttpServlet {

    CategoriaDao cadao = new CategoriaDao();
    Categoria ca = new Categoria();
    String idCate;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
                if (menu.equals("Categoria")) {
            switch (accion) {
                case "Listar":
                    List lista = cadao.listar();
                    request.setAttribute("categoriaLista", lista);
                    break;
                case "Agregar":
//int autoincrement String idCategoria = request.getParameter("txtIdCategoria");
                    String categoriaNombre = request.getParameter("txtCategoriaNombre");
//                    ca.setIdCategoria(Integer.parseInt(idCategoria));
                    ca.setCategoriaNombre(categoriaNombre);
 
                    cadao.agregar(ca);
                    request.getRequestDispatcher("CategoriaControl?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idCate = request.getParameter("idEd");
                    Categoria cate = cadao.listarId(Integer.parseInt(idCate));
                    request.setAttribute("categoriaEditar", cate);
                    request.getRequestDispatcher("CategoriaControl?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String categoriaNombre2 = request.getParameter("txtCategoriaNombre");
                    ca.setCategoriaNombre(categoriaNombre2);
                    ca.setIdCategoria(Integer.parseInt(idCate));
                    cadao.actualizar(ca);
                    request.getRequestDispatcher("CategoriaControl?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idCate = request.getParameter("idEli");
                    cadao.eliminar(Integer.parseInt(idCate));
                    request.getRequestDispatcher("CategoriaControl?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Categoria.jsp").forward(request, response);
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
