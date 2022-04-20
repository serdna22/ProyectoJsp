/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;
import modelo.ProveedorDao;
import modelo.Insumo;
import modelo.InsumoDao;
import modelo.Factura;
import modelo.DetalleFactura;

/**
 *
 * @author serdn
 */
public class EntradaInsumoControl extends HttpServlet {

    ProveedorDao proDao = new ProveedorDao();
    Proveedor pro = new Proveedor();
    InsumoDao insDao = new InsumoDao();
    Insumo ins = new Insumo();
    Factura fac = new Factura();
    DetalleFactura detFac = new DetalleFactura();
    String idProv;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        HttpSession agregarInsumo = request.getSession();
        List<Factura> listaFactura = new ArrayList<>();

        if (menu.equals("EntradaInsumo")) {
            switch (accion) {
                case "Listar":
                    List listaPro = proDao.listar();
                    request.setAttribute("ProveedorLista", listaPro);
                    List listaIns = insDao.listar();
                    request.setAttribute("InsumoLista", listaIns);
                    break;
                case "Agregar":
                    String IdFactura = request.getParameter("txtIdFactura");
                    fac.setIdFactura(IdFactura);
                    String FacturaProveedorFK = request.getParameter("txtFacturaProveedorFK");
                    fac.setFacturaProveedorFK(FacturaProveedorFK);
                    String FacturaDescuento = request.getParameter("txtFacturaDescuento");
                    fac.setFacturaDescuento(Double.parseDouble(FacturaDescuento));
                    
                    if (agregarInsumo.getAttribute("insumosSession")!= null) {
                        listaFactura = (List<Factura>)agregarInsumo.getAttribute("insumosSession");
                    }
                    listaFactura.add(fac);
                    agregarInsumo.setAttribute("insumosSession", listaFactura);
                    request.setAttribute("agregarInsumoListas", agregarInsumo);
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idProv = request.getParameter("idEli");
                    proDao.eliminar((idProv));
                    request.getRequestDispatcher("ProveedorControl?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
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
