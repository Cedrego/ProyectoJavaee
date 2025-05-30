package org.taller.moduloDeTransferencia.aplicacion.impl;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

import org.taller.moduloDeTransferencia.dominio.Comercio;
import org.taller.moduloDeTransferencia.aplicacion.servicioDeposito;
import org.taller.moduloDeTransferencia.dominio.CuentaBancoComercio;
import org.taller.moduloDeTransferencia.dominio.DataFecha;
import org.taller.moduloDeTransferencia.dominio.Deposito;
import org.taller.moduloDeTransferencia.dominio.repositorio.comercioRepo;
import org.taller.moduloDeTransferencia.dominio.repositorio.depositoRepo;

@ApplicationScoped
public class servicioDepositoImpl implements servicioDeposito {

    private final depositoRepo repo = new depositoRepo(); // repositorio en memoria
    private final comercioRepo repo2 = new comercioRepo(); // repositorio en memoria

    @Override
    public void realizarDeposito(int idCompra, String rutComercio, float monto) {
        float comision = monto * 0.02f;
        float montoNeto = monto - comision;

        Comercio comercio = repo2.buscarPorRut(rutComercio);

        if (comercio == null) {
            System.out.println("❌ Comercio no encontrado con RUT: " + rutComercio);
            return;
        }

        CuentaBancoComercio cuenta = comercio.getCuentaBancoComercio();

        if (cuenta == null) {
            System.out.println("❌ El comercio no tiene una cuenta bancaria asociada.");
            return;
        }

        Deposito deposito = new Deposito();
        deposito.setImporte(montoNeto);
        deposito.setIdCompra(idCompra);
        deposito.setCuenta(cuenta); 
        deposito.setFecha(DataFecha.now()); 

        repo.guardar(deposito);
        cuenta.addDeposito(deposito); // Agregar el depósito a la cuenta
        comercio.setCuentaBancoComercio(cuenta); // Actualizar la cuenta en el comercio
        repo2.guardar(comercio); // Guardar el comercio actualizado con el nuevo depósito
        System.out.println("✔ Depósito registrado:");
        System.out.println("→ RUT Comercio: " + rutComercio);
        System.out.println("→ ID Compra: " + idCompra);
        System.out.println("→ Monto bruto: " + monto);
        System.out.println("→ Comisión: " + comision);
        System.out.println("→ Monto neto depositado: " + montoNeto);
    }
    
    @Override
    public List<Deposito> MostrarHistorialDeDepositos(String rutComercio, DataFecha fecha) {
         return repo.buscarPorRutYFecha(rutComercio, fecha);   
    }
   
}