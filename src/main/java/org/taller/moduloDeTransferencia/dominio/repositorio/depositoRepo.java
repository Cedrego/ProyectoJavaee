package org.taller.moduloDeTransferencia.dominio.repositorio;
import org.taller.moduloDeTransferencia.dominio.DataFecha;
import org.taller.moduloDeTransferencia.dominio.Deposito;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class depositoRepo {
    
    private List<Deposito> depositos = new ArrayList<>();
    private AtomicInteger idGenerator = new AtomicInteger(1); // Generador de IDs

    public Deposito guardar(Deposito deposito) {
        deposito.setId(idGenerator.getAndIncrement()); // asigna ID único
        depositos.add(deposito);
        return deposito;
    }

    public List<Deposito> listarTodos() {
        return new ArrayList<>(depositos); // devuelve copia para evitar modificaciones externas
    }

    public List<Deposito> buscarPorRutYFecha(int rutComercio, DataFecha fecha) {
    return depositos.stream()//Stream permite procesarla con operaciones funcionales como filter.
            .filter(d -> d.getRutComercio() == rutComercio && //iltra los elementos del stream, es decir, elige solo los depósitos que cumplan cierta condición
                         d.getFecha().equals(fecha))
            .toList();
    }
    
}
