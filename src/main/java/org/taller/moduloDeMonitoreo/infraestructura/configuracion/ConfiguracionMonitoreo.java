package monitoreo.infraestructura.configuracion;

import monitoreo.aplicacion.ServicioMonitoreoImpl;
import monitoreo.dominio.ServicioMonitoreo;
import monitoreo.repositorio.RepositorioEventos;
import monitoreo.infraestructura.persistencia.RepositorioEventosImpl;

public class ConfiguracionMonitoreo {

    public ServicioMonitoreo servicioMonitoreo() {
        RepositorioEventos repositorio = new RepositorioEventosImpl();
        return new ServicioMonitoreoImpl(repositorio);
    }
}
