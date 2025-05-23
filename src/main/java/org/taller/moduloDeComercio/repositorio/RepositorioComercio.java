package org.taller.moduloDeComercio.repositorio;

import java.util.HashMap;
import java.util.Map;

import org.taller.moduloDeComercio.dominio.Comercio;

public class RepositorioComercio {
    private Map<Integer, Comercio> comercios = new HashMap<>();

    public void guardar(Comercio comercio) {
        comercios.put(Integer.parseInt(comercio.getRut()), comercio);
    }

    public Comercio obtenerPorRut(int rut) {
        return comercios.get(rut);
    }

    public boolean existe(int rut) {
        return comercios.containsKey(rut);
    }

    public void eliminar(int rut) {
        comercios.remove(rut);
    }

    public Map<Integer, Comercio> obtenerTodos() {
        return comercios;
    }
}
