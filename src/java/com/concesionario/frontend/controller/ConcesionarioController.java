/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controller;

import com.concesionario.backend.entities.Concesionario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.concesionario.backend.model.ConcesionarioFacadeLocal;

/**
 *
 * @author homero
 */
@ViewScoped
@Named
public class ConcesionarioController implements Serializable {

    @EJB
    private ConcesionarioFacadeLocal concesionarioEJB;

    private Concesionario concesionario;
    private List<Concesionario> consecionarios;
    private int nit;

    @PostConstruct
    public void init() {

        concesionario = new Concesionario();
        consecionarios = concesionarioEJB.findAll();

    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void registrarConcesionario() {
        try {

            concesionarioEJB.create(concesionario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Sucursal registrada exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar la sucursal"));

        }

    }

    public List<Concesionario> getConsecionarios() {
        return consecionarios;
    }

    public void setConsecionarios(List<Concesionario> consecionarios) {
        this.consecionarios = consecionarios;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

}
