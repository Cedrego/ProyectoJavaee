package org.taller.moduloDeCompra.infraestructura;

public class PagoResponse {
    public boolean autorizado;
    public String codigo;

    @Override
    public String toString() {
        return "PagoResponse{" +
                "autorizado=" + autorizado +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}