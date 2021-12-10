/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Actor;
import Modelo.Elenco;
import Modelo.Usuario;
import Modelo_DAO.Actor_DAO;
import Modelo_DAO.Elenco_DAO;
import Modelo_DAO.Usuario_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Controlador_A extends HttpServlet {
    String Principal="Vistas/Principal.jsp";
    String Actor_Principal="Vistas/Actor_Principal.jsp";
    String Actor_Registrar="Vistas/Actor_Registrar.jsp";
    String Actor_Actualizar="Vistas/Actor_Actualizar.jsp";
    String Mantenimiento="Vistas/Mantenimiento.jsp";
    String Actor_Buscar="Vistas/Actor_Buscar.jsp";
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
            out.println("<title>Servlet Controlador_A</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_A at " + request.getContextPath() + "</h1>");
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
            acceso=Actor_Principal;
        }
        else if(action.equalsIgnoreCase("registrar"))
        {
            acceso=Actor_Registrar;
        }
        else if(action.equalsIgnoreCase("actualizar"))
        {
            String Id=request.getParameter("id");
            request.setAttribute("Id",Id);
            acceso=Actor_Actualizar;
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
        if(action.equalsIgnoreCase("Add"))
        {
            String nombre=request.getParameter("txtnombre");
            String apellido=request.getParameter("txtapellido");
            if(nombre!=null && apellido!=null)
            {
                Actor_DAO _actor=new Actor_DAO();
                Actor actor=new Actor();
                Elenco elenco=new Elenco();
                elenco.setNombres(nombre);
                elenco.setApellidos(apellido);
                actor.setElenco(elenco);
                if(_actor.Registrar(actor))
                {
                    acceso=Actor_Principal;
                }
                else acceso=Mantenimiento;
            }
            else acceso=Mantenimiento;
        }
        else if(action.equalsIgnoreCase("Update"))
        {
            String ID=request.getParameter("id");
            String nombre=request.getParameter("txtnombre");
            String apellido=request.getParameter("txtapellido");
            if(ID!=null && nombre!=null && apellido!=null)
            {
                Elenco_DAO _elenco=new Elenco_DAO();
                Elenco elenco=new Elenco();
                elenco.setID(Integer.valueOf(ID));
                elenco.setNombres(nombre);
                elenco.setApellidos(apellido);
                if(_elenco.Actualizar(elenco))
                {
                    acceso=Actor_Principal;
                }
                else acceso=Mantenimiento;
            }
            else acceso=Mantenimiento;
        }
        else acceso=Mantenimiento;
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
