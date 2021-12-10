/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Actor;
import Modelo.Elenco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Elenco_DAO {
    public int Registrar(Elenco elenco)
    {
        int ID_Elenco=-1;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL E_INSERT('"+elenco.getNombres()+"','"+elenco.getApellidos()+"');";
        try{
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();  
            if(rs.next())
            { 
                return ID_Elenco =rs.getInt(1);
            }
            else return ID_Elenco =-1;
        }
        catch (Exception e) {
            return -1;
        }
    }
    
    public boolean Actualizar(Elenco elenco)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL E_ACTUALIZAR('"+elenco.getID()+"','"+elenco.getNombres()+"','"+elenco.getApellidos()+"');";
        try{
            ps=con.prepareStatement(sql);
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
