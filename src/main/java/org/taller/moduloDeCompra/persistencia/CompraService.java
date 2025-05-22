import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.taller.moduloDeCompra.dominio.DataCompra;
import org.taller.moduloDeCompra.dominio.DataFecha;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraService {

    private List<DataCompra> compras;

    public CompraService(List<DataCompra> compras) {
        this.compras = compras;
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
        LocalDate fecha = LocalDate.of(f.Anio, f.Mes, f.Dia);
        LocalDate desde = LocalDate.of(ini.Anio, ini.Mes, ini.Dia);
        LocalDate hasta = LocalDate.of(fin.Anio, fin.Mes, fin.Dia);
        return (fecha.isEqual(desde) || fecha.isAfter(desde)) &&
               (fecha.isEqual(hasta) || fecha.isBefore(hasta));
    }
}
