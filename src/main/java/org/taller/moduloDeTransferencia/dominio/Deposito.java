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
    float importe;
    DataFecha fecha;
}
