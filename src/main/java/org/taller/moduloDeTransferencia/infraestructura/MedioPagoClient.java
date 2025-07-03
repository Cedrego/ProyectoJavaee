package org.taller.moduloDeTransferencia.infraestructura;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class MedioPagoClient {

    private static final String BASE_URL = "http://localhost:8080/ServicioMedioPagoMock/api/notificarDeposito";

    public Depositoresponse realizarDeposito(DepositoRequest request) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200) {
            return response.readEntity(Depositoresponse.class);
        } else {
            throw new RuntimeException("Error al realizar el depósito: " + response.getStatus());
        }
    }
    
}