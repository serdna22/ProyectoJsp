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
import modelo.Procedimiento;
import modelo.ProcedimientoDao;
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
    ProcedimientoDao proDao = new ProcedimientoDao();
    Procedimiento pro = new Procedimiento();
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
        Usuario usu = (Usuario) request.getSession().getAttribute("usuario");

        if (menu.equals("SalidaInsumo")) {
            switch (accion) {
                case "Listar":
                    List listaCon = conDao.listar();
                    request.setAttribute("ConsultorioLista", listaCon);
                    List listaPro = proDao.listar();
                    request.setAttribute("ProcedimientoLista", listaPro);
                    List listaIns = insDao.listar();
                    request.setAttribute("InsumoLista", listaIns);
                    Salida Sali = (Salida) session.getAttribute("Salida");
                    request.setAttribute("Salida", Sali);
                    request.setAttribute("usuario", usu);
                    break;
                case "Agregar":
                    String IdSalida = request.getParameter("txtIdSalida");                 
                    Salida repetido = SalDao.listarId(IdSalida);
                    if (repetido==null) {
                        Sal.setIdSalida(IdSalida);
                    }else{
                       Sal.setIdSalida("ID REPETIDO"); 
                    }
                    String SalidaConsultorioFK = request.getParameter("txtSalidaConsultorioFK");
                    Sal.setSalidaConsultorioFK(Integer.parseInt(SalidaConsultorioFK));
                    String SalidaProcedimientoFK = request.getParameter("txtSalidaProcedimientoFK");
                    Sal.setSalidaProcedimientoFK(Integer.parseInt(SalidaProcedimientoFK));
                    String SalidaSala = request.getParameter("txtSalidaSala");
                    Sal.setSalidaSala(SalidaSala);
                    String SalidaPersonaRecibio = request.getParameter("txtSalidaPersonaRecibio");
                    Sal.setSalidaPersonaRecibio(SalidaPersonaRecibio);
                    
                    Consultorio nombreCon = conDao.listarId(Integer.parseInt(SalidaConsultorioFK));
                    Sal.setNombreConsultorio(nombreCon.getConsultorioNombre());
                    Procedimiento nombrePro = proDao.listarId(Integer.parseInt(SalidaProcedimientoFK));
                    Sal.setNombreProcedimiento(nombrePro.getProcedimientoNombre());
                    Sal.setSalidaUsuarioFK(usu.getUsuarioDocumento());
                    session.setAttribute("Salida", Sal);

                    String DFinsumoFK = request.getParameter("txtDFinsumoFK");
                    detSal.setDScodigoInsumoFK(DFinsumoFK);

                    String DScantidadInsumo1 = request.getParameter("txtDScantidad");
                    String DScantidadInsumo2 = request.getParameter("txtDScantidad2");
                    int uno = Integer.parseInt(DScantidadInsumo1);
                    int dos = Integer.parseInt(DScantidadInsumo2);
                    detSal.setDScantidad(uno * dos);
                    String DSlote = request.getParameter("txtDSlote");
                    detSal.setDSlote(DSlote);
                    String DSinvima = request.getParameter("txtDSinvima");
                    detSal.setDSinvima(DSinvima);
                    String DSfechaVence = request.getParameter("txtDSfechaVence");
                    detSal.setDSfechaVence(DSfechaVence);
                    Insumo nombre = insDao.listarId(DFinsumoFK);
                    detSal.setNombreInsumo(nombre.getInsumoNombre());

                    if (listaDS == null) {
                        listaDS = new ArrayList<DetalleSalida>();
                    }
                    listaDS.add(detSal);
                    detSal = new DetalleSalida();
                    session.setAttribute("listaDS", listaDS);
                    request.getRequestDispatcher("SalidaInsumoControl?menu=SalidaInsumo&accion=Listar").forward(request, response);
                    break;

                case "Vaciar":
                    if (session.getAttribute("Salida") != null) {
                        session.setAttribute("Salida", null); 
                        session.setAttribute("listaDS", null);
                    }
                    request.getRequestDispatcher("SalidaInsumoControl?menu=SalidaInsumo&accion=Listar").forward(request, response);
                    break;

                case "Quitar":
                    String id = request.getParameter("idQu");
                    listaDS.remove(Integer.parseInt(id));
                    session.setAttribute("listaDS", listaDS);
                    request.getRequestDispatcher("SalidaInsumoControl?menu=SalidaInsumo&accion=Listar").forward(request, response);
                    break;
                case "Guardar":
                    Salida SalidaGuardar = (Salida) session.getAttribute("Salida");
                    if (SalDao.agregar(SalidaGuardar) == 1) {
                        System.out.println("se guardo salida");
                        for (int i = 0; i < listaDS.size(); i++) {
                            detSal = new DetalleSalida();
                            detSal.setDSidSalidaFK(SalidaGuardar.getIdSalida());
                            detSal.setDScodigoInsumoFK(listaDS.get(i).getDScodigoInsumoFK());
                            detSal.setDScantidad(listaDS.get(i).getDScantidad());
                            detSal.setDSlote(listaDS.get(i).getDSlote());
                            detSal.setDSfechaVence(listaDS.get(i).getDSfechaVence());
                            detSal.setDSinvima(listaDS.get(i).getDSinvima());
                            detSalDao.agregar(detSal);
                        }
                    }
                    request.getRequestDispatcher("SalidaInsumoControl?menu=SalidaInsumo&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("SalidaInsumo.jsp").forward(request, response);
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
