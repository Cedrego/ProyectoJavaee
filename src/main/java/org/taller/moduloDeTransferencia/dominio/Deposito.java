package org.taller.moduloDeTransferencia.dominio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSFERENCIA_DEPOSITO")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Solo para que JPA pueda identificar la entidad

    float importe;
    
    @Embedded
    DataFecha fecha;

    private int idCompra;       // Identificador de la compra
    private int rutComercio;     // RUT del comercio

    public Deposito(float importe, DataFecha fecha, int idCompra, int rutComercio) {
        this.importe = importe;
        this.fecha = fecha;
        this.idCompra = idCompra;
        this.rutComercio = rutComercio;
    }
}
