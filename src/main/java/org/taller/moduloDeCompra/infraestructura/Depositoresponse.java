package org.taller.moduloDeCompra.infraestructura;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement // Necesario para serialización/deserialización
@XmlAccessorType(XmlAccessType.FIELD) // Hace que use los atributos directamente
public class Depositoresponse {
    public Depositoresponse() {
    }
    @Override
    public String toString() {
        return "Deposito relizado con éxito";
    }
}
