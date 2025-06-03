package org.taller.moduloDeCompra.persistencia;

import java.util.Map;
import java.util.HashMap;

import org.taller.moduloDeCompra.dominio.Comercio;
import org.taller.moduloDeCompra.dominio.DataCompra;
import org.taller.moduloDeCompra.dominio.DataFecha;
import org.taller.moduloDeCompra.dominio.DataTarjeta;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;

@ApplicationScoped
public class ComercioService {
    private Map<Integer, Comercio> comerciosPorRut = new HashMap<>();
    public ComercioService() {
        // Crea un mapa vacío para permitir la carga en @PostConstruct
        this.comerciosPorRut = new HashMap<>();
    }	
    // Datos de prueba
    @PostConstruct
    void CargaDatosTest() {
        this.comerciosPorRut.put(1, new Comercio(1));
        this.comerciosPorRut.put(2, new Comercio(2));
        this.comerciosPorRut.get(1).addCompra(new DataCompra(1, 1500.0f, new DataFecha(3, 5, 2025), "Compra de ropa", new DataTarjeta(12345678, "Visa", new DataFecha(10, 12, 2026))));
        this.comerciosPorRut.get(1).addCompra(new DataCompra(2, 750.0f, new DataFecha(10, 5, 2025), "Zapatos", new DataTarjeta(87654321, "Mastercard", new DataFecha(5, 11, 2025))));
        this.comerciosPorRut.get(1).addCompra(new DataCompra(3, 1200.0f, new DataFecha(25, 5, 2025), "Fuera de rango", new DataTarjeta(11223344, "Amex", new DataFecha(1, 1, 2026))));
        this.comerciosPorRut.get(2).addCompra(new DataCompra(1, 1500.0f, new DataFecha(3, 5, 2025), "Compra de ropa", new DataTarjeta(12345678, "Visa", new DataFecha(10, 12, 2026))));
        this.comerciosPorRut.get(2).addCompra(new DataCompra(2, 750.0f, new DataFecha(10, 5, 2025), "Zapatos", new DataTarjeta(87654321, "Mastercard", new DataFecha(5, 11, 2025))));
        this.comerciosPorRut.get(2).addCompra(new DataCompra(3, 1200.0f, new DataFecha(22, 5, 2025), "Fuera de rango", new DataTarjeta(11223344, "Amex", new DataFecha(1, 1, 2026))));
    }


    public Comercio getComercioPorRut(Integer rut) {
        return comerciosPorRut.get(rut);
    }
}

