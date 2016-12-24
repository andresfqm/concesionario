/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controller;

import com.concesionario.backend.entities.Cliente;
import com.concesionario.backend.entities.Vehiculo;
import com.concesionario.backend.entities.Ventas;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.concesionario.backend.model.VentasFacadeLocal;

/**
 *
 * @author homero
 */
@ViewScoped
@Named
public class VentasController implements Serializable {

    @EJB
    private VentasFacadeLocal ventasEJB;

    private Ventas ventas;
    private Cliente cliente;
    private Vehiculo vehiculo;

    @PostConstruct
    public void init() {
        ventas = new Ventas();
        cliente = new Cliente();
        vehiculo = new Vehiculo();

    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void registrarVenta() {
        try {
            ventas.setIdCliente(cliente);
            ventas.setIdVehiculo(vehiculo);
            
          
            ventasEJB.create(ventas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Venta registrada exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar la ventaF"));
        }

    }

}
