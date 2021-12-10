/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Clasificacion;
import Modelo.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Clasificacion_DAO {
    public boolean Registrar(Clasificacion clasificacion)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL CL_REG(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,clasificacion.getNombre());
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
    public ArrayList<Clasificacion> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
  
        String sql="CALL CL_LIS();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Clasificacion> ls_c=new ArrayList<Clasificacion>();
            while(rs.next())
            {
                Clasificacion c=new Clasificacion();
                c.setID(rs.getInt(1));
                c.setNombre(rs.getString(2));
                ls_c.add(c);
            }
            return ls_c;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Clasificacion> Buscar(String Buscar)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
  
        String sql="CALL CL_BUSC(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Buscar);
            ResultSet rs = ps.executeQuery();
            ArrayList<Clasificacion> ls_c=new ArrayList<Clasificacion>();
            while(rs.next())
            {
                Clasificacion c=new Clasificacion();
                c.setID(rs.getInt(1));
                c.setNombre(rs.getString(2));
                ls_c.add(c);
            }
            return ls_c;
        }
        catch (Exception e) {
            return null;
        }
    }
    public boolean Actualizar(Clasificacion clasificacion)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL CL_UCT(?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,clasificacion.getID());
            ps.setString(2,clasificacion.getNombre());
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
