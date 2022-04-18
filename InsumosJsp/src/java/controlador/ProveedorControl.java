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
import modelo.Proveedor;
import modelo.ProveedorDao;

/**
 *
 * @author serdn
 */
public class ProveedorControl extends HttpServlet {

    ProveedorDao provdao = new ProveedorDao();
    Proveedor prov = new Proveedor();
    String idProv;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Categoria")) {
            switch (accion) {
                case "Listar":
                    List lista = provdao.listar();
                    request.setAttribute("proveedorLista", lista);
                    break;
                case "Agregar":
                    String proveedorNombre = request.getParameter("txtProveedorNombre");
                    prov.setProveedorNombre(proveedorNombre);
                    String proveedorDireccion = request.getParameter("txtProveedorDireccion");
                    prov.setProveedorDireccion(proveedorDireccion);
                    String proveedorTelefono = request.getParameter("txtProveedorTelefono");
                    prov.setProveedorTelefono(proveedorTelefono);
                    String proveedorCelular = request.getParameter("txtProveedorCelular");
                    prov.setProveedorCelular(proveedorCelular);
                    String proveedorFecha = request.getParameter("txtProveedorFecha");
                    prov.setProveedorFecha(proveedorFecha);
                    String proveedorCiudad = request.getParameter("txtProveedorCiudad");
                    prov.setProveedorCiudad(proveedorCiudad);
                    String proveedorCorreo = request.getParameter("txtProveedorCorreo");
                    prov.setProveedorCorreo(proveedorCorreo);
                    provdao.agregar(prov);
                    request.getRequestDispatcher("ProveedorControl?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idProv = request.getParameter("idEd");
                    Proveedor prove = provdao.listarId(idProv);
                    request.setAttribute("proveedorEditar", prove);
                    request.getRequestDispatcher("ProveedorControl?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String proveedorNombre2 = request.getParameter("txtProveedorNombre");
                    prov.setProveedorNombre(proveedorNombre2);
                    String proveedorDireccion2 = request.getParameter("txtProveedorDireccion");
                    prov.setProveedorDireccion(proveedorDireccion2);
                    String proveedorTelefono2 = request.getParameter("txtProveedorTelefono");
                    prov.setProveedorTelefono(proveedorTelefono2);
                    String proveedorCelular2 = request.getParameter("txtProveedorCelular");
                    prov.setProveedorCelular(proveedorCelular2);
                    String proveedorFecha2 = request.getParameter("txtProveedorFecha");
                    prov.setProveedorFecha(proveedorFecha2);
                    String proveedorCiudad2 = request.getParameter("txtProveedorCiudad");
                    prov.setProveedorCiudad(proveedorCiudad2);
                    String proveedorCorreo2 = request.getParameter("txtProveedorCorreo");
                    prov.setProveedorCorreo(proveedorCorreo2);
                    prov.setNitProveedor(idProv);
                    provdao.actualizar(prov);
                    request.getRequestDispatcher("ProveedorControl?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idProv = request.getParameter("idEli");
                    provdao.eliminar(Integer.parseInt(idProv));
                    request.getRequestDispatcher("ProveedorControl?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
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
