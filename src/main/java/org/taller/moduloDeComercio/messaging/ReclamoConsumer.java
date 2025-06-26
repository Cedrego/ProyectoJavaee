package org.taller.moduloDeComercio.messaging;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.taller.moduloDeComercio.dominio.ReclamoComercio;
import org.taller.moduloDeComercio.interfase.eventos.out.PublicadorEvento;
import org.taller.moduloDeComercio.repositorio.RepositorioReclamoComercio;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/ReclamosQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class ReclamoConsumer implements MessageListener {

    @Inject
    private RepositorioReclamoComercio repositorioReclamoComercio;

    @Inject
    private PublicadorEvento evento;

    private static final String ETIQUETADO_API_URL = "http://localhost:8080/EtiquetadoAPI/api/etiquetar";

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String json = ((TextMessage) message).getText();

                // Parsear JSON con regex
                Pattern pattern = Pattern.compile("\"rutComercio\":\"(.*?)\",\"textoReclamo\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(json);

                if (matcher.find()) {
                    String rutComercio = matcher.group(1);
                    String textoReclamo = matcher.group(2);

                    String etiqueta = obtenerEtiqueta(textoReclamo);

                    ReclamoComercio reclamo = new ReclamoComercio();
                    reclamo.setDescripcionReclamo(textoReclamo);
                    reclamo.setEtiqueta(etiqueta);
                    reclamo.setRutComercio(rutComercio);

                    repositorioReclamoComercio.guardarR(reclamo);
                    evento.publicarReclamo("Reclamo procesado: " + textoReclamo + " | Etiqueta: " + etiqueta + " | Comercio: " + rutComercio);
                    System.out.println("Reclamo procesado: " + textoReclamo + " | Etiqueta: " + etiqueta + " | Comercio: " + rutComercio);
                } else {
                    System.err.println("Error: mensaje JSON no tiene el formato esperado");
                }
            }
        } catch (Exception e) {
            System.err.println("Error al procesar el mensaje: " + e.getMessage());
        }
    }

    private String obtenerEtiqueta(String textoReclamo) {
        try {
            Client client = ClientBuilder.newClient();
            Response response = client.target(ETIQUETADO_API_URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(textoReclamo, MediaType.APPLICATION_JSON));

            if (response.getStatus() == 200) {
                return response.readEntity(String.class);
            } else {
                System.err.println("Error al obtener etiqueta desde EtiquetadoAPI: " + response.getStatus());
                return "NEUTRO";
            }
        } catch (Exception e) {
            System.err.println("Error al comunicarse con EtiquetadoAPI: " + e.getMessage());
            return "NEUTRO";
        }
    }
}
