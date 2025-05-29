package org.taller.moduloDeCompra.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.taller.moduloDeCompra.aplicacion.Impl.ModuloComprasImpl;
import org.taller.moduloDeCompra.dominio.DataCompra;

@Path("/api/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ModuloComprasRest {

    @Inject
    private ModuloComprasImpl moduloCompras;

    @GET
    @Path("/resumen-diario")
    public Response resumenVentasDiarias(@QueryParam("idcomercio") Integer idComercio) {
        try {
            return Response.ok(moduloCompras.resumenVentasDiarias(idComercio)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
    /*
     curl -X GET "http://localhost:8080/ProyectoJavaee/api/compras/resumen-diario?idcomercio=101" \
  -H "Accept: application/json"

     */

    @GET
    @Path("/resumen-Ventas-Periodo")
    public Response resumenVentasPorPeriodo(@QueryParam("idcomercio") Integer idComercio,
                                            @QueryParam("fechaini") String fechaIni,
                                            @QueryParam("fechaend") String fechaEnd) {
        try {
            return Response.ok(moduloCompras.resumenVentasPorPeriodo(idComercio, fechaIni, fechaEnd)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
/*
  curl -X GET "http://localhost:8080/ProyectoJavaee/api/compras/resumen-Ventas-Periodo?idcomercio=101&fechaini=01-05-2025&fechaend=20-05-2025" \
  -H "Accept: application/json"

 */

    @GET
    @Path("/monto-actual-vendido")
    public Response montoActualVendido(@QueryParam("idcomercio") Integer idComercio) {
        try {
            String json = moduloCompras.montoActualVendido(idComercio);
            return Response.ok(json).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
/*
curl -X GET "http://localhost:8080/ProyectoJavaee/api/compras/monto-actual-vendido?idcomercio=101" \
  -H "Accept: application/json"
 */

    @POST
    @Path("/procesar-pago")
    public Response procesarPago(DataCompra data) {
        try {
            moduloCompras.procesarPago(data);
            return Response.ok().entity("{\"estado\": \"Pago procesado\"}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }
/*
    curl -X POST http://localhost:8080/ProyectoJavaee/api/compras/procesar-pago \
  -H "Content-Type: application/json" \
  -d '{
        "id": 1,
        "importe": 1000.0,
        "fecha": { "dia": 21, "mes": 5, "anio": 2025 },
        "desc": "Pago de producto",
        "tarjeta": {
            "nro": "1234567890123456",
            "marca": "VISA"
        }
      }'
*/
}
