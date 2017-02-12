/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.frontend.controller;

import com.sirpway.backend.entity.Comensal;
import com.sirpway.backend.facade.ComensalFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 *
 * @author Mauricio
 */
@Named(value = "comensalController")
@RequestScoped
public class comensalController {

    /**
     * Creates a new instance of comensalController
     */
    @EJB
    private ComensalFacadeLocal comensalLocal;
    private Comensal comensal;
    
    public comensalController() {
    }
    
    @PostConstruct
    public void init(){
        comensal = new Comensal();
    }

    public Comensal getComensal() {
        return comensal;
    }

    public void setComensal(Comensal comensal) {
        this.comensal = comensal;
    }
    
    public void RegistrarComensal(){
        comensalLocal.create(comensal);
    }
    public List<Comensal> ListarComensal(){
        return comensalLocal.findAll();
    }
    public void EliminarComensal(Comensal comensal){
        comensalLocal.remove(comensal);
    }
    public String Redireccion(){
        return "ActualizarComensal.xhtml";
    }
    public void ActualizareComensal(Comensal comensal){
        comensalLocal.edit(comensal);
    }
}
