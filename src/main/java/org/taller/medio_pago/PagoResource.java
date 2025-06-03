package com.ejemplo.medio_pago;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.*;

@Path("/pagos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagoResource {

    private static final Set<String> TARJETAS_SIEMPRE_OK = Set.of("1111222233334444", "5555666677778888");
    private static final Set<String> TARJETAS_SIEMPRE_ERROR = Set.of("9999000011112222");
    private static final Random random = new Random();



    /*se llama con
	curl -X POST http://localhost:8080/ProyectoJavaee/api/pagos      -H "Content-Type: application/json"      -d 	'{"numeroTarjeta":"1111222233334444", "monto":100}'*/
	 	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PagoResponse procesarPago(PagoRequest request) {
        String tarjeta = request.numeroTarjeta;

        if (TARJETAS_SIEMPRE_OK.contains(tarjeta)) {
            return new PagoResponse(true, generarCodigoAutorizacion());
        } else if (TARJETAS_SIEMPRE_ERROR.contains(tarjeta)) {
            return new PagoResponse(false, "ERR-001");
        }

        boolean aprobado = random.nextInt(6) < 5;

        if (aprobado) {
            return new PagoResponse(true, generarCodigoAutorizacion());
        } else {
            return new PagoResponse(false, "ERR-" + (100 + random.nextInt(900)));
        }
    }

    private String generarCodigoAutorizacion() {
        return "AUTH-" + (100000 + random.nextInt(900000));
    }
}
