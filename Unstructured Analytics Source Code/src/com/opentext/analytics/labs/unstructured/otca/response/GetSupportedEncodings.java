
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetSupportedEncodings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetSupportedEncodings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Encodings" type="{}Encodings" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSupportedEncodings", propOrder = {
    "encodings"
})
public class GetSupportedEncodings {

    @XmlElement(name = "Encodings")
    protected Encodings encodings;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the encodings property.
     * 
     * @return
     *     possible object is
     *     {@link Encodings }
     *     
     */
    public Encodings getEncodings() {
        return encodings;
    }

    /**
     * Sets the value of the encodings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Encodings }
     *     
     */
    public void setEncodings(Encodings value) {
        this.encodings = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
