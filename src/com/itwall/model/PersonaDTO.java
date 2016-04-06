/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itwall.model;

/**
 *
 * @author maliaga
 */
public class PersonaDTO {
    
    private Integer idPersona;
    private String pNombre;
    private String pDireccion;
    private Integer pNumTelefono;
    private String pImail;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getpDireccion() {
        return pDireccion;
    }

    public void setpDireccion(String pDireccion) {
        this.pDireccion = pDireccion;
    }

    public Integer getpNumTelefono() {
        return pNumTelefono;
    }

    public void setpNumTelefono(Integer pNumTelefono) {
        this.pNumTelefono = pNumTelefono;
    }

    public String getpImail() {
        return pImail;
    }

    public void setpImail(String pImail) {
        this.pImail = pImail;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "idPersona=" + idPersona +
                ", pNombre='" + pNombre + '\'' +
                ", pDireccion='" + pDireccion + '\'' +
                ", pNumTelefono=" + pNumTelefono +
                ", pImail='" + pImail + '\'' +
                '}';
    }
}
