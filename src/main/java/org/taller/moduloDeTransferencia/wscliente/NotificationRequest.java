
package org.taller.moduloDeTransferencia.wscliente;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotificationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotificationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idCompra" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rutComercio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationRequest", propOrder = {
    "idCompra",
    "rutComercio",
    "monto"
})
public class NotificationRequest {

    protected int idCompra;
    protected String rutComercio;
    protected float monto;

    /**
     * Gets the value of the idCompra property.
     * 
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * Sets the value of the idCompra property.
     * 
     */
    public void setIdCompra(int value) {
        this.idCompra = value;
    }

    /**
     * Gets the value of the rutComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutComercio() {
        return rutComercio;
    }

    /**
     * Sets the value of the rutComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutComercio(String value) {
        this.rutComercio = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     */
    public void setMonto(float value) {
        this.monto = value;
    }

}
