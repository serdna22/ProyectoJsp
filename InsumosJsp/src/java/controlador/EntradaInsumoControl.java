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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        HttpSession sessionFactura = request.getSession();
        ArrayList<DetalleFactura> listaDF = (ArrayList<DetalleFactura>) session.getAttribute("listaDF");

        if (menu.equals("EntradaInsumo")) {
            switch (accion) {
                case "Listar":
                    List listaPro = proDao.listar();
                    request.setAttribute("ProveedorLista", listaPro);
                    List listaIns = insDao.listar();
                    request.setAttribute("InsumoLista", listaIns);
                    Factura facc = (Factura) sessionFactura.getAttribute("Factura");
                    request.setAttribute("factura", facc);
                    break;
                case "Agregar":
                    String IdFactura = request.getParameter("txtIdFactura");
                    fac.setIdFactura(IdFactura);
                    String FacturaProveedorFK = request.getParameter("txtFacturaProveedorFK");
                    fac.setFacturaProveedorFK(FacturaProveedorFK);
                    String FacturaDescuento = request.getParameter("txtFacturaDescuento");
                    fac.setFacturaDescuento(Double.parseDouble(FacturaDescuento));
                    Proveedor nombrePro = proDao.listarId(FacturaProveedorFK);
                    fac.setNombreProveedor(nombrePro.getProveedorNombre());
                    sessionFactura.setAttribute("Factura", fac);

                    String DFinsumoFK = request.getParameter("txtDFinsumoFK");
                    detFac.setDFinsumoFK(DFinsumoFK);
                    String DFcantidadInsumo1 = request.getParameter("txtDFcantidadInsumo");
                    String DFcantidadInsumo2 = request.getParameter("txtDFcantidadInsumo2");
                    int uno = Integer.parseInt(DFcantidadInsumo1);
                    int dos = Integer.parseInt(DFcantidadInsumo2);
                    detFac.setDFcantidadInsumo(uno * dos);
                    String DFlote = request.getParameter("txtDFlote");
                    detFac.setDFlote(DFlote);
                    String DFinvima = request.getParameter("txtDFinvima");
                    detFac.setDFinvima(DFinvima);
                    String DFfechaVence = request.getParameter("txtDFfechaVence");
                    detFac.setDFfechaVence(DFfechaVence);
                    String DFiva = request.getParameter("txtDFiva");
                    detFac.setDFiva(Float.parseFloat(DFiva));
                    String DFvalorUnitario = request.getParameter("txtDFvalorUnitario");
                    detFac.setDFvalorUnitario(Double.parseDouble(DFvalorUnitario));
                    detFac.setDFvalorTotal(detFac.getDFvalorUnitario() * detFac.getDFcantidadInsumo());
                    Insumo nombre = insDao.listarId(DFinsumoFK);
                    detFac.setNombreInsumo(nombre.getInsumoNombre());

                    if (listaDF == null) {
                        listaDF = new ArrayList<DetalleFactura>();
                    }
                    listaDF.add(detFac);
                    detFac = new DetalleFactura();
                    session.setAttribute("listaDF", listaDF);
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;

                case "Vaciar":
//                    sessionFactura.invalidate();
                    session.invalidate();
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;

                case "Quitar":
                    String id = request.getParameter("idQu");
                    listaDF.remove(Integer.parseInt(id));
                    session.setAttribute("listaDF", listaDF);
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;
                case "Guardar":
                    
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
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
