package org.taller.moduloDeTransferencia.interfase.remota.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.taller.moduloDeTransferencia.aplicacion.servicioDeposito;
import org.taller.moduloDeTransferencia.dominio.DataFecha;
import org.taller.moduloDeTransferencia.dominio.Deposito;
import org.taller.moduloDeTransferencia.interfase.remota.rest.NotificacionDepositoDTO;

@ApplicationScoped
@Path("/transferencia")
public class recibirNotificacionTransferenciaAPI {

    @Inject
    servicioDeposito SD;

    //curl -X POST http://localhost:8080/ProyectoJavaee/transferencia/notificacion \
    //-H "Content-Type: application/json" \
    // -d '{"idCompra": 1, "rutComercio": 123, "monto": 10000}'
    @POST
    @Path("/notificacion")
    public Response recibirNotificacion(NotificacionDepositoDTO dto) {
        SD.realizarDeposito(dto.getIdCompra(), dto.getRutComercio(), dto.getMonto());
        return Response.ok().build();
    }

    // curl -X POST http://localhost:8080/ProyectoJavaee/transferencia/listar \
    //-H "Content-Type: application/json" \
    //-d '{"rutComercio": 123, "dia": 22, "mes": 5, "anio": 2025}'
    @POST
    @Path("/listar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostrarDepositosFiltrados(FiltroDepositosDTO dto) {
        DataFecha fecha = new DataFecha(dto.getDia(), dto.getMes(), dto.getAnio());
        List<Deposito> depositos = SD.MostrarHistorialDeDepositos(dto.getRutComercio(), fecha);

        if (depositos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron depósitos para ese comercio y fecha.")
                        .build();
        }
        return Response.ok(depositos).build();
    }
}