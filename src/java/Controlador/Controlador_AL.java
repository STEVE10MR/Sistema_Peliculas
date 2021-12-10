/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Pelicula;
import Modelo.Usuario;
import Modelo_DAO.Alquiler_DAO;
import Modelo_DAO.Usuario_DAO;
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
public class Controlador_AL extends HttpServlet {
    
    String Principal="Vistas/Principal.jsp";
    String Factura_Registrar="Vistas/Factura_Registrar.jsp";
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
            out.println("<title>Servlet Controlador_AL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_AL at " + request.getContextPath() + "</h1>");
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
            String ID_P=request.getParameter("id_pelicula");
            String ID_U=request.getParameter("id_usuario");
            
            if(Valor!=null && ID_P!=null && ID_U!=null )
            {
                Alquiler_DAO obj_alquiler=new Alquiler_DAO();
                Alquiler alquiler=new Alquiler();
                Pelicula pelicula=new Pelicula();
                Cliente cliente=new Cliente();
                Usuario usuario=new Usuario();
                pelicula.setID(Integer.valueOf(ID_P));
                usuario.setID(Integer.valueOf(ID_U));
                cliente.setUsuario(usuario);
                alquiler.setPelicula(pelicula);
                alquiler.setCliente(cliente);
                alquiler.setValor(Double.valueOf(Valor));
                int ID_Alquiler=obj_alquiler.Registrar(alquiler);
                if(ID_Alquiler!=-1)
                {
                    request.setAttribute("id",ID_Alquiler);
                    acceso=Factura_Registrar;
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
