package org.taller.moduloDeTransferencia.dominio.repositorio;
import java.util.ArrayList;
import java.util.List;
import org.taller.moduloDeTransferencia.dominio.Comercio;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ComercioRepo {
     private List<Comercio> comercios = new ArrayList<>();

    public Comercio guardar(Comercio comercio) {
        comercios.add(comercio);
        return comercio;
    }

    public List<Comercio> listarTodos() {
        return new ArrayList<>(comercios); // Copia defensiva
    }

    public Comercio buscarPorRut(int rut) {
        return comercios.stream()
                .filter(c -> c.getRut() == rut)
                .findFirst()
                .orElse(null);
    }
}
