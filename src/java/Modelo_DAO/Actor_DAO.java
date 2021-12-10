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
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Actor_DAO{
    public boolean Registrar(Actor actor)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL A_INSERT(?);";
        try{
            Elenco_DAO ed=new Elenco_DAO();
            int ID_E=ed.Registrar(actor.getElenco());
            if(ID_E!=-1)
            {
                ps=con.prepareStatement(sql);
                ps.setInt(1,ID_E);
                int f=ps.executeUpdate();
                if(f>0) return true;
                else return false;
            }
            else return false;
            
        }
        catch (Exception e) {
            return false;
        }
    }
    public ArrayList<Actor> Buscar(String Busqueda)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL A_BUSCAR(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Busqueda);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Actor> list_a=new ArrayList<Actor>();
            while(resultado.next())
            {
                Elenco e=new Elenco();
                Actor a=new Actor();
                e.setID(resultado.getInt(1));
                e.setNombres(resultado.getString(2));
                e.setApellidos(resultado.getString(3));
                a.setElenco(e);
                list_a.add(a);
            }
            return list_a;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Actor> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL A_LIS();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Actor> list_a=new ArrayList<Actor>();
            while(resultado.next())
            {
                Elenco e=new Elenco();
                Actor a=new Actor();
                e.setID(resultado.getInt(1));
                e.setNombres(resultado.getString(2));
                e.setApellidos(resultado.getString(3));
                a.setElenco(e);
                list_a.add(a);
            }
            return list_a;
        }
        catch (Exception e) {
            return null;
        }
    }
}
