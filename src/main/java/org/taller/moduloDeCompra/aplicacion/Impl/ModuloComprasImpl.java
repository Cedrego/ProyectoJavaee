// Lógica desacoplada de REST
package org.taller.moduloDeCompra.aplicacion.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.taller.moduloDeCompra.aplicacion.ModuloCompras;
import org.taller.moduloDeCompra.dominio.Comercio;
import org.taller.moduloDeCompra.dominio.DataCompra;
import org.taller.moduloDeCompra.dominio.DataFecha;
import org.taller.moduloDeCompra.dominio.DataTarjeta;
import org.taller.moduloDeCompra.persistencia.ComercioService;
import org.taller.moduloDeCompra.persistencia.CompraService;
import org.taller.moduloDeCompra.persistencia.TarjetaService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ModuloComprasImpl implements ModuloCompras {

    @Inject
    ComercioService comercioService;
    
    @Inject
    private CompraService compraService;
    @Inject
    private TarjetaService tarjetaservice;

    @Override
    public void procesarPago(DataCompra datosCompra) {
        int monto = Math.round(datosCompra.getImporte());
        enviarTransaccion(monto, datosCompra);

        String respuesta = esperarRespuesta();
        if (respuesta.startsWith("OK")) {
            notificarPagoOk();
            // En tu método procesarPago:
            DataTarjeta tarjetaPersistida = tarjetaservice.guardarSiNoExiste(datosCompra.getTarjeta());
            datosCompra.setTarjeta(tarjetaPersistida);
            DataFecha fechaHoy = DataFecha.hoy();
            datosCompra.setFecha(fechaHoy);

            //Persistir la compra
            compraService.guardar(datosCompra);
            System.out.println("Despues de guardar compra" );
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
    public List<DataCompra> resumenVentasDiarias(String idComercio) {
        // Obtener el compras por RUT de Comercio
        List<DataCompra> compras = compraService.listarComprasPorRutComercio(idComercio);
        if (compras == null || compras.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron compras para el comercio con RUT: " + idComercio);
        }
        // Filtrar las compras del día de hoy y sumar sus importes
        DataFecha hoy = DataFecha.hoy();
        return compras.stream()
        .filter(compra -> compra.getFecha().equals(hoy))
        .collect(Collectors.toList());
       
    }

    @Override
    public List<DataCompra> resumenVentasPorPeriodo(String idComercio, String fechaIni, String fechaEnd) {
        // Validar que las fechas no sean nulas o vacías
        if (fechaIni == null || fechaIni.isEmpty() || fechaEnd == null || fechaEnd.isEmpty()) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no pueden ser nulas o vacías.");
        }
        // Validar que el idComercio no sea nulo
        if (idComercio == null) {
            throw new IllegalArgumentException("El id del comercio no puede ser nulo.");
        }
        return compraService.listarVentasPorPeriodo(idComercio, fechaIni, fechaEnd);
    }

    @Override
    public float montoActualVendido(String idComercio) {
        // Obtener el compras por RUT de Comercio
        List<DataCompra> compras = compraService.listarComprasPorRutComercio(idComercio);
        if (compras == null || compras.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron compras para el comercio con RUT: " + idComercio);
        }
        // Filtrar las compras del día de hoy y sumar sus importes
        DataFecha hoy = DataFecha.hoy();
        double total = compras.stream()
            .filter(compra -> compra.getFecha().equals(hoy))
            .mapToDouble(DataCompra::getImporte)
            .sum();
        return (float) total;
    }


}
