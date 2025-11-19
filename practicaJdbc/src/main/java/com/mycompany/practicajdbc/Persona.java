package com.mycompany.practicajdbc;

import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gilda
 */
public class Persona {
    
    // char(3) en SQL se mapea mejor a String en Java para manejar códigos alfanuméricos
    private String tipoDoc;
    
    // char(15) se mapea a String
    private String nroDocumento;
    
    // varchar(80) se mapea a String
    private String nombres;
    
    // varchar(80) se mapea a String
    private String apellidos;
    
    // varchar(100) se mapea a String
    private String emailPersonal;
    
    // varchar(100) se mapea a String
    private String emailInstitucional;
    
    // char(3) se mapea a String
    private String tipoPersona;

    public String getTipoDoc() {
        return tipoDoc;
    }
    

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
        
    }

    @Override
    public String toString() {
        return "Persona{" + "tipoDoc=" + tipoDoc + ", nroDocumento=" + nroDocumento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", emailPersonal=" + emailPersonal + ", emailInstitucional=" + emailInstitucional + ", tipoPersona=" + tipoPersona + '}';
    }

    
}
