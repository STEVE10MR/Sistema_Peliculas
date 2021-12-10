/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Actor;
import Modelo.Detalle_Actor;
import Modelo.Elenco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Detalle_Actor_DAO {
    
    public boolean Registrar(Detalle_Actor detalleactor) throws SQLException
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DA_REG(?,?);";
        try{
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,detalleactor.getPelicula().getID());
            ps.setInt(2,detalleactor.getActor().getID());
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
    public ArrayList<Detalle_Actor> LeerID(int ID_P)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DA_INFO(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_P);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Detalle_Actor> list_da=new ArrayList<Detalle_Actor>();
            while(resultado.next())
            {
                Elenco e=new Elenco();
                Detalle_Actor da=new Detalle_Actor();
                Actor a=new Actor();
                e.setNombres(resultado.getString(1));
                e.setApellidos(resultado.getString(2));
                a.setElenco(e);
                da.setActor(a);
                list_da.add(da);
            }
            return list_da;
        }
        catch (Exception e) {
            return null;
        }
    }
}
