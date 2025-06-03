package com.ejemplo.medio_pago;

public class PagoResponse {
    public boolean autorizado;
    public String codigo;

    public PagoResponse(boolean autorizado, String codigo) {
        this.autorizado = autorizado;
        this.codigo = codigo;
    }
}