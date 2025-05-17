package org.taller.moduloDeComercio.dominio;

public class DatosComercio {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String contrasenia;
    //lista con todos los POS que tiene

    public DatosComercio(String idDT, String nombreDT, String direccionDT, String telefonoDT, String emailDT, String contraDT) {
        this.id = idDT;
        this.nombre = nombreDT;
        this.direccion = direccionDT;
        this.telefono = telefonoDT;
        this.email = emailDT;
        this.contrasenia = contraDT;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseniaHash() {
        return contrasenia;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseniaHash(String contra) {
        this.contrasenia = contra;
    }
}
