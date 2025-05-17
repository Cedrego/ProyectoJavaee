package org.taller.moduloDeMonitoreo.aplicacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.taller.moduloDeMonitoreo.repositorio.RepositorioEventos;

import static org.mockito.Mockito.*;

class ServicioMonitoreoImplTest {


	private RepositorioEventos repositorio;
    private ServicioMonitoreoImpl servicio;

    @BeforeEach
    void setUp() {
        repositorio = mock(RepositorioEventos.class);
        servicio = new ServicioMonitoreoImpl(repositorio);
    }

    @Test
    void testNotificarPago() {
        servicio.notificarPago();
        verify(repositorio).guardarEvento("PAGO", "Se realizó un pago");
    }

    @Test
    void testNotificarPagoOk() {
        servicio.notificarPagoOk();
        verify(repositorio).guardarEvento("PAGO_OK", "Pago exitoso");
    }

    @Test
    void testNotificarPagoError() {
        servicio.notificarPagoError();
        verify(repositorio).guardarEvento("PAGO_ERROR", "Pago rechazado");
    }

    @Test
    void testNotificarTransferencia() {
        servicio.notificarTransferencia();
        verify(repositorio).guardarEvento("TRANSFERENCIA", "Se realizó una transferencia");
    }

    @Test
    void testNotificarReclamoComercio() {
        servicio.notificarReclamoComercio();
        verify(repositorio).guardarEvento("RECLAMO", "Reclamo del comercio recibido");
    }
}
	