package org.taller.moduloDeComercio.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;

public class Comercio {
    @Id
    private String rutComercio;
    private String nombreComercio;
    private String direccionComercio;
    private String telefonoComercio;
    private String mailComercio;
    private String contraComercio;
    private List<POS> listaPOS; //lista con todos los POS que tiene

    //constructor completo
    public Comercio(String rut, String nombre, String direccion, String telefono, String mail, String contra) {
        this.rutComercio = rut;
        this.nombreComercio = nombre;
        this.direccionComercio = direccion;
        this.telefonoComercio = telefono;
        this.mailComercio = mail;
        this.contraComercio = contra;
        this.listaPOS = new ArrayList<>();
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

    public List<POS> getPos() {
        return listaPOS;
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

    public void setPos(List<POS> pos) {
        this.listaPOS = pos;
    }

    
    //operacion para agregar la id de un POS a la lista del comercio
    public void agregarPOS(POS pos) {
        this.listaPOS.add(pos);
    }

    //operacion para buscar el POS con el id que le entra
    public POS buscarPOSPorId(int id) {
        for (POS pos : listaPOS) {
            if (pos.getIdPOS() == id) return pos;
        }
        return null;
    }



    

}