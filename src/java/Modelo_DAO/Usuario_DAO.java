/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Usuario_DAO {
    public int Registrar(Usuario usuario)
    {
        int ID_Usuario=-1;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL U_REG("+usuario.getNombre()+","+usuario.getApellido()+","+usuario.getCorrego()+","+usuario.getContrasenia()+","+usuario.getEstado()+");";
        try{
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery(); 
            if(rs.next())
            { 
                ID_Usuario =rs.getInt(1);
            }
            else ID_Usuario =-1;
            return ID_Usuario;
        }
        catch (Exception e) {
            return -1;
        }
    }
    public boolean Actualizar(Usuario usuario)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL U_ACT(?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,usuario.getID());
            ps.setString(2,usuario.getNombre());
            ps.setString(3,usuario.getApellido());
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
    public boolean Actualizar_Contrasenia(Usuario usuario,String _n_contra)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL U_ACT_PASS(?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,usuario.getID());
            ps.setString(2,usuario.getContrasenia());
            ps.setString(3, _n_contra);
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
    public Object[] Login(String Correo,String Contrasenia)
    {
        ResultSet rs;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL U_LG(?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,Correo);
            ps.setString(2,Contrasenia);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)};
            }
            else return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    public boolean Activar_Estado(int ID_Usuario)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL U_AC(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_Usuario);
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
    public boolean Desactivar_Estado(int ID_Usuario)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL U_DC(?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID_Usuario);
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
