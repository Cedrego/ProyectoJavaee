package org.taller.moduloDeTransferencia.interfase.evento.in;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.taller.moduloDeComercio.interfase.eventos.ListenerEventosComercio;
import org.taller.moduloDeTransferencia.dominio.CuentaBancoComercio;
import org.taller.moduloDeTransferencia.dominio.repositorio.comercioRepo;
import org.taller.moduloDeTransferencia.dominio.repositorio.cuentaRepo;

@ApplicationScoped
public class ObservadorDeEventos implements ListenerEventosComercio {
    private static final Logger log = Logger.getLogger(ObservadorDeEventos.class.getName());

    @Inject
    comercioRepo repo;
    @Inject
    cuentaRepo repo2;

    @Override
    public void alCrearComercio(org.taller.moduloDeComercio.dominio.Comercio comercio) {
        log.info("Listener recibido: alCrearComercio - " + comercio.getNombreComercio());

        // Crear una nueva cuenta bancaria con número único (ejemplo sencillo)
        CuentaBancoComercio cuenta = new CuentaBancoComercio();
       // Crear cuenta bancaria con número aleatorio de 5 dígitos
        int nroCuenta = 10000 + (int)(Math.random() * 90000);

        cuenta.setNroCuenta(nroCuenta);
        cuenta.setListaDepositos(new ArrayList<>());

        // Crear nuevo comercio y asociarle la cuenta bancaria
        org.taller.moduloDeTransferencia.dominio.Comercio nuevoComercio = new org.taller.moduloDeTransferencia.dominio.Comercio();
        nuevoComercio.setRut(comercio.getRut());
        nuevoComercio.setCuentaBancoComercio(cuenta);

        // Asociar el comercio a la cuenta también (relación bidireccional si corresponde)
        cuenta.setComercio(nuevoComercio);
        repo2.guardar(cuenta);
        log.info("✔ Cuenta bancaria creada y asociada al comercio: " + comercio.getNombreComercio());

        // Guardar el comercio (y posiblemente la cuenta si hay persistencia en cascada)
        repo.guardar(nuevoComercio);

        log.info("✔ Comercio y cuenta creados y asociados exitosamente");
    }
    @Override
    public void alModificarComercio(org.taller.moduloDeComercio.dominio.Comercio comercio) {
        // No hacer nada (por ahora)
    }

    @Override
    public void alRecibirReclamo(String rut, String mensaje) {
        // No hacer nada (por ahora)
    }

    @Override
    public void alCambiarContrasenia(org.taller.moduloDeComercio.dominio.Comercio comercio) {
        // No hacer nada (por ahora)
    }
}
