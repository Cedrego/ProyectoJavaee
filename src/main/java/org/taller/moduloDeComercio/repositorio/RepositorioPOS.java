package org.taller.moduloDeComercio.repositorio;

import java.util.HashMap;
import java.util.Map;

import org.taller.moduloDeComercio.dominio.POS;

public class RepositorioPOS {
    private Map<Integer, POS> posMap = new HashMap<>();

    public void guardar(POS pos) {
        posMap.put(pos.getIdPOS(), pos);
    }

    public POS obtener(int id) {
        return posMap.get(id);
    }

    public void eliminar(int id) {
        posMap.remove(id);
    }

    public boolean existe(int id) {
        return posMap.containsKey(id);
    }

    public Map<Integer, POS> obtenerTodos() {
        return posMap;
    }
}
