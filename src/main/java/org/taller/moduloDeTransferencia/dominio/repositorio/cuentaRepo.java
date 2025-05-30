package org.taller.moduloDeTransferencia.dominio.repositorio;
import org.taller.moduloDeTransferencia.dominio.CuentaBancoComercio;
import java.util.ArrayList;
import java.util.List;

public class cuentaRepo {

    private List<CuentaBancoComercio> cuentas = new ArrayList<>();
    
    public CuentaBancoComercio guardar(CuentaBancoComercio cuenta) {
        cuentas.add(cuenta);
        return cuenta;
    }
}

    