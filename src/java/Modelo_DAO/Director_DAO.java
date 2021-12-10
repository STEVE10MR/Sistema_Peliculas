/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Actor;
import Modelo.Director;
import Modelo.Elenco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author USUARIO
 */
public class Director_DAO {
    public boolean Registrar(Director director)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL D_INSERT(?);";
        try{
            Elenco_DAO ed=new Elenco_DAO();
            int ID_E=ed.Registrar(director.getElenco());
            if(ID_E!=-1)
            {
                ps=con.prepareStatement(sql);
                ps.setInt(1,ID_E);
                int fa=ps.executeUpdate();
                if(fa>0)
                {
                    return true;
                }
                else return false;
            }
            else return false;
            
        }
        catch (Exception e) {
            return false;
        }
    }
    public ArrayList<Director> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL D_LIS();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Director> list_d=new ArrayList<Director>();
            while(resultado.next())
            {
                Elenco e=new Elenco();
                Director d=new Director();
                e.setID(resultado.getInt(1));
                e.setNombres(resultado.getString(2));
                e.setApellidos(resultado.getString(3));
                d.setElenco(e);
                list_d.add(d);
            }
            return list_d;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Director> Buscar(String Busqueda)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL D_BUSCAR(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Busqueda);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Director> list_d=new ArrayList<Director>();
            while(resultado.next())
            {
                Elenco e=new Elenco();
                Director d=new Director();
                e.setID(resultado.getInt(1));
                e.setNombres(resultado.getString(2));
                e.setApellidos(resultado.getString(3));
                d.setElenco(e);
                list_d.add(d);
            }
            return list_d;
        }
        catch (Exception e) {
            return null;
        }
    }
}
