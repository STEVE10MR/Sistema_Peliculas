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
public class Actor {

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the elenco
     */
    public Elenco getElenco() {
        return elenco;
    }

    /**
     * @param elenco the elenco to set
     */
    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    
    
   private int ID;
   private Elenco elenco;
}
