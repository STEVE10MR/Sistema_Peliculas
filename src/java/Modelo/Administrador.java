/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Administrador {

    /**
     * @return the ID_Administrador
     */
    public int getID_Administrador() {
        return ID_Administrador;
    }

    /**
     * @param ID_Administrador the ID_Administrador to set
     */
    public void setID_Administrador(int ID_Administrador) {
        this.ID_Administrador = ID_Administrador;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    private int ID_Administrador;
    private Usuario usuario;
}
