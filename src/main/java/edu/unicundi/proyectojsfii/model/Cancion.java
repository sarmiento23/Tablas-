/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.proyectojsfii.model;

import java.io.Serializable;


/**
 *
 * @author Luz
 */
public class Cancion implements Serializable{
    
    private Integer id;
    
    private String nombre;
    
    private String duracion;
    
    private String nombreArtista;
    
    private String formato;
    
    private String precio;
    
    private boolean seleccion;
    

    public Cancion(Integer id, String nombre, String duracion, String nombreArtista, String formato , String precio) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.nombreArtista = nombreArtista;
        this.formato=formato;
        this.precio =precio;
    }        
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }        

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    
}
