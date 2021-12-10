/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Administrador;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public class Administrador_DAO{
    public boolean Registrar(Administrador administrador)
    {
        int ID_Usuario=-1;
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL AD_REG(?);";
        try{
            Usuario_DAO u=new Usuario_DAO();
            int ID_U=u.Registrar(administrador.getUsuario());
            if(ID_U!=-1)
            {
                ps=con.prepareStatement(sql);
                ps.setInt(1,ID_U);
                return ps.execute();
            }
            else return false;  
        }
        catch (Exception e) {
            return false;
        }
    }
}
