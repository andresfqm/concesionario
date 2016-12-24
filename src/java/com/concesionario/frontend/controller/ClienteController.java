/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controller;

import com.concesionario.backend.entities.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.concesionario.backend.model.ClienteFacadeLocal;

/**
 *
 * @author homero
 */
@ViewScoped
@Named
public class ClienteController implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteEJB;
     private List<Cliente> clientes;
     private Cliente cliente;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        clientes = clienteEJB.findAll();
        

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void registrarCliente() {
        try {

            clienteEJB.create(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Cliente registrado exitosamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar el cliente"));
        }

    }

}
