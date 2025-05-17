package org.taller.moduloDeMonitoreo.infraestructura.persistencia;

import org.taller.moduloDeMonitoreo.repositorio.RepositorioEventos;

public class RepositorioEventosImpl implements RepositorioEventos {

    @Override
    public void guardarEvento(String tipo, String descripcion) {
        // Simula persistencia, por ejemplo en consola o una base de datos
        System.out.println("Evento guardado: [" + tipo + "] " + descripcion);
    }
}
