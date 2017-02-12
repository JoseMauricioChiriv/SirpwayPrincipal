/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.frontend.controller;

import com.sirpway.backend.entity.Persona;
import com.sirpway.backend.facade.PersonaFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.List;

/**
 *
 * @author Mauricio
 */
@Named(value = "personaController")
@Dependent
public class personaController {

    /**
     * Creates a new instance of personaController
     */
    @EJB
    private PersonaFacadeLocal personalocal;
    private Persona persona;

    public personaController() {
    }
    
    @PostConstruct
    public void init(){
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void RegistrarPersona(){
        personalocal.create(persona);
    }
    public List<Persona> listarPersona(){
        return personalocal.findAll();
    }
    public void EliminarPersona(Persona persona){
        personalocal.remove(persona);
    }
    public String Redireccion(Persona ActPersona){
        return "ActualizarPersona.xhtml" ;
    }
    public void actualizarPersona(Persona ActPersona){
        personalocal.edit(ActPersona);
    }

}
