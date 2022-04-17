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
import modelo.Categoria;
import modelo.CategoriaDao;
import modelo.Elemento;
import modelo.ElementoDao;

/**
 *
 * @author serdn
 */
public class ElementoControl extends HttpServlet {

    ElementoDao eleDao = new ElementoDao();
    Elemento ele = new Elemento();
    PresentacionDao preDao = new PresentacionDao();
    Presentacion pre = new Presentacion();
    CategoriaDao catDao = new CategoriaDao();
    Categoria cat = new Categoria();
    String idEleme;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Elemento")) {
            switch (accion) {
                case "Listar":
                    List lista = eleDao.listar();
                    List listapre = preDao.listar();
                    List listacat = catDao.listar();
                    request.setAttribute("ElementoLista", lista);
                    request.setAttribute("PresentacionLista", listapre);
                    request.setAttribute("CategoriaLista", listacat);
                    break;
                case "Agregar":
                    String idElemento = request.getParameter("txtIdElemento");
                    String elementoNombre = request.getParameter("txtElementoNombre");
                    String elementoPresentacion = request.getParameter("txtElementoPresentacion");
                    String elementoCategoria = request.getParameter("txtElementoCategoria");
                    String elementoCantidad = request.getParameter("txtElementoCantidad");
                    String elementoRuta = request.getParameter("txtElementoRuta");
                    ele.setIdElemento(idElemento);
                    ele.setElementoNombre(elementoNombre);
                    ele.setElementoPresentacion(Integer.parseInt(elementoPresentacion));
                    ele.setElementoCategoria(Integer.parseInt(elementoCategoria));
                    ele.setElementoCantidad(Integer.parseInt(elementoCantidad));
                    ele.setElementoRuta(elementoRuta);
                    eleDao.agregar(ele);
                    request.getRequestDispatcher("ElementoControl?menu=Elemento&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idEleme = request.getParameter("idEd");
                    Elemento e = eleDao.listarId(idEleme);
                    request.setAttribute("Elemento", e);
                    request.getRequestDispatcher("ElementoControl?menu=Elemento&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String idElemento2 = request.getParameter("txtIdElemento");
                    String elementoNombre2 = request.getParameter("txtElementoNombre");
                    String elementoPresentacion2 = request.getParameter("txtElementoPresentacion");
                    String elementoCategoria2 = request.getParameter("txtElementoCategoria");
                    String elementoCantidad2 = request.getParameter("txtElementoCantidad");
                    String elementoRuta2 = request.getParameter("txtElementoRuta");
                    ele.setIdElemento(idElemento2);
                    ele.setElementoNombre(elementoNombre2);
                    ele.setElementoPresentacion(Integer.parseInt(elementoPresentacion2));
                    ele.setElementoCategoria(Integer.parseInt(elementoCategoria2));
                    ele.setElementoCantidad(Integer.parseInt(elementoCantidad2));
                    ele.setElementoRuta(elementoRuta2);
                    eleDao.actualizar(ele,idEleme);
                    request.getRequestDispatcher("ElementoControl?menu=Elemento&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idElemento = request.getParameter("idEl");
                    eleDao.eliminar(idElemento);
                    request.getRequestDispatcher("ElementoControl?menu=Elemento&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Elemento.jsp").forward(request, response);
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
