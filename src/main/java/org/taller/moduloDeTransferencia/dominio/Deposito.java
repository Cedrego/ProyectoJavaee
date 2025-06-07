package org.taller.moduloDeTransferencia.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Deposito {

    private int id; // Solo para que JPA pueda identificar la entidad

    float importe;
    
    DataFecha fecha;

    private int idCompra;       // Identificador de la compra

    private CuentaBancoComercio Cuenta;     // RUT del comercio

    public Deposito(float importe, DataFecha fecha, int idCompra, CuentaBancoComercio Cuenta) {
        this.importe = importe;
        this.fecha = fecha;
        this.idCompra = idCompra;
        this.Cuenta = Cuenta;
    }
}
