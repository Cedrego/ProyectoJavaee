package org.taller.moduloDeTransferencia.interfase.evento;

public class ComercioCreadoEvent {
    private final int rut;

    public ComercioCreadoEvent(int rut) {
        this.rut = rut;
    }

    public int getRut() {
        return rut;
    }
}
