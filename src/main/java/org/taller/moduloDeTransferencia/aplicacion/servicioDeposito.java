package org.taller.moduloDeTransferencia.aplicacion;
import java.util.List;

import org.taller.moduloDeTransferencia.dominio.DataFecha;
import org.taller.moduloDeTransferencia.dominio.Deposito;


public interface servicioDeposito {

    public void realizarDeposito(int idCompra, int rutComercio, float monto);
    public List<Deposito> MostrarHistorialDeDepositos(int rutComercio, DataFecha fecha);
} 

