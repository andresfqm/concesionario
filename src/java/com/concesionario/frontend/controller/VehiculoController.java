/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controller;

import com.concesionario.backend.entities.Concesionario;
import com.concesionario.backend.entities.Vehiculo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.concesionario.backend.model.VehiculoFacadeLocal;

/**
 *
 * @author homero
 */
@ViewScoped
@Named
public class VehiculoController implements Serializable {

    @EJB
    private VehiculoFacadeLocal vehiculoEJB;

    private Vehiculo vehiculo;
    private Concesionario concesionario;
     private List<Vehiculo> vehiculos;

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
        vehiculoEJB.findAll();
        concesionario = new Concesionario();
        vehiculos = vehiculoEJB.findAll();
       

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public List<Vehiculo> listarVehiculos() {

        return this.vehiculoEJB.findAll();

    }

    public void registrarVehiculo() {
        try {
           vehiculo.setCodigoConcesionario(concesionario);
            vehiculoEJB.create(vehiculo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Vehiculo registrado exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar el vehiculo"));
        }

    }

}
