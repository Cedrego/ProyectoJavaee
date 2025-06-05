package org.taller.moduloDeMonitoreo.aplicacion;

import org.taller.moduloDeMonitoreo.dominio.eventos.EventoPago;
import org.taller.moduloDeMonitoreo.infraestructura.eventos.BusDeEventos;
import org.taller.moduloDeMonitoreo.dominio.ServicioMonitoreo;

public class ServicioMonitoreoImpl implements ServicioMonitoreo {

    private final BusDeEventos bus;

    public ServicioMonitoreoImpl(BusDeEventos bus) {
        this.bus = bus;
    }

    @Override
    public void notificarPago() {
        bus.publicar(new EventoPago("PAGO", "Se realizó un pago"));
    }

    @Override
    public void notificarPagoOk() {
        bus.publicar(new EventoPago("PAGO_OK", "Pago exitoso"));
    }

    @Override
    public void notificarPagoError() {
        bus.publicar(new EventoPago("PAGO_ERROR", "Pago rechazado"));
    }

    @Override
    public void notificarTransferencia() {
        bus.publicar(new EventoPago("TRANSFERENCIA", "Se realizó una transferencia"));
    }

    @Override
    public void notificarReclamoComercio() {
        bus.publicar(new EventoPago("RECLAMO", "Reclamo del comercio recibido"));
    }
}
