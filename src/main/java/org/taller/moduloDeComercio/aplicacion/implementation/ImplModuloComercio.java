package org.taller.moduloDeComercio.aplicacion.implementation;

import java.util.ArrayList;
import java.util.List;

import org.taller.moduloDeComercio.aplicacion.InterfaceModuloComercio;
import org.taller.moduloDeComercio.dominio.Comercio;
import org.taller.moduloDeComercio.dominio.DatosComercio;
import org.taller.moduloDeComercio.dominio.POS;
import org.taller.moduloDeComercio.interfase.ListenerEventosComercio;
import org.taller.moduloDeComercio.repositorio.RepositorioComercio;

public class ImplModuloComercio implements InterfaceModuloComercio {
    private RepositorioComercio repositorioComercio = new RepositorioComercio(); //esto va a ser un jpa en realidad
    //por ahora dejo esto

    private final List<ListenerEventosComercio> listeners = new ArrayList<>();

    public void registrarListener(ListenerEventosComercio listener) {
        listeners.add(listener);
    }

    @Override
    public void altaComercio(DatosComercio datos) {
        //control de que no exista otro con la misma id, cambiar por la version de JPA
        if (repositorioComercio.existe(Integer.parseInt(datos.getId()))) {
            throw new RuntimeException("Comercio ya existe");
        }
        //crear objeto
        Comercio nuevo = new Comercio(
                datos.getId(),
                datos.getNombre(),
                datos.getDireccion(),
                datos.getTelefono(),
                datos.getEmail(),
                datos.getContraseniaHash()
        );
        //luego cambiar a subir a la base de datos con JPA
        repositorioComercio.guardar(nuevo);

        for (ListenerEventosComercio listener : listeners) {
            listener.alCrearComercio(nuevo);
        }
    }

    @Override
    public void modificarDatosComercio(DatosComercio datos) {
        //luego get con JPA
        Comercio comercio = repositorioComercio.obtenerPorRut(Integer.parseInt(datos.getId()));
        //control de existencia (necesito que exista obviamente)
        if (comercio == null) throw new RuntimeException("No existe el comercio");

        //modificacion de datos, despues seria con jpa o una consulta SQL directa
        comercio.setNombreComercio(datos.getNombre());
        comercio.setDireccionComercio(datos.getDireccion());
        comercio.setTelefonoComercio(datos.getTelefono());
        comercio.setMailComercio(datos.getEmail());

        for (ListenerEventosComercio listener : listeners) {
            listener.alModificarComercio(comercio);
        }
    }

    @Override
    public void altaPos(String idComercio, int idPos) {
        //luego get con JPA
        Comercio comercio = repositorioComercio.obtenerPorRut(Integer.parseInt(idComercio));
        //mismo control que antes
        if (comercio == null) throw new RuntimeException("Comercio no encontrado");

        POS posNuevo = new POS(idPos, comercio);
        //agregar a la lista, deberia subir a la base de datos tambien
        comercio.agregarPOS(posNuevo);
    }

    @Override
    public void cambiarEstadoPos(String idComercio, int idPos, boolean habilitado) {
        //get base de datos
        Comercio comercio = repositorioComercio.obtenerPorRut(Integer.parseInt(idComercio));
        //control
        if (comercio == null) throw new RuntimeException("Comercio no encontrado");

        //buscar el POS en la lista del comercio
        POS pos = comercio.buscarPOSPorId(idPos);
        if (pos == null) throw new RuntimeException("POS no encontrado");

        //si existe, lo habilito 
        pos.setHabilitadoPOS(habilitado);
    }

    @Override
    public void cambioContrasenia(String idComercio, String nuevaContrasenia) {
        Comercio comercio = repositorioComercio.obtenerPorRut(Integer.parseInt(idComercio));
        if (comercio == null) throw new RuntimeException("Comercio no encontrado");

        comercio.setContraComercio(nuevaContrasenia);
        
        for (ListenerEventosComercio listener : listeners) {
            listener.alCambiarContrasenia(comercio);
        }
    }

    @Override
    public void realizarReclamo(String idComercio, String textoReclamo) {
        //podría guardar el reclamo o mostrar un mensaje, por ahora queda en consola
        System.out.println("Reclamo recibido del comercio " + idComercio + ": " + textoReclamo);
    }
}
