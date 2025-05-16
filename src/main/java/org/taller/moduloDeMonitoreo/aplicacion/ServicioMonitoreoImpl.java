package org.taller.moduloDeMonitoreo.aplicacion;

import org.taller.moduloDeMonitoreo.dominio.ServicioMonitoreo;
import org.taller.moduloDeMonitoreo.repositorio.RepositorioEventos;

public class ServicioMonitoreoImpl implements ServicioMonitoreo {

    private final RepositorioEventos repositorio;

    public ServicioMonitoreoImpl(RepositorioEventos repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void notificarPago() {
        repositorio.guardarEvento("PAGO", "Se realizó un pago");
    }

    @Override
    public void notificarPagoOk() {
        repositorio.guardarEvento("PAGO_OK", "Pago exitoso");
    }

    @Override
    public void notificarPagoError() {
        repositorio.guardarEvento("PAGO_ERROR", "Pago rechazado");
    }

    @Override
    public void notificarTransferencia() {
        repositorio.guardarEvento("TRANSFERENCIA", "Se realizó una transferencia");
    }

    @Override
    public void notificarReclamoComercio() {
        repositorio.guardarEvento("RECLAMO", "Reclamo del comercio recibido");
    }
}
