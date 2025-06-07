package org.taller.moduloDeComercio.dominio;

import jakarta.persistence.*;
@Entity
public class ReclamoComercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamo;

    private String descripcionReclamo;

    private String rutComercio;

    public ReclamoComercio() {
        // Constructor por defecto requerido por JPA
    }
    public ReclamoComercio( String descripcionReclamo, String rutComercio) {
        // Constructor para crear un reclamo con descripción y comercio
        this.descripcionReclamo = descripcionReclamo;
        this.rutComercio = rutComercio;
    }
    public int getIdReclamo() {
        return idReclamo;
    }
    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }
    public String getDescripcionReclamo() {
        return descripcionReclamo;
    }
    public void setDescripcionReclamo(String descripcionReclamo) {
        this.descripcionReclamo = descripcionReclamo;
    }
    public String getRutComercio() {
        return rutComercio;
    }
    public void setRutComercio(String rutComercio) {
        this.rutComercio = rutComercio;
    }
}
