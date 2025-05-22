package org.taller.moduloDeCompra.dominio;
import java.time.LocalDate;
import jakarta.json.bind.annotation.JsonbProperty;

public class DataTarjeta {
    @JsonbProperty("nro")
    public String nro;

    @JsonbProperty("marca")
    public String marca;

    @JsonbProperty("fechaVto")
    public DataFecha fechaVto;
}
