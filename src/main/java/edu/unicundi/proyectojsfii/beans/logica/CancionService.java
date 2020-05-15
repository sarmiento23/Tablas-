/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.proyectojsfii.beans.logica;

import edu.unicundi.proyectojsfii.model.Cancion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ASUS-PC
 */
@Named(value = "cancionService")
@RequestScoped
public class CancionService {

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

}
