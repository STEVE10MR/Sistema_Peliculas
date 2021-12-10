/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Detalle_Director;
import Modelo.Detalle_Factura;
import Modelo.Detalle_Genero;
import Modelo.Detalle_Idioma;
import Modelo.Director;
import Modelo.Elenco;
import Modelo.Genero;
import Modelo.Idioma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Detalle_Genero_DAO {
   public boolean Registrar(Detalle_Genero detallegenero)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DG_INSERT(?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,detallegenero.getPelicula().getID());
            ps.setInt(2,detallegenero.getGenero().getID());
            return ps.execute();
        }
        catch (Exception e) {
            return false;
        }
    } 
    public ArrayList<Detalle_Genero> Informacion(int ID_P)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DG_INFO(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_P);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Detalle_Genero> list_dg=new ArrayList<>();
            while(resultado.next())
            {
                Genero g=new Genero();
                Detalle_Genero dg=new Detalle_Genero();
                
                g.setNombre(resultado.getString(1));
                dg.setGenero(g);
                list_dg.add(dg);
            }
            return list_dg;
        }
        catch (SQLException e) {
            return null;
        }
    }
}
