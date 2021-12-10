/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class Factura {

    /**
     * @return the IGV
     */
    public Double getIGV() {
        return IGV;
    }

    /**
     * @param IGV the IGV to set
     */
    public void setIGV(Double IGV) {
        this.IGV = IGV;
    }

    /**
     * @return the Total
     */
    public Double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(Double Total) {
        this.Total = Total;
    }

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
     * @return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the Valoe
     */
    public Double getValoe() {
        return Valoe;
    }

    /**
     * @param Valoe the Valoe to set
     */
    public void setValoe(Double Valoe) {
        this.Valoe = Valoe;
    }

    /**
     * @return the alquiler
     */
    public Alquiler getAlquiler() {
        return alquiler;
    }

    /**
     * @param alquiler the alquiler to set
     */
    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
    private int ID;
    private Date Fecha;
    private Double Valoe;
    private Double Total;
    private Double IGV;
    private Alquiler alquiler;

   
}
