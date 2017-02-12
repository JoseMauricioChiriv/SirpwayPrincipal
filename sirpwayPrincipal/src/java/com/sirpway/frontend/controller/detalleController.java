/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.frontend.controller;

import com.sirpway.backend.entity.Detalle;
import com.sirpway.backend.facade.DetalleFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 *
 * @author Mauricio
 */
@Named(value = "detalleController")
@RequestScoped
public class detalleController {

    /**
     * Creates a new instance of detalleController
     */
    @EJB
    private DetalleFacadeLocal detalleLocal;
    private Detalle detalle;
    
    public detalleController() {
    }
    
    public void init(){
        detalle = new Detalle();
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }
    
    public void RegistrarDetalle(){
        detalleLocal.create(detalle);
    }
    public List<Detalle> ListarDetalle(){
        return detalleLocal.findAll();
    }
    public void EliminarDetalle(Detalle detalle){
        detalleLocal.remove(detalle);
    }
    public String Redireccion(){
        return "ActualizarDetalle.xhtml";
    }
    public void ActualizarDetalle(Detalle detalle){
        detalleLocal.edit(detalle);
    }
}
