/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.proyectojsfii.beans;

import edu.unicundi.proyectojsfii.beans.logica.CancionService;
import edu.unicundi.proyectojsfii.model.Cancion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;


/**
 *
 * @author Luz
 */
@Named(value = "formularioTabla")
@SessionScoped
public class FormularioTabla  implements Serializable{
    
 
    
    private List<Cancion> listaCancion;
    
    @Inject
    private CancionService service;
    
    public FormularioTabla() {
        
    }
  
    @PostConstruct
    public void init(){
        this.listaCancion = service.getListaCancion();
    }

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }        

   

    public CancionService getService() {
        return service;
    }

    public void setService(CancionService service) {
        this.service = service;
    }
    
}
