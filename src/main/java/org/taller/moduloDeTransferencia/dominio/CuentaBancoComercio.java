package org.taller.moduloDeTransferencia.dominio;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSFERENCIA_CUENTA_BANCO_COMERCIO")
public class CuentaBancoComercio {
    @Id
    private int nroCuenta;

    @OneToOne
    @JoinColumn(name = "rut_comercio", referencedColumnName = "rut")
    private Comercio comercio;     // RUT del comercio
    
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Deposito> listaDepositos = new ArrayList<>(); // Lista de depósitos asociados a la cuenta
    
    public void addDeposito(Deposito deposito) {
        this.listaDepositos.add(deposito);
    }
}
