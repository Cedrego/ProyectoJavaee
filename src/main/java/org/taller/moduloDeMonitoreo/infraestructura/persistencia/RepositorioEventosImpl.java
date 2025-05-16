package monitoreo.infraestructura.persistencia;

import monitoreo.repositorio.RepositorioEventos;

public class RepositorioEventosImpl implements RepositorioEventos {

    @Override
    public void guardarEvento(String tipo, String descripcion) {
        // Simula persistencia, por ejemplo en consola o una base de datos
        System.out.println("Evento guardado: [" + tipo + "] " + descripcion);
    }
}
