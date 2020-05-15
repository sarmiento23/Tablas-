/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.proyectojsfii.beans;

import edu.unicundi.proyectojsfii.beans.logica.CancionService;
import edu.unicundi.proyectojsfii.model.Cancion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author ASUS-PC
 */
@Named(value = "formularioTabla")
@RequestScoped
public class FormularioTabla {

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
    
}
