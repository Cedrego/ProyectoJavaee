// Lógica desacoplada de REST
package org.taller.moduloDeCompra.aplicacion.Impl;

import org.taller.moduloDeCompra.aplicacion.ModuloCompras;
import org.taller.moduloDeCompra.dominio.*;
import org.taller.moduloDeCompra.persistencia.ComercioService;
import org.taller.moduloDeCompra.persistencia.CompraService;

import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ModuloComprasImpl implements ModuloCompras {

    @Inject
    ComercioService comercioService;
    
    @Override
    public void procesarPago(DataCompra datosCompra) {
        int monto = Math.round(datosCompra.getImporte());
        enviarTransaccion(monto, datosCompra);

        String respuesta = esperarRespuesta();
        if (respuesta.startsWith("OK")) {
            notificarPagoOk();
        } else {
            notificarPagoError();
        }
    }

    private void enviarTransaccion(Integer monto, DataCompra datos) {
        System.out.println("Evento: enviarTransaccion(" + monto + ", " + datos + ")");
    }

    private String esperarRespuesta() {
        return "OK:123456";
    }

    private void notificarPagoOk() {
        System.out.println("Evento: notificarPagoOk");
    }

    private void notificarPagoError() {
        System.out.println("Evento: notificarPagoError");
    }

    @Override
    public List<DataCompra> resumenVentasDiarias(Integer idComercio) {
        Comercio comercio = comercioService.getComercioPorRut(idComercio);
        if (comercio == null) return null;
        DataFecha hoy = DataFecha.hoy();
        return comercio.getPosList().stream()
                .flatMap(pos -> pos.getCompras().stream())
                .filter(compra -> compra.getFecha().equals(hoy))
                .collect(Collectors.toList());
    }
    @Override
    public List<DataCompra> resumenVentasPorPeriodo(Integer idComercio, String fechaIni, String fechaEnd) {
        return CompraService.listarVentasPorPeriodo(idComercio, fechaIni, fechaEnd);
    }
    @Override
    public double montoActualVendido(Integer idComercio) {
        Comercio comercio = comercioService.getComercioPorRut(idComercio);
        if (comercio == null) return -1;
        DataFecha hoy = DataFecha.hoy();
        return comercio.getPosList().stream()
                .flatMap(pos -> pos.getCompras().stream())
                .filter(compra -> compra.getFecha().equals(hoy))
                .mapToDouble(Compra::getImporte)
                .sum();
    }
}
