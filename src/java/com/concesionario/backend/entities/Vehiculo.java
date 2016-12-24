/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homero
 */
@Entity
@Table(name = "tbl_vehiculo")

public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoVehiculo")
    private Integer codigoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "codigoConcesionario", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Concesionario codigoConcesionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private List<Ventas> tblVentasList;

    private List<Vehiculo> vehiculos;

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Vehiculo() {
    }

    public Vehiculo(Integer codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public Vehiculo(Integer codigoVehiculo, String marca, int modelo, double precio) {
        this.codigoVehiculo = codigoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Integer getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(Integer codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Concesionario getCodigoConcesionario() {
        return codigoConcesionario;
    }

    public void setCodigoConcesionario(Concesionario codigoConcesionario) {
        this.codigoConcesionario = codigoConcesionario;
    }

    @XmlTransient
    public List<Ventas> getTblVentasList() {
        return tblVentasList;
    }

    public void setTblVentasList(List<Ventas> tblVentasList) {
        this.tblVentasList = tblVentasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVehiculo != null ? codigoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.codigoVehiculo == null && other.codigoVehiculo != null) || (this.codigoVehiculo != null && !this.codigoVehiculo.equals(other.codigoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.concesionario.backend.entities.TblVehiculo[ codigoVehiculo=" + codigoVehiculo + " ]";
    }

}
