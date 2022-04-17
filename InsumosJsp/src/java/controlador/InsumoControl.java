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
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.Marca;
import modelo.MarcaDao;
import modelo.Riesgo;
import modelo.RiesgoDao;
import modelo.Presentacion;
import modelo.PresentacionDao;
import modelo.Temperatura;
import modelo.TemperaturaDao;
import modelo.Insumo;
import modelo.InsumoDao;

/**
 *
 * @author serdn
 */
public class InsumoControl extends HttpServlet {

    InsumoDao eleDao = new InsumoDao();
    Insumo ins = new Insumo();
    PresentacionDao preDao = new PresentacionDao();
    Presentacion pre = new Presentacion();
    MarcaDao marDao = new MarcaDao();
    Marca mar = new Marca();
    RiesgoDao rieDao = new RiesgoDao();
    Riesgo rie = new Riesgo();
    TemperaturaDao temDao = new TemperaturaDao();
    Temperatura tem = new Temperatura();
    String idEleme;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu.equals("Insumo")) {
            switch (accion) {
                case "Listar":
                    List lista = eleDao.listar();
                    List listamar = marDao.listar();
                    List listarie = rieDao.listar(); 
                    List listapre = preDao.listar();
                    List listatem = temDao.listar();

                    request.setAttribute("InsumoLista", lista);
                    request.setAttribute("MarcaLista", listamar);
                    request.setAttribute("RiesgoLista", listarie);
                    request.setAttribute("PresentacionLista", listapre);
                    request.setAttribute("TemperaturaLista", listatem);
                    
                    break;
                case "Agregar":
                    String CodigoInsumo = request.getParameter("txtCodigoInsumo");
                    String InsumoNombre = request.getParameter("txtInsumoNombre");
                    String InsumoMarcaFK = request.getParameter("txtInsumoMarcaFK");
                    String InsumoRiesgoFK = request.getParameter("txtInsumoRiesgoFK");
                    String InsumoPresentacionFK = request.getParameter("txtInsumoPresentacionFK");
                    String InsumoObservacion = request.getParameter("txtInsumoObservacion");
                    String InsumoExistencia = request.getParameter("txtInsumoExistencia");
                    String InsumoTemperaturaFK = request.getParameter("txtInsumoTemperaturaFK");
                    String InsumoRuta = request.getParameter("txtInsumoRuta");
                    String InsumoInvima = request.getParameter("txtInsumoInvima");
                    String InsumoLote = request.getParameter("txtInsumoLote");
                    String InsumoVence  = request.getParameter("txtInsumoVence");
                    String InsumoFichaTecnica = request.getParameter("txtInsumoFichaTecnica");
                    ins.setCodigoInsumo(CodigoInsumo);
                    ins.setInsumoNombre(InsumoNombre);
                    ins.setInsumoMarcaFK(Integer.parseInt(InsumoMarcaFK));
                    ins.setInsumoRiesgoFK(Integer.parseInt(InsumoRiesgoFK));
                    ins.setInsumoPresentacionFK(Integer.parseInt(InsumoPresentacionFK));
                    ins.setInsumoObservacion(InsumoObservacion);
                    ins.setInsumoExistencia(Integer.parseInt(InsumoExistencia));
                    ins.setInsumoTemperaturaFK(Integer.parseInt(InsumoTemperaturaFK));
                    ins.setInsumoRuta(InsumoRuta);
                    ins.setInsumoInvima(InsumoInvima);
                    ins.setInsumoLote(InsumoLote);
                    Date fecha = formato.parse("2021/06/20 18:15:03");
                    ins.setInsumoVence(FE);
                    ins.setInsumoFichaTecnica(InsumoFichaTecnica);
                    eleDao.agregar(ins);
                    request.getRequestDispatcher("InsumoControl?menu=Insumo&accion=Listar").forward(request, response);
                    break;

                case "Editar":
//                    idEleme = request.getParameter("idEd");
//                    Insumo e = eleDao.listarId(idEleme);
//                    request.setAttribute("Insumo", e);
//                    request.getRequestDispatcher("InsumoControl?menu=Insumo&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
//                    String idInsumo2 = request.getParameter("txtIdInsumo");
//                    String InsumoNombre2 = request.getParameter("txtInsumoNombre");
//                    String InsumoPresentacion2 = request.getParameter("txtInsumoPresentacion");
//                    String InsumoMarca2 = request.getParameter("txtInsumoMarca");
//                    String InsumoCantidad2 = request.getParameter("txtInsumoCantidad");
//                    String InsumoRuta2 = request.getParameter("txtInsumoRuta");
//                    ins.setIdInsumo(idInsumo2);
//                    ins.setInsumoNombre(InsumoNombre2);
//                    ins.setInsumoPresentacion(Integer.parseInt(InsumoPresentacion2));
//                    ins.setInsumoMarca(Integer.parseInt(InsumoMarca2));
//                    ins.setInsumoCantidad(Integer.parseInt(InsumoCantidad2));
//                    ins.setInsumoRuta(InsumoRuta2);
//                    eleDao.actualizar(ele, idEleme);
//                    request.getRequestDispatcher("InsumoControl?menu=Insumo&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
//                    idInsumo = request.getParameter("idEl");
//                    eleDao.eliminar(idInsumo);
//                    request.getRequestDispatcher("InsumoControl?menu=Insumo&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Insumo.jsp").forward(request, response);
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
