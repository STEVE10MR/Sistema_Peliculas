/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Genero;
import Modelo.Idioma;
import Modelo_DAO.Genero_DAO;
import Modelo_DAO.Idioma_DAO;
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
public class Controlador_I extends HttpServlet {
    
    String Principal="Vistas/Principal.jsp";
    String Idioma_Principal="Vistas/Idioma_Principal.jsp";
    String Idioma_Registrar="Vistas/Idioma_Registrar.jsp";
    String Idioma_Actualizar="Vistas/Idioma_Actualizar.jsp";
    String Mantenimiento="Vistas/Mantenimiento.jsp";
    String Idioma_Buscar="Vistas/Idioma_Buscar.jsp";
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
            out.println("<title>Servlet Controlador_I</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_I at " + request.getContextPath() + "</h1>");
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
            acceso=Idioma_Principal;
        }
        else if(action.equalsIgnoreCase("busqueda"))
        {
            String Buscar=request.getParameter("txtbuscar");
            request.setAttribute("buscar",Buscar);
            acceso=Idioma_Buscar;
        }
        else if(action.equalsIgnoreCase("registrar"))
        {
            acceso=Idioma_Registrar;
        }
        else if(action.equalsIgnoreCase("actualizar"))
        {
            String Id=request.getParameter("id");
            request.setAttribute("Id",Id);
            acceso=Idioma_Actualizar;
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
            if(nombre!=null)
            {
                Idioma_DAO _idioma=new Idioma_DAO();
                Idioma idioma=new Idioma();
                idioma.setNombre(nombre);
                if(_idioma.Registrar(idioma))
                {
                    acceso=Idioma_Principal;
                }
                else acceso=Mantenimiento;
            }
            else acceso=Mantenimiento;
        }
        else if(action.equalsIgnoreCase("Update"))
        {
            String ID=request.getParameter("id");
            String nombre=request.getParameter("txtnombre");
            if(ID!=null && nombre!=null)
            {
                Idioma_DAO _idioma=new Idioma_DAO();
                Idioma idioma=new Idioma();
                idioma.setID(Integer.valueOf(ID));
                idioma.setNombre(nombre);
                if(_idioma.Actualizar(idioma))
                {
                    acceso=Idioma_Principal;
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
