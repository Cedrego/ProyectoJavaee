package org.taller.moduloDeTransferencia.interfase.evento.in;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.logging.Logger;
import org.taller.moduloDeTransferencia.dominio.repositorio.comercioRepo;


@ApplicationScoped
public class ObservadorDeEventos {
    private static final Logger log = Logger.getLogger(ObservadorDeEventos.class.getName()); // Corrige aquí

    @Inject
    comercioRepo repo;
/* 
   public void onNuevoComercio(@Observes ComercioCreado evento) {
        log.infof("Recibido evento ComercioCreado: RUT=%d, nombre=%s", evento.getRut(), evento.getNombre());

        Comercio nuevo = new Comercio(evento.getRut(), evento.getNombre());
        repo.guardar(nuevo);
    }*/
}
