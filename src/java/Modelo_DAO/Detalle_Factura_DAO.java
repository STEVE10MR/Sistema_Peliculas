/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_DAO;

import Config.Conexion;
import Modelo.Detalle_Factura;
import Modelo.Director;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author USUARIO
 */
public class Detalle_Factura_DAO {
    public boolean Registrar(Detalle_Factura detallefactura)
    {
        PreparedStatement ps=null;
        Connection con=(Connection)Conexion.Conectar();
        String sql="CALL DFAC_REG(?,?,?,?);";
        try{
            ps=con.prepareStatement(sql);
            ps.setDouble(1,detallefactura.getValor());
            ps.setDate(2,detallefactura.getFecha());
            ps.setDouble(3,detallefactura.getPelicula().getID());
            ps.setInt(4,detallefactura.getFactura().getID());
            return ps.execute();
        }
        catch (Exception e) {
            return false;
        }
    }
}
