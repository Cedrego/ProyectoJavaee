package org.taller.moduloDeMonitoreo.interfaces;

public interface ServicioMonitoreoRemoto {
    void notificarPago();
    void notificarPagoOk();
    void notificarPagoError();
    void notificarTransferencia();
    void notificarReclamoComercio();
}
