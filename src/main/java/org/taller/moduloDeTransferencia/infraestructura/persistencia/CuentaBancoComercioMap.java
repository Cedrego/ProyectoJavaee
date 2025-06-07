package org.taller.moduloDeTransferencia.infraestructura.persistencia;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUENTA_BANCO_COMERCIO")
public class CuentaBancoComercioMap {

    @Id
    private int nroCuenta;

    @Column(name = "rut_comercio")
    private String rutComercio; // Usás solo el RUT, no el objeto `Comercio`

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DepositoMap> listaDepositos = new ArrayList<>();

    public void addDeposito(DepositoMap deposito) {
        listaDepositos.add(deposito);
        deposito.setCuenta(this);
    }

    // Getters y setters obligatorios para JPA
}
