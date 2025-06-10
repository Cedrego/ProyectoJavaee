package org.taller.moduloDeTransferencia.interfase.remota.rest;
import lombok.Data;

@Data
public class FiltroDepositosDTO {
    private int dia;
    private int mes;
    private int anio;
}
