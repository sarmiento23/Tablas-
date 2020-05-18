/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.proyectojsfii.beans.logica;

import edu.unicundi.proyectojsfii.model.Cancion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Valentina
 */
@Named(value = "cancionService")
@SessionScoped
public class CancionService implements Serializable {
    
    private Integer id;

    private String nombre;

    private String duracion;

    private String nombreArtista;

    private String formato;

    private String precio;
    private List<Cancion> listaCancion;
    private List<Cancion> listaEliminados;

    public CancionService() {
        
        listaCancion = new ArrayList<>();
        listaEliminados = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        System.out.println ("Entro a lista");
        listaCancion.add(new Cancion(1, "Cigarette Smoke", "3:20", "Arctic Monkeys", "CD", "$15.000"));
        listaCancion.add(new Cancion(2, "Thriller", "4:30", " Michael Jackson", "CD", "$8.000"));
        listaCancion.add(new Cancion(3, "Like a Prayer", "5:00", "Madonna", "CD", "$3.000"));
        listaCancion.add(new Cancion(4, "When Doves Cry", "2:20", "Prince", "CD", "$2.000"));
        listaCancion.add(new Cancion(5, "I Wanna Dance With Somebody", "1:15", "Whitney Houston", "CD", "$25.000"));
        listaCancion.add(new Cancion(6, "Rehab", "3:20", "Amy Winehouse", "CD", "$12.000"));
        listaCancion.add(new Cancion(7, "Rolling in the Deep", "5:20", "Adele", "CD", "$1.000"));
        listaCancion.add(new Cancion(8, "Poker Face", "3:46", "Lady Gaga", "CD", "$3.000"));
        listaCancion.add(new Cancion(9, "Get Lucky", "4:25", "Daft Punk", "CD", "$18.000"));
        listaCancion.add(new Cancion(10, "Crazy", "1:00", "Gnarls Barkley", "CD", "$35.000"));
        listaCancion.add(new Cancion(11, "Hips don't lie", "5:10", "Shakira", "CD", "$15.000"));
         
    }
    
    public void actualizar(RowEditEvent event) {
            Cancion c = (Cancion) event.getObject();
            this.nombre=c.getNombre();
            this.formato=c.getFormato();
            this.duracion=c.getDuracion();
            this.nombreArtista=c.getNombreArtista();
            this.precio=c.getPrecio();
            c.setNombre(nombre);
            c.setDuracion(duracion);
            c.setFormato(formato);
            c.setNombreArtista(nombreArtista);
            c.setPrecio(precio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con exito"));             
    }

    public void cancelar(RowEditEvent event) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancelar"));
    }
     
    public String eliminar() {
        System.out.println ("Entro a eliminar");
        
        for (Cancion c : listaCancion){
            if(c.isSeleccion()){
                listaEliminados.add(c);
            }
        }
        
        if (listaEliminados.isEmpty()) {
           System.out.println ("entro a if");
        }
        else{
            listaCancion.removeAll(listaEliminados);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminados con exito"));
        }
        

        return "formularioTabla";
    }
    
    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
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
}
