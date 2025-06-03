// Lógica desacoplada de REST
package org.taller.moduloDeCompra.aplicacion.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.taller.moduloDeCompra.aplicacion.ModuloCompras;
import org.taller.moduloDeCompra.dominio.Comercio;
import org.taller.moduloDeCompra.dominio.DataCompra;
import org.taller.moduloDeCompra.dominio.DataFecha;
import org.taller.moduloDeCompra.persistencia.ComercioService;
import org.taller.moduloDeCompra.persistencia.CompraService;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
@ApplicationScoped
public class ModuloComprasImpl implements ModuloCompras {

    @Inject
    ComercioService comercioService;
    @Inject
    CompraService compraService;

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
        if (comercio == null) return List.of(); // Evita null
        DataFecha hoy = DataFecha.hoy();
        return comercio.getCompras().stream()
                .filter(compra -> compra.getFecha().equals(hoy))
                .collect(Collectors.toList());
    }

    @Override
    public List<DataCompra> resumenVentasPorPeriodo(Integer idComercio, String fechaIni, String fechaEnd) {
        return compraService.listarVentasPorPeriodo(idComercio, fechaIni, fechaEnd);
    }
    @Override
    public float montoActualVendido(Integer idComercio) {
        Comercio comercio = comercioService.getComercioPorRut(idComercio);
        if (comercio == null) return -1f;
        DataFecha hoy = DataFecha.hoy();
        return (float) comercio.getCompras().stream()
                .filter(compra -> compra.getFecha().equals(hoy))
                .mapToDouble(DataCompra::getImporte)
                .sum();
    }


}
