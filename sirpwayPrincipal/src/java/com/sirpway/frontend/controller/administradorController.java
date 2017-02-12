/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.frontend.controller;

import com.sirpway.backend.entity.Administrador;
import com.sirpway.backend.facade.AdministradorFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 *
 * @author Mauricio
 */
@Named(value = "administradorController")
@RequestScoped
public class administradorController {

    /**
     * Creates a new instance of administradorController
     */
    @EJB
    private AdministradorFacadeLocal administradorLocal;
    private Administrador administrador;
    
    public administradorController() {
    }
    
    @PostConstruct
    public void init(){
        administrador = new Administrador();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public void RegistrarAdmin(){
        administradorLocal.create(administrador);
    }
    public List<Administrador> ListarAdmin(){
        return administradorLocal.findAll();
    }
    public void EliminarAdmin(Administrador Admin){
        administradorLocal.remove(Admin);
    }
    public String Redireccion(Administrador Admin){
        return "ActualizarAdmin.xhtml";
    }
    public void ActualizarAdmin(Administrador Admin){
        administradorLocal.edit(Admin);
    }
}
