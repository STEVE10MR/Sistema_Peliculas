/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Alquiler;
import Modelo.Clasificacion;
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
public class Pelicula_DAO{
    public ArrayList<Pelicula> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_LISTA();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Pelicula> list_p=new ArrayList<Pelicula>();
            while(resultado.next())
            {
               
                Pelicula p=new Pelicula();
                p.setID(resultado.getInt(1));
                p.setImagen(resultado.getString(2));
                p.setNombre(resultado.getString(3));
                list_p.add(p);
            }
            return list_p;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Pelicula> Listar_Busqueda(String Busqueda)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_BUSC(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, Busqueda);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Pelicula> list_p=new ArrayList<Pelicula>();
            while(resultado.next())
            {
               
                Pelicula p=new Pelicula();
                p.setID(resultado.getInt(1));
                p.setImagen(resultado.getString(2));
                p.setNombre(resultado.getString(3));
                list_p.add(p);
            }
            return list_p;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Pelicula> Listar_Recientes()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_RECIEN();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Pelicula> list_p=new ArrayList<Pelicula>();
            while(resultado.next())
            {
               
                Pelicula p=new Pelicula();
                p.setID(resultado.getInt(1));
                p.setImagen(resultado.getString(2));
                p.setNombre(resultado.getString(3));
                list_p.add(p);
            }
            return list_p;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Pelicula> Listar_Genero(int ID_Genero)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_GEN(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ID_Genero);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Pelicula> list_p=new ArrayList<Pelicula>();
            while(resultado.next())
            {
                Pelicula p=new Pelicula();
                p.setID(resultado.getInt(1));
                p.setImagen(resultado.getString(2));
                p.setNombre(resultado.getString(3));
                list_p.add(p);
            }
            return list_p;
        }
        catch (Exception e) {
            return null;
        }
    }
    public int Registrar(Pelicula pelicula)
    {
        int ID=-1;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_REG(?,?,?,?,?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,pelicula.getNombre());
            ps.setDate(2,pelicula.getFechaEstreno());
            ps.setInt(3,pelicula.getDuracion());
            ps.setInt(4,pelicula.getClasificacion().getID());
            ps.setDouble(5,pelicula.getValor());
            ps.setString(6,pelicula.getImagen());
            ps.setString(7,pelicula.getDescripcion());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            { 
                ID =rs.getInt(1);
            }
            else ID =-1;
            return ID;
        }
        catch (Exception e) {
            return -1;
        }
    }
    public boolean Actualizar(Pelicula pelicula)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_REG(?,?,?,?,?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,pelicula.getID());
            ps.setString(2,pelicula.getNombre());
            ps.setDate(3,pelicula.getFechaEstreno());
            ps.setInt(4,pelicula.getDuracion());
            ps.setInt(5,pelicula.getClasificacion().getID());
            ps.setDouble(5,pelicula.getValor());
            ps.setString(6,pelicula.getDescripcion());
            return ps.execute();
        }
        catch (Exception e) {
            return false;
        }
    }
    public Pelicula Informacion(int ID_PELICULA)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL P_INFO(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_PELICULA);
            ResultSet resultado=ps.executeQuery();
            Pelicula p=new Pelicula();
            while(resultado.next())
            {
                p.setID(resultado.getInt(1));
                p.setFechaEstreno(resultado.getDate(2));
                p.setDuracion(resultado.getInt(3));
                p.setImagen(resultado.getString(4));
                p.setNombre(resultado.getString(5));
                p.setDescripcion(resultado.getString(6));
                p.setValor(resultado.getDouble(7));
                Clasificacion c=new Clasificacion();
                c.setNombre(resultado.getString(8));
                p.setClasificacion(c);
            }
            return p;
        }
        catch (Exception e) {
            return null;
        }
    }
}
