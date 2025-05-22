package org.taller.moduloDeCompra.dominio;
import jakarta.json.bind.annotation.JsonbProperty;

public class DataFecha {
    @JsonbProperty("dia")
    public int dia;

    @JsonbProperty("mes")
    public int mes;

    @JsonbProperty("anio")
    public int anio;

    public static DataFecha hoy() {
        LocalDate ahora = LocalDate.now();
        DataFecha fecha = new DataFecha();
        fecha.dia = ahora.getDayOfMonth();
        fecha.mes = ahora.getMonthValue();
        fecha.anio = ahora.getYear();
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DataFecha)) return false;
        DataFecha f = (DataFecha) o;
        return this.dia == f.dia && this.mes == f.mes && this.anio == f.anio;
    }
}
