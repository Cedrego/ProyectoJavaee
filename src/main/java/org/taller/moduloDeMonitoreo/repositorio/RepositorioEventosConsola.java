package org.taller.moduloDeMonitoreo.repositorio;

/**
 * Implementación de RepositorioEventos que imprime los eventos en consola.
 */
public class RepositorioEventosConsola implements RepositorioEventos {

    /**
     * Guarda el evento imprimiéndolo en consola.
     *
     * @param tipo    el tipo del evento
     * @param mensaje el mensaje del evento
     */
    @Override
    public void guardarEvento(String tipo, String mensaje) {
        System.out.println("📌 Evento registrado -> Tipo: " + tipo + ", Mensaje: " + mensaje);
    }
}
