/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.backend.model;

import com.concesionario.backend.entities.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author homero
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    Usuarios iniciarSesion(Usuarios us);
    
}
