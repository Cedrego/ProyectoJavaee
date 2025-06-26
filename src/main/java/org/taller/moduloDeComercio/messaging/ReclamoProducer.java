package org.taller.moduloDeComercio.messaging;

import java.util.Queue;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.*;

@ApplicationScoped
public class ReclamoProducer {

    @Resource(lookup = "java:/jms/queue/ReclamosQueue")
    private Queue<Object> reclamosQueue;

    @Inject
    private JMSContext jmsContext;

    public void enviarReclamo(String textoReclamo) {
        try {
            jmsContext.createProducer().send((Destination) reclamosQueue, textoReclamo);
            System.out.println("Reclamo enviado a la queue: " + textoReclamo);
        } catch (Exception e) {
            System.err.println("Error al enviar el reclamo: " + e.getMessage());
        }
    }
}