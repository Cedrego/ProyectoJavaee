package org.taller.moduloDeCompra.dominio;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DataTarjeta {
    @JsonbProperty("nro")
    public Integer nro;

    @JsonbProperty("marca")
    public String marca;

    @JsonbProperty("fechaVto")
    public DataFecha fechaVto;

}
