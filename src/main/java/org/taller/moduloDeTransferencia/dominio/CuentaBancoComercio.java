package org.taller.moduloDeTransferencia.dominio;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancoComercio {
    private int nroCuenta;

    private Comercio comercio;     // RUT del comercio
    
    private List<Deposito> listaDepositos = new ArrayList<>(); // Lista de depósitos asociados a la cuenta
    
    public void addDeposito(Deposito deposito) {
        this.listaDepositos.add(deposito);
    }
}
