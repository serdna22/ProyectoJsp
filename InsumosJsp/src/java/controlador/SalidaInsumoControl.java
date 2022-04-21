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
import modelo.Consultorio;
import modelo.ConsultorioDao;
import modelo.Insumo;
import modelo.InsumoDao;
import modelo.Salida;
import modelo.DetalleSalida;
import modelo.DetalleSalidaDao;
import modelo.SalidaDao;
import modelo.Usuario;

/**
 *
 * @author serdn
 */
public class SalidaInsumoControl extends HttpServlet {

    ConsultorioDao conDao = new ConsultorioDao();
    Consultorio con = new Consultorio();
    InsumoDao insDao = new InsumoDao();
    Insumo ins = new Insumo();
    Salida Sal = new Salida();
    SalidaDao SalDao = new SalidaDao();
    DetalleSalida detSal = new DetalleSalida();
    DetalleSalidaDao detSalDao = new DetalleSalidaDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        ArrayList<DetalleSalida> listaDS = (ArrayList<DetalleSalida>) session.getAttribute("listaDS");
        Usuario usu = (Usuario)request.getSession().getAttribute("usuario");

        if (menu.equals("EntradaInsumo")) {
            switch (accion) {
                case "Listar":
                    List listaCon = conDao.listar();
                    request.setAttribute("ConsultorioLista", listaCon);
                    List listaIns = insDao.listar();
                    request.setAttribute("InsumoLista", listaIns);
                    Salida Sali = (Salida) session.getAttribute("Salida");
                    request.setAttribute("Salida", Sali);
                    request.setAttribute("usuario", usu);
                    break;
                case "Agregar":
                    String IdSalida = request.getParameter("txtIdSalida");
                    Sal.setIdSalida(IdSalida);
                    String SalidaConsultorioFK = request.getParameter("txtSalidaConsultorioFK");
                    Sal.setSalidaConsultorioFK(SalidaConsultorioFK);
                    String SalidaDescuento = request.getParameter("txtSalidaDescuento");
                    Sal.setSalidaDescuento(Double.parseDouble(SalidaDescuento));
                    Consultorio nombreCon = conDao.listarId(SalidaConsultorioFK);
                    Sal.setDocumentoUsuario(usu.getUsuarioDocumento());
                    Sal.setNombreConsultorio(nombreCon.getConsultorioNombre());
                    session.setAttribute("Salida", Sal);
                    

                    String DFinsumoFK = request.getParameter("txtDFinsumoFK");
                    detSal.setDFinsumoFK(DFinsumoFK);
                    
                    String DFcantidadInsumo1 = request.getParameter("txtDFcantidadInsumo");
                    String DFcantidadInsumo2 = request.getParameter("txtDFcantidadInsumo2");
                    int uno = Integer.parseInt(DFcantidadInsumo1);
                    int dos = Integer.parseInt(DFcantidadInsumo2);
                    detSal.setDFcantidadInsumo(uno * dos);
                    String DFlote = request.getParameter("txtDFlote");
                    detSal.setDFlote(DFlote);
                    String DFinvima = request.getParameter("txtDFinvima");
                    detSal.setDFinvima(DFinvima);
                    String DFfechaVence = request.getParameter("txtDFfechaVence");
                    detSal.setDFfechaVence(DFfechaVence);
                    String DFiva = request.getParameter("txtDFiva");
                    detSal.setDFiva(Float.parseFloat(DFiva));
                    String DFvalorUnitario = request.getParameter("txtDFvalorUnitario");
                    detSal.setDFvalorUnitario(Double.parseDouble(DFvalorUnitario));
                    detSal.setDFvalorTotal(detSal.getDFvalorUnitario() * detSal.getDFcantidadInsumo());
                    Insumo nombre = insDao.listarId(DFinsumoFK);
                    detSal.setNombreInsumo(nombre.getInsumoNombre());

                    if (listaDS == null) {
                        listaDS = new ArrayList<DetalleSalida>();
                    }
                    listaDS.add(detSal);
                    detSal = new DetalleSalida();
                    session.setAttribute("listaDS", listaDS);
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;

                case "Vaciar":
                    if (session.getAttribute("Salida") != null) {
                        session.invalidate();
                    }
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;

                case "Quitar":
                    String id = request.getParameter("idQu");
                    listaDS.remove(Integer.parseInt(id));
                    session.setAttribute("listaDS", listaDS);
                    request.getRequestDispatcher("EntradaInsumoControl?menu=EntradaInsumo&accion=Listar").forward(request, response);
                    break;
                case "Guardar":
                    Salida SalidaGuardar = (Salida) session.getAttribute("Salida");
                   if(SalDao.agregar(SalidaGuardar)==1){
                     
                    for (int i = 0; i < listaDS.size(); i++) {
                      detSal = new DetalleSalida();
                      detSal.setDFSalidaFK(SalidaGuardar.getIdSalida());
                      detSal.setDFinsumoFK(listaDS.get(i).getDFinsumoFK());
                      detSal.setDFcantidadInsumo(listaDS.get(i).getDFcantidadInsumo());
                      detSal.setDFlote(listaDS.get(i).getDFlote());
                      detSal.setDFfechaVence(listaDS.get(i).getDFfechaVence());
                      detSal.setDFinvima(listaDS.get(i).getDFinvima());
                      detSal.setDFiva(listaDS.get(i).getDFiva());
                      detSal.setDFvalorUnitario(listaDS.get(i).getDFvalorUnitario());
                      detSal.setDFvalorTotal(listaDS.get(i).getDFvalorTotal());
                      detSalDao.agregar(detSal);
                    }
                   }
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
