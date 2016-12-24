/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controller;

import com.concesionario.backend.entities.Usuarios;
import com.concesionario.backend.model.UsuariosFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author homero
 */
@ViewScoped
@Named
public class UsuariosController implements Serializable{

    @EJB
    private UsuariosFacadeLocal usuarioEJB;
    private Usuarios usuarios;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();

    }

    public void registrarUsuarios() {
        try {
            usuarioEJB.create(usuarios);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario registrado correctamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar usuario"));
        }

    }

}
