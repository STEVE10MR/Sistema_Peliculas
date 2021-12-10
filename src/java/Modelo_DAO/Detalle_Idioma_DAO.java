/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Detalle_Director;
import Modelo.Detalle_Genero;
import Modelo.Detalle_Idioma;
import Modelo.Director;
import Modelo.Elenco;
import Modelo.Idioma;
import Modelo.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Detalle_Idioma_DAO {
    public boolean Registrar(Detalle_Idioma detalleidioma)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DI_INSERT(?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,detalleidioma.getPelicula().getID());
            ps.setInt(2,detalleidioma.getIdioma().getID());
            return ps.execute();
        }
        catch (Exception e) {
            return false;
        }
    } 
    public ArrayList<Detalle_Idioma> Informacion(int ID_P)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DI_INFO(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_P);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Detalle_Idioma> list_dd=new ArrayList<>();
            while(resultado.next())
            {
                Idioma i=new Idioma();
                Detalle_Idioma di=new Detalle_Idioma();
                
                i.setNombre(resultado.getString(1));
                di.setIdioma(i);
                list_dd.add(di);
            }
            return list_dd;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
