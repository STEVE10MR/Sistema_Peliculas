/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Detalle_Idioma;
import Modelo.Factura;
import Modelo.Pelicula;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Factura_DAO {
    public int Registrar(Factura factura)
    {
        int ID=-1;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL FAC_REG(?,?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1,factura.getValoe());
            ps.setDouble(2,factura.getTotal());
            ps.setInt(3,factura.getAlquiler().getID());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            { 
                ID =rs.getInt(1);
            }
            else ID =-1;
            return ID;
        }
        catch (Exception e) {
            return -1;
        }
    }
    public ArrayList<Factura> Busqueda_Fecha(String fecha)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL FAC_BUSC_FECHA(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,fecha);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Factura> list_f=new ArrayList<Factura>();
            while(resultado.next())
            {
                Factura f=new Factura();
                f.setID(resultado.getInt(1));
                f.setFecha(resultado.getDate(2));
                f.setValoe(resultado.getDouble(3));
                f.setTotal(resultado.getDouble(4));
                f.setIGV(resultado.getDouble(5));
                Alquiler a=new Alquiler();
                Pelicula p=new Pelicula();
                p.setNombre(resultado.getString(5));
                a.setPelicula(p);
                f.setAlquiler(a);
                
                list_f.add(f);
            }
            return list_f;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Factura> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL FAC_LIST_FECHA();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            ArrayList<Factura> list_f=new ArrayList<Factura>();
            while(resultado.next())
            {
                Factura f=new Factura();
                f.setID(resultado.getInt(1));
                f.setFecha(resultado.getDate(2));
                f.setValoe(resultado.getDouble(3));
                f.setTotal(resultado.getDouble(4));
                f.setIGV(resultado.getDouble(6));
                Alquiler a=new Alquiler();
                Pelicula p=new Pelicula();
                p.setNombre(resultado.getString(5));
                a.setPelicula(p);
                f.setAlquiler(a);
                list_f.add(f);
            }
            return list_f;
        }
        catch (Exception e) {
            return null;
        }
    }
}
