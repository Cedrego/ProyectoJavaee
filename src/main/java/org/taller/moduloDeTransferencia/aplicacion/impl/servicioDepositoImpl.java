package org.taller.moduloDeTransferencia.aplicacion.impl;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.taller.moduloDeTransferencia.aplicacion.servicioDeposito;
import org.taller.moduloDeTransferencia.dominio.DataFecha;
import org.taller.moduloDeTransferencia.dominio.Deposito;
import org.taller.moduloDeTransferencia.dominio.repositorio.depositoRepo;

@ApplicationScoped
public class servicioDepositoImpl implements servicioDeposito {

    private final depositoRepo repo = new depositoRepo(); // repositorio en memoria
    @Override
    public void realizarDeposito(int idCompra, int rutComercio, float monto) {
            float comision = monto * 0.02f;
            float montoNeto = monto - comision;

            Deposito deposito = new Deposito();
            deposito.setImporte(montoNeto);
            deposito.setIdCompra(idCompra);
            deposito.setRutComercio(rutComercio);
            deposito.setFecha(DataFecha.now()); // Metodo para obtener la fecha actual

            repo.guardar(deposito);

            System.out.println("✔ Depósito registrado:");
            System.out.println("→ RUT Comercio: " + rutComercio);
            System.out.println("→ ID Compra: " + idCompra);
            System.out.println("→ Monto bruto: " + monto);
            System.out.println("→ Comisión: " + comision);
            System.out.println("→ Monto neto depositado: " + montoNeto);
    }
    
    @Override
    public List<Deposito> MostrarHistorialDeDepositos(int rutComercio, DataFecha fecha) {
         return repo.buscarPorRutYFecha(rutComercio, fecha);   
    }
   
}