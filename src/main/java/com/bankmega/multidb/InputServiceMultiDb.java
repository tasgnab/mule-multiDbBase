
package com.bankmega.multidb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for input_ServiceMultiDb complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="input_ServiceMultiDb">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Signature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArrRequest" type="{http://multidb.service.ws.mega.com/ServiceMultiDb/input_ServiceMultiDb}ArrayOfRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input_ServiceMultiDb", namespace = "http://multidb.service.ws.mega.com/ServiceMultiDb/input_ServiceMultiDb", propOrder = {
    "serviceName",
    "clientId",
    "signature",
    "arrRequest"
})
public class InputServiceMultiDb {

    @XmlElement(name = "ServiceName", required = true, nillable = true)
    protected String serviceName;
    @XmlElement(name = "ClientId", required = true, nillable = true)
    protected String clientId;
    @XmlElement(name = "Signature", required = true, nillable = true)
    protected String signature;
    @XmlElement(name = "ArrRequest", required = true, nillable = true)
    protected ArrayOfRequest arrRequest;

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the clientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Gets the value of the arrRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRequest }
     *     
     */
    public ArrayOfRequest getArrRequest() {
        return arrRequest;
    }

    /**
     * Sets the value of the arrRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRequest }
     *     
     */
    public void setArrRequest(ArrayOfRequest value) {
        this.arrRequest = value;
    }

}
