/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Pelicula;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Alquiler_DAO {
    public int Registrar(Alquiler alquiler)
    {
        int ID=-1;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL ALQ_REG(?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1,alquiler.getValor());
            ps.setInt(2,alquiler.getCliente().getUsuario().getID());
            ps.setInt(3,alquiler.getPelicula().getID());
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery(); 
            if(rs.next())
            { 
                ID=rs.getInt(1);
            }
            else ID =-1;
            return ID;
        }
        catch (Exception e) {
            return -1;
        }
    }
    public ArrayList<Alquiler> Listar(String Busqueda)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL ALQ_LIS(?);";
        try{
            ps=con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Alquiler> list_a=new ArrayList<Alquiler>();
            while(resultado.next())
            {
                Usuario u=new Usuario();
                u.setNombre(resultado.getString(1));
                u.setApellido(resultado.getString(2));
                Pelicula p=new Pelicula();
                p.setNombre(resultado.getString(3));
                Alquiler a=new Alquiler();
                a.setFecha_Inicio(resultado.getDate(4));
                a.setFecha_Fin(resultado.getDate(5));
                
                Cliente c=new Cliente();
                c.setUsuario(u);
               
                a.setPelicula(p);
                a.setCliente(c);
                list_a.add(a);
            }
            return list_a;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Alquiler> Buscar(String Busqueda)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL ALQ_BUSC(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Busqueda);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Alquiler> list_a=new ArrayList<Alquiler>();
            while(resultado.next())
            {
                Usuario u=new Usuario();
                u.setNombre(resultado.getString(1));
                u.setApellido(resultado.getString(2));
                Pelicula p=new Pelicula();
                p.setNombre(resultado.getString(3));
                Alquiler a=new Alquiler();
                a.setFecha_Inicio(resultado.getDate(4));
                a.setFecha_Fin(resultado.getDate(5));
                
                Cliente c=new Cliente();
                c.setUsuario(u);
               
                a.setPelicula(p);
                a.setCliente(c);
                list_a.add(a);
            }
            return list_a;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    
}
