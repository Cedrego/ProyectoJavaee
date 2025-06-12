
package org.taller.moduloDeTransferencia.wscliente;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.taller.moduloDeTransferencia.wscliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NotificarTransferencia_QNAME = new QName("http://ws.bancoClienteMock.taller.org/", "NotificarTransferencia");
    private final static QName _NotificarTransferenciaResponse_QNAME = new QName("http://ws.bancoClienteMock.taller.org/", "NotificarTransferenciaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.taller.moduloDeTransferencia.wscliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotificarTransferencia }
     * 
     */
    public NotificarTransferencia createNotificarTransferencia() {
        return new NotificarTransferencia();
    }

    /**
     * Create an instance of {@link NotificarTransferenciaResponse }
     * 
     */
    public NotificarTransferenciaResponse createNotificarTransferenciaResponse() {
        return new NotificarTransferenciaResponse();
    }

    /**
     * Create an instance of {@link NotificationRequest }
     * 
     */
    public NotificationRequest createNotificationRequest() {
        return new NotificationRequest();
    }

    /**
     * Create an instance of {@link ConfirmationResponse }
     * 
     */
    public ConfirmationResponse createConfirmationResponse() {
        return new ConfirmationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificarTransferencia }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotificarTransferencia }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.bancoClienteMock.taller.org/", name = "NotificarTransferencia")
    public JAXBElement<NotificarTransferencia> createNotificarTransferencia(NotificarTransferencia value) {
        return new JAXBElement<NotificarTransferencia>(_NotificarTransferencia_QNAME, NotificarTransferencia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificarTransferenciaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotificarTransferenciaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.bancoClienteMock.taller.org/", name = "NotificarTransferenciaResponse")
    public JAXBElement<NotificarTransferenciaResponse> createNotificarTransferenciaResponse(NotificarTransferenciaResponse value) {
        return new JAXBElement<NotificarTransferenciaResponse>(_NotificarTransferenciaResponse_QNAME, NotificarTransferenciaResponse.class, null, value);
    }

}
