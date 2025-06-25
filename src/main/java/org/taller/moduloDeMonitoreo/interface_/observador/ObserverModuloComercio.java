package org.taller.moduloDeMonitoreo.interface_.observador;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.taller.moduloDeComercio.interfase.eventos.out.EventoReclamo;
import org.taller.moduloDeMonitoreo.aplicacion.RegistradoDeMetricas;

@ApplicationScoped
public class ObserverModuloComercio {
    private static final Logger log = Logger.getLogger(ObserverModuloTransferencia.class);

    @Inject
    private RegistradoDeMetricas register;

    public void accept(@Observes EventoReclamo evento) {
        log.infof("Evento procesado:", evento.getDescripcion());
        register.incrementarCounter(RegistradoDeMetricas.reclamoCounter);
    }
}
