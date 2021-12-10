/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Genero;
import Modelo.Idioma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Idioma_DAO {
    public boolean Registrar(Idioma idioma)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL I_INSERT(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,idioma.getNombre());
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
    public ArrayList<Idioma> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
  
        String sql="CALL I_LISTAR();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Idioma> ls_i=new ArrayList<Idioma>();
            while(rs.next())
            {
                Idioma i=new Idioma();
                i.setID(rs.getInt(1));
                i.setNombre(rs.getString(2));
                ls_i.add(i);
            }
            return ls_i;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Idioma> Buscar(String Buscar)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
  
        String sql="CALL I_BUSCAR(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Buscar);
            ResultSet rs = ps.executeQuery();
            ArrayList<Idioma> ls_i=new ArrayList<Idioma>();
            while(rs.next())
            {
                Idioma i=new Idioma();
                i.setID(rs.getInt(1));
                i.setNombre(rs.getString(1));
                ls_i.add(i);
            }
            return ls_i;
        }
        catch (Exception e) {
            return null;
        }
    }
    public boolean Actualizar(Idioma idioma)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL I_UCT(?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,idioma.getID());
            ps.setString(2,idioma.getNombre());
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
