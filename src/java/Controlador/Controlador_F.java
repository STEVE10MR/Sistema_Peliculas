/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Pelicula;
import Modelo.Usuario;
import Modelo_DAO.Alquiler_DAO;
import Modelo_DAO.Factura_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Controlador_F extends HttpServlet {
    String Principal="Vistas/Principal.jsp";
    String Factura_Principal="Vistas/Factura_Principal.jsp";
    String Mantenimiento="Vistas/Mantenimiento.jsp";
    String Factura_Buscar="Vistas/Factura_Buscar.jsp";
    String Index="index.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_F</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_F at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("principal"))
        {
            acceso=Factura_Principal;
        }
        else if(action.equalsIgnoreCase("busqueda"))
        {
            String Buscar=request.getParameter("txtbuscar");
            request.setAttribute("buscar",Buscar);
            acceso=Factura_Buscar;
        }
        else acceso=Principal;
        RequestDispatcher vista=request.getRequestDispatcher(acceso); 
        vista.forward(request, response);
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
        String acceso="";
        String action=request.getParameter("accion");
        
        if(action.equalsIgnoreCase("registrar"))
        {
            String Valor=request.getParameter("valor");
            String ID_Al=request.getParameter("id_alquiler");
       
            
            if(Valor!=null && ID_Al!=null)
            {
                Factura_DAO obj_factura=new Factura_DAO();
                Factura factura=new Factura();
                Alquiler alquiler=new Alquiler();
                factura.setTotal(0.18*Double.valueOf(Valor));
                factura.setIGV(0.18);
                factura.setValoe(Double.valueOf(Valor));
                alquiler.setID(Integer.valueOf(ID_Al));
                factura.setAlquiler(alquiler);
                
                int ID_Factura=obj_factura.Registrar(factura);
                if(ID_Factura!=-1)
                {
                    request.setAttribute("id",ID_Factura);
                    acceso=Mantenimiento;
                }
                else acceso=Principal;

            }
            else acceso=Principal;
        }
        else acceso=Index;
        RequestDispatcher vista=request.getRequestDispatcher(acceso); 
        vista.forward(request, response);
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
