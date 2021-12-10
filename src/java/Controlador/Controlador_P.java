/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Pelicula;
import Modelo_DAO.Pelicula_DAO;
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
public class Controlador_P extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String Pelicula="Vistas/Peliculas.jsp";
    String Pelicula_Reciente="Vistas/Pelicula_Reciente.jsp";
    String Pelicula_Informacion="Vistas/Pelicula_Info.jsp";
    String Pelicula_Principal="Vistas/Pelicula_Principal.jsp";
    String Pelicula_Registrar="Vistas/Pelicula_Registrar.jsp";
    String Pelicula_Actualizar="Vistas/Pelicula_Actualizar.jsp";
    String Principal="Principal.jsp";
    String Subir_Imagen="php/subir-imagen.php";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_P</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_P at " + request.getContextPath() + "</h1>");
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
        if(action.equalsIgnoreCase("listar"))
        {
            acceso=Pelicula;
        }
        else if(action.equalsIgnoreCase("listar_reciente"))
        {
            acceso=Pelicula_Reciente;
        }
        else if(action.equalsIgnoreCase("principal"))
        {
            acceso=Pelicula_Principal;
        }
        else if(action.equalsIgnoreCase("registrar"))
        {
            acceso=Pelicula_Registrar;
        }
        else if(action.equalsIgnoreCase("subir_imagen"))
        {
            acceso=Subir_Imagen;
        }
        else if(action.equalsIgnoreCase("actualizar"))
        {
            acceso=Pelicula_Actualizar;
        }
        else if(action.equalsIgnoreCase("informacion"))
        {
            int ID_Pelicula=Integer.valueOf(request.getParameter("id"));
            Pelicula_DAO pelicula=new Pelicula_DAO();
            Pelicula _pelicula=pelicula.Informacion(ID_Pelicula);
            if(_pelicula!=null)
            {
                request.setAttribute("Id_pelicula",_pelicula.getID());
                request.setAttribute("Imagen",_pelicula.getImagen());
                request.setAttribute("Nombre",_pelicula.getNombre());
                request.setAttribute("FechaEstreno",_pelicula.getFechaEstreno());
                request.setAttribute("Duracion",_pelicula.getDuracion());
                request.setAttribute("Descripcion",_pelicula.getDescripcion());
                request.setAttribute("Valor",_pelicula.getValor());
                request.setAttribute("Calificacion",_pelicula.getClasificacion().getNombre());
                acceso=Pelicula_Informacion;
            }
            else acceso=Pelicula_Informacion;
        }
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
        if(action.equalsIgnoreCase("subir"))
        {
            acceso=Subir_Imagen;
        }
        else acceso=Pelicula;
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
