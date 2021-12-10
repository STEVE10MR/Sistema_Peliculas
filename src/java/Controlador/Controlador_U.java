/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Usuario;
import Modelo_DAO.Cliente_DAO;
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
public class Controlador_U extends HttpServlet {
    String Configuracion_Actualizar="Vistas/Configracion_Actualizar.jsp";
    String Configuracion_Ayuda="Vistas/Configuracion_Ayuda.jsp";
    String Configuracion_Modificar="Vistas/Configuracion_Modificar.jsp";
    String Configuracion="Vistas/Configuracion.jsp";
    String Registrar="Vistas/Registro_Usuario.jsp";
    String Principal="Vistas/Principal.jsp";
    String Index="index.jsp";
    String Cliente_Principal="Vistas/Cliente_Principal.jsp";
    String Mantenimiento="Vistas/Mantenimiento.jsp";
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
            out.println("<title>Servlet Controlador_U</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_U at " + request.getContextPath() + "</h1>");
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
        if(action.equalsIgnoreCase("configuracion"))
        {
            acceso=Configuracion;
        }
        else if(action.equalsIgnoreCase("ayuda"))
        {
            acceso=Configuracion_Ayuda;
        }
        else if(action.equalsIgnoreCase("cerrarsession"))
        {
            acceso=Index;
        }
        else if(action.equalsIgnoreCase("modificar"))
        {
            acceso=Configuracion_Modificar;
        }
        else if(action.equalsIgnoreCase("actualizar"))
        {
            
            acceso=Configuracion_Actualizar;
        }
        else if(action.equalsIgnoreCase("Activar"))
        {
            String ID_Usuario=request.getParameter("id");

            if(ID_Usuario!=null)
            {
                Usuario_DAO _usuario=new Usuario_DAO();
                if(_usuario.Activar_Estado(Integer.valueOf(ID_Usuario)))
                {
                    acceso=Cliente_Principal;
                }
                else acceso=Mantenimiento;
            }
            else acceso=Mantenimiento;
        }
        
        
        else if(action.equalsIgnoreCase("Desactivar"))
        {
            String ID_Usuario=request.getParameter("id");

            if(ID_Usuario!=null)
            {
                Usuario_DAO _usuario=new Usuario_DAO();
                if(_usuario.Desactivar_Estado(Integer.valueOf(ID_Usuario)))
                {
                    acceso=Cliente_Principal;
                }
                else acceso=Mantenimiento;
            }
            else acceso=Mantenimiento;
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
        
        if(action.equalsIgnoreCase("Actualizar"))
        {
            String ID_Usuario=request.getParameter("id");
            String nombre=request.getParameter("txtnnombre");
            String apellido=request.getParameter("txtnpellido");
            if(ID_Usuario!=null && nombre!=null && apellido!=null)
            {
                Usuario_DAO _usuario=new Usuario_DAO();
                Usuario usuario=new Usuario();
                usuario.setID(Integer.valueOf(ID_Usuario));
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                if(_usuario.Actualizar(usuario))
                {
                    acceso=Principal;
                }
                else acceso=Configuracion;
            }
            else acceso=Configuracion;
        }
        
        
        else if(action.equalsIgnoreCase("Modificar"))
        {
            String ID_Usuario=request.getParameter("id");
            String i_n_contra=request.getParameter("txtcontra");
            String n_n_contra=request.getParameter("txtnuevacontra");
            String c_n_contra=request.getParameter("txtconfcontra");
           
            
            if(i_n_contra!=null && n_n_contra!=null && c_n_contra!=null && (c_n_contra.equals(n_n_contra)) )
            {
                Usuario_DAO _usuario=new Usuario_DAO();
                Usuario usuario=new Usuario();
                usuario.setID(Integer.valueOf(ID_Usuario));
                usuario.setContrasenia(i_n_contra);
                if(_usuario.Actualizar_Contrasenia(usuario,n_n_contra))
                {
                    acceso=Principal;
                }
                else acceso=Configuracion;
            }
            else acceso=Configuracion;
        }
        

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
