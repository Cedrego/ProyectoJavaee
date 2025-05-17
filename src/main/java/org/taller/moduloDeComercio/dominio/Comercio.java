package org.taller.moduloDeComercio.dominio;

import jakarta.persistence.Id;

public class Comercio {
    @Id
    private String rutComercio;
    private String nombreComercio;
    private String direccionComercio;
    private String telefonoComercio;
    private String mailComercio;
    private String contraComercio;
    //lista con todos los POS que tiene

    //constructor completo
    public Comercio(String rut, String nombre, String direccion, String telefono, String mail, String contra) {
        this.rutComercio = rut;
        this.nombreComercio = nombre;
        this.direccionComercio = direccion;
        this.telefonoComercio = telefono;
        this.mailComercio = mail;
        this.contraComercio = contra;
    }


    public Comercio(int int1, String nombre, String direccion, String telefono, String email, String contraseniaHash) {
        //TODO Auto-generated constructor stub
    }


    //getters
    public String getRut() {
        return rutComercio;
    }

    public String getNombreComercio() {
        return nombreComercio;
    }

    public String getDireccionComercio() {
        return direccionComercio;
    }

    public String getTelefonoComercio() {
        return telefonoComercio;
    }

    public String getMailComercio() {
        return mailComercio;
    }

    public String getContraComercio() {
        return contraComercio;
    }


    //setters
    public void setRut(String rut) {
        this.rutComercio = rut;
    }

    public void setNombreComercio(String nombre) {
        this.nombreComercio = nombre;
    }

    public void setDireccionComercio(String direccion) {
        this.direccionComercio = direccion;
    }

    public void setTelefonoComercio(String telefono) {
        this.telefonoComercio = telefono;
    }

    public void setMailComercio(String mail) {
        this.mailComercio = mail;
    }

    public void setContraComercio(String contra) {
        this.contraComercio = contra;
    }



    

}