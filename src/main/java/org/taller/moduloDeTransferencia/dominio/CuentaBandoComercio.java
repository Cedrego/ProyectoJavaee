package main.java.org.taller.moduloDeTransferencia.dominio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSFERENCIA_BANCO")
public class CuentaBandoComercio {
    int nroCuenta;
}
