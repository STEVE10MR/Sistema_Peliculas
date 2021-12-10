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
public class Pelicula {

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
     * @return the Imagen
     */
    public String getImagen() {
        return Imagen;
    }

    /**
     * @param Imagen the Imagen to set
     */
    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the FechaEstreno
     */
    public Date getFechaEstreno() {
        return FechaEstreno;
    }

    /**
     * @param FechaEstreno the FechaEstreno to set
     */
    public void setFechaEstreno(Date FechaEstreno) {
        this.FechaEstreno = FechaEstreno;
    }

    /**
     * @return the Duracion
     */
    public int getDuracion() {
        return Duracion;
    }

    /**
     * @param Duracion the Duracion to set
     */
    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    /**
     * @return the clasificacion
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the Valor
     */
    public Double getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
    private int ID;
    private String Imagen;
    private String Nombre;
    private String Descripcion;
    private Date FechaEstreno;
    private int Duracion;
    private Clasificacion clasificacion;
    private Double Valor;
}
