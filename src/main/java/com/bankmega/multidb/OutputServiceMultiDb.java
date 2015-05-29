
package com.bankmega.multidb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for output_ServiceMultiDb complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="output_ServiceMultiDb">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResponseDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TotalRow" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Record" type="{http://multidb.service.ws.mega.com/ServiceMultiDb}ArrayOf_apachesoap_Map"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output_ServiceMultiDb", namespace = "http://multidb.service.ws.mega.com/ServiceMultiDb/output_ServiceMultiDb", propOrder = {
    "responseCode",
    "responseDescription",
    "totalRow",
    "record"
})
public class OutputServiceMultiDb {

    @XmlElement(name = "ResponseCode", required = true, nillable = true)
    protected String responseCode;
    @XmlElement(name = "ResponseDescription", required = true, nillable = true)
    protected String responseDescription;
    @XmlElement(name = "TotalRow", required = true, nillable = true)
    protected String totalRow;
    @XmlElement(name = "Record", required = true, nillable = true)
    //protected ArrayOfApachesoapMap record;
    protected Map[] record;

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Sets the value of the responseDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDescription(String value) {
        this.responseDescription = value;
    }

    /**
     * Gets the value of the totalRow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalRow() {
        return totalRow;
    }

    /**
     * Sets the value of the totalRow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalRow(String value) {
        this.totalRow = value;
    }

    /**
     * Gets the value of the record property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfApachesoapMap }
     *     
     */
//    public ArrayOfApachesoapMap getRecord() {
//        return record;
//    }
    public Map[] getRecord() {
        return record;
    }

    /**
     * Sets the value of the record property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfApachesoapMap }
     *     
     */
//    public void setRecord(ArrayOfApachesoapMap value) {
//        this.record = value;
//    }
    public void setRecord(Map[] value) {
        this.record = value;
    }

}
