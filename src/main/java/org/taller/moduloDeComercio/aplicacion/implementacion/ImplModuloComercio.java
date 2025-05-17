package org.taller.moduloDeComercio.aplicacion.implementacion;

import java.util.HashMap;
import java.util.Map;

import org.taller.moduloDeComercio.aplicacion.InterfaceModuloComercio;
import org.taller.moduloDeComercio.dominio.Comercio;
import org.taller.moduloDeComercio.dominio.DatosComercio;
import org.taller.moduloDeComercio.dominio.POS;

public class ImplModuloComercio implements InterfaceModuloComercio {
    private Map<String, Comercio> comercios = new HashMap<>(); //esto va a ser un jpa en realidad
    //por ahora dejo esto

    @Override
    public void altaComercio(DatosComercio datos) {
        //control de que no exista otro con la misma id, cambiar por la version de JPA
        if (comercios.containsKey(datos.getId())) {
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
        //subir a la base de datos con JPA
        comercios.put(datos.getId(), nuevo);
    }

    @Override
    public void modificarDatosComercio(DatosComercio datos) {
        //get con JPA
        Comercio comercio = comercios.get(datos.getId());
        //control de existencia (quiero necesito que exista obviamente)
        if (comercio == null) throw new RuntimeException("No existe el comercio");

        //modificacion de datos, seria con jpa o una consulta SQL directa
        comercio.setNombreComercio(datos.getNombre());
        comercio.setDireccionComercio(datos.getDireccion());
        comercio.setTelefonoComercio(datos.getTelefono());
        comercio.setMailComercio(datos.getEmail());
    }

    @Override
    public void altaPos(String idComercio, POS pos) {
        //get con JPA
        Comercio comercio = comercios.get(idComercio);
        //mismo control que antes
        if (comercio == null) throw new RuntimeException("Comercio no encontrado");
        
        //subir a la base de datos
        //comercio.agregarPOS(pos);
    }

    @Override
    public void cambiarEstadoPos(String idComercio, String idPos, boolean habilitado) {
        //get base de datos
        Comercio comercio = comercios.get(idComercio);
        //control
        if (comercio == null) throw new RuntimeException("Comercio no encontrado");

        //buscar la id de POS en la lista del comercio
        POS pos = null; // comercio.buscarPOSPorId(Integer.parseInt(idPos));
        if (pos == null) throw new RuntimeException("POS no encontrado");

        //si existe, lo habilito 
        pos.setHabilitadoPOS(habilitado);
    }

    @Override
    public void cambioContrasenia(String idComercio, String nuevaContrasenia) {
        Comercio comercio = comercios.get(idComercio);
        if (comercio == null) throw new RuntimeException("Comercio no encontrado");

        comercio.setContraComercio(nuevaContrasenia);
    }

    @Override
    public void realizarReclamo(String idComercio, String textoReclamo) {
        // Acá podrías guardar el reclamo o mostrar un mensaje
        System.out.println("Reclamo recibido del comercio " + idComercio + ": " + textoReclamo);
    }
}
