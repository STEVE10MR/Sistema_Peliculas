/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    
    //Singleton Pattern
    
    public static Connection Conectar()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sis_pelis","root","");   
        } 
        catch (ClassNotFoundException e)
        {
            return null;
        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
}
