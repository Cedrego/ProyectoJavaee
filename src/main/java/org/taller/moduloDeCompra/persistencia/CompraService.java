package org.taller.moduloDeCompra.persistencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.taller.moduloDeCompra.dominio.DataCompra;
import org.taller.moduloDeCompra.dominio.DataFecha;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;

@ApplicationScoped
public class CompraService {

    private List<DataCompra> compras;

    public CompraService() {
        this.compras = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        // Aquí puedes cargar compras de prueba
    }

    public List<DataCompra> listarVentasPorPeriodo(Integer idComercio, String fechaIniStr, String fechaEndStr) {
        DataFecha fechaIni = parseFecha(fechaIniStr);
        DataFecha fechaEnd = parseFecha(fechaEndStr);

        return compras.stream()
            .filter(c -> esFechaEnRango(c.fecha, fechaIni, fechaEnd))
            .collect(Collectors.toList());
    }

    private DataFecha parseFecha(String fechaStr) {
        LocalDate fecha = LocalDate.parse(fechaStr); // formato "YYYY-MM-DD"
        return new DataFecha(fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear());
    }

    private boolean esFechaEnRango(DataFecha f, DataFecha ini, DataFecha fin) {
        LocalDate fecha = LocalDate.of(f.anio, f.mes, f.dia);
        LocalDate desde = LocalDate.of(ini.anio, ini.mes, ini.dia);
        LocalDate hasta = LocalDate.of(fin.anio, fin.mes, fin.dia);
        return (fecha.isEqual(desde) || fecha.isAfter(desde)) &&
               (fecha.isEqual(hasta) || fecha.isBefore(hasta));
    }
}

