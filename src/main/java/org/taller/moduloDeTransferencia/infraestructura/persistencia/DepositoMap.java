package org.taller.moduloDeTransferencia.infraestructura.persistencia;
import org.taller.moduloDeTransferencia.dominio.DataFecha;
import jakarta.persistence.*;

@Entity
@Table(name = "DEPOSITO")
public class DepositoMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float importe;

    @Embedded
    private DataFecha fecha;

    private int idCompra;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaBancoComercioMap cuenta;

    // Constructor vacío requerido por JPA
    public DepositoMap() {}

    public DepositoMap(float importe, DataFecha fecha, int idCompra, CuentaBancoComercioMap cuenta) {
        this.importe = importe;
        this.fecha = fecha;
        this.idCompra = idCompra;
        this.cuenta = cuenta;
    }

    public void setCuenta(CuentaBancoComercioMap cuenta) {
        this.cuenta = cuenta;
    }

    // Getters y setters...
}
