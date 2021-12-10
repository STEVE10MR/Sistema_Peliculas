/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Detalle_Director;
import Modelo.Director;
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
public class Detalle_Director_DAO {
    public boolean Registrar(Detalle_Director detalledirector) throws SQLException
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DD_REG(?,?);";
        try{
            
            ps=con.prepareStatement(sql);
            ps.setInt(1, detalledirector.getPelicula().getID());
            ps.setInt(2,detalledirector.getDirector().getID());
            int fa=ps.executeUpdate();
            if(fa>0)
            {
                return true;
            }
            else return false;
        }
        catch (SQLException e) {
            return false;
        }
        
    }
    public ArrayList<Detalle_Director> LeerID(int ID_P)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DD_INFO(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_P);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Detalle_Director> list_da=new ArrayList<>();
            while(resultado.next())
            {
                Elenco e=new Elenco();
                Detalle_Director dd=new Detalle_Director();
                Director d=new Director();
                e.setNombres(resultado.getString(1));
                e.setApellidos(resultado.getString(2));
                d.setElenco(e);
                dd.setDirector(d);
                list_da.add(dd);
            }
            return list_da;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
