/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Cliente;
import Modelo.Genero;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Genero_DAO {
    public boolean Registrar(Genero genero)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL G_INSERT(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,genero.getNombre());
            int fa=ps.executeUpdate();
            if(fa>0)
            {
                return true;
            }
            else return false;
        }
        catch (Exception e) {
            return false;
        }
    } 
    public ArrayList<Genero> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
  
        String sql="CALL G_LISTAR();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Genero> ls_g=new ArrayList<Genero>();
            while(rs.next())
            {
                Genero g=new Genero();
                g.setID(rs.getInt(1));
                g.setNombre(rs.getString(2));
                ls_g.add(g);
            }
            return ls_g;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Genero> Buscar(String Buscar)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
  
        String sql="CALL G_BUSCAR(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Buscar);
            ResultSet rs = ps.executeQuery();
            ArrayList<Genero> ls_g=new ArrayList<Genero>();
            while(rs.next())
            {
                Genero g=new Genero();
                g.setID(rs.getInt(1));
                g.setNombre(rs.getString(2));
                ls_g.add(g);
            }
            return ls_g;
        }
        catch (Exception e) {
            return null;
        }
    }
    public boolean Actualizar(Genero genero)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL G_UCT(?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,genero.getID());
            ps.setString(2,genero.getNombre());
            int fa=ps.executeUpdate();
            if(fa>0)
            {
                return true;
            }
            else return false;
        }
        catch (Exception e) {
            return false;
        }
    }
}
