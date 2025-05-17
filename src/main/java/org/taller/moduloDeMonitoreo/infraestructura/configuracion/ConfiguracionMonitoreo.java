package org.taller.moduloDeMonitoreo.infraestructura.configuracion;

import org.taller.moduloDeMonitoreo.aplicacion.ServicioMonitoreoImpl;
import org.taller.moduloDeMonitoreo.dominio.ServicioMonitoreo;
import org.taller.moduloDeMonitoreo.repositorio.RepositorioEventos;
import org.taller.moduloDeMonitoreo.infraestructura.persistencia.RepositorioEventosImpl;

public class ConfiguracionMonitoreo {

    public ServicioMonitoreo servicioMonitoreo() {
        RepositorioEventos repositorio = new RepositorioEventosImpl();
        return new ServicioMonitoreoImpl(repositorio);
    }
}
