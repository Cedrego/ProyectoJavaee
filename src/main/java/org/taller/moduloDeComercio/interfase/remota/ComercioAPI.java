package org.taller.moduloDeComercio.interfase.remota;

import org.jboss.logging.Logger;
import org.taller.moduloDeComercio.aplicacion.InterfaceModuloComercio;
import org.taller.moduloDeComercio.dominio.DatosComercio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/comercio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComercioAPI {
    private static final Logger log = Logger.getLogger(ComercioAPI.class);

    @Inject
    private InterfaceModuloComercio servicio;

    // curl -X POST http://localhost:8080/proyecto-javaee/remota/comercio -H "Content-Type: application/json" -d '{"id":"123","nombre":"MiTienda","direccion":"C/Falsa","telefono":"0999","email":"a@b.com","contraseniaHash":"pass", "listaPOS":[]}'
    @POST
    public String altaComercio(ComercioDTO dto) {
        log.infof("Alta comercio: %s", dto);
        DatosComercio datos = dto.toDatosComercio();
        servicio.altaComercio(datos);
        return "OK";
    }

    // curl -X PUT http://localhost:8080/proyecto-javaee/remota/comercio -H "Content-Type: application/json" -d '{"id":"123","nombre":"Otro","direccion":"Av","telefono":"0999","email":"x@y.com","contraseniaHash":"pass", "listaPOS":[]}'
    @PUT
    public String modificarComercio(ComercioDTO dto) {
        log.infof("Modifica comercio: %s", dto);
        DatosComercio datos = dto.toDatosComercio();
        servicio.modificarDatosComercio(datos);
        return "OK";
    }

    // curl -X POST http://localhost:8080/proyecto-javaee/remota/comercio/123/pos/1
    @POST
    @Path("{id}/pos/{idPos}")
    public String altaPos(@PathParam("id") String id, @PathParam("idPos") int idPos) {
        log.infof("Alta POS %d a comercio %s", idPos, id);
        servicio.altaPos(id, idPos);
        return "OK";
    }

    // curl -X PUT "http://localhost:8080/proyecto-javaee/remota/comercio/123/pos/1/estado?habilitado=true"
    @PUT
    @Path("{id}/pos/{idPos}/estado")
    public String cambiarEstado(@PathParam("id") String id,
                                @PathParam("idPos") int idPos,
                                @QueryParam("habilitado") boolean h) {
        log.infof("Estado POS %d de %s → %b", idPos, id, h);
        servicio.cambiarEstadoPos(id, idPos, h);
        return "OK";
    }

    // curl -X PUT "http://localhost:8080/proyecto-javaee/remota/comercio/123/contrasenia?nuevaContrasenia=nueva"
    @PUT
    @Path("{id}/contrasenia")
    public String cambioContrasenia(@PathParam("id") String id,
                                    @QueryParam("nuevaContrasenia") String nueva) {
        log.infof("Cambio contraseña de %s", id);
        servicio.cambioContrasenia(id, nueva);
        return "OK";
    }

    // curl -X POST "http://localhost:8080/proyecto-javaee/remota/comercio/123/reclamo?texto=Problema"
    @POST
    @Path("{id}/reclamo")
    public String reclamo(@PathParam("id") String id,
                          @QueryParam("texto") String texto) {
        log.infof("Reclamo de %s : %s", id, texto);
        servicio.realizarReclamo(id, texto);
        return "OK";
    }
}