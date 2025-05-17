package org.taller.moduloDeComercio.aplicacion;

import org.taller.moduloDeComercio.dominio.DatosComercio;
import org.taller.moduloDeComercio.dominio.POS;

public interface InterfaceModuloComercio {
    //permite registrar un comercio en el sistema
    abstract void altaComercio(DatosComercio datos);

    //Permite modificar información relacionada al comercio.
    abstract void modificarDatosComercio(DatosComercio datos);

    //registra un nuevo POS en el sistema
    abstract void altaPos(String rutComercio, POS pos);

    //permite habilitar o deshabilitar un POS
    abstract void cambiarEstadoPos(String rutComercio, String idPos, boolean habilitado);

    //cambia contraseña del comercio. La contraseña se utilizará 
    //para poder invocar a la API remota que ofrece información de ventas (a
    //desarrollar en siguiente iteración)
    abstract void cambioContrasenia(String rutComercio, String nuevaContrasenia);

    //Recibe un reclamo del comercio, el cual deberá ser atendido por el departamento de Soporte.
    abstract void realizarReclamo(String rutComercio, String textoReclamo);

}
