/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Cliente;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Cliente_DAO  {
    public boolean Registrar(Cliente cliente)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        
        try{
            Usuario_DAO u=new Usuario_DAO();
            int ID_U=u.Registrar(cliente.getUsuario());
            if(ID_U>-1)
            {
                String sql="CALL CT_REG("+ID_U+");";
                ps=con.prepareStatement(sql);
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
    
    public ArrayList<Cliente> Listar()
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        ArrayList<Cliente> ls_c=new ArrayList<Cliente>();
        String sql="CALL CT_LIS();";
        try{
            ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Usuario u=new Usuario();
                Cliente c=new Cliente();
                u.setID(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setCorrego(rs.getString(4));
                u.setEstado(rs.getInt(5));
                c.setUsuario(u);
                ls_c.add(c);
            }
            return ls_c;
        }
        catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Cliente> Buscar(String Buscar)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        ArrayList<Cliente> ls_c=new ArrayList<Cliente>();
        String sql="CALL CT_BUSC(?);";
        try{
            ps.setString(1,Buscar);
            ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Usuario u=new Usuario();
                Cliente c=new Cliente();
                c.setID_Cliente(rs.getInt(1));
                u.setID(rs.getInt(2));
                u.setNombre(rs.getString(3));
                u.setApellido(rs.getString(4));
                u.setCorrego(rs.getString(5));
                u.setEstado(rs.getInt(6));
                
                c.setUsuario(u);
                ls_c.add(c);
            }
            return ls_c;
        }
        catch (Exception e) {
            return null;
        }
    }
}
