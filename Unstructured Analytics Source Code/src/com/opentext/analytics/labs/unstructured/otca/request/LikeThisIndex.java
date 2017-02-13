
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LikeThisIndex complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LikeThisIndex">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KBid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LikeThisIndex", propOrder = {
    "kBid"
})
public class LikeThisIndex {

    @XmlElement(name = "KBid", required = true)
    protected String kBid;

    /**
     * Gets the value of the kBid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKBid() {
        return kBid;
    }

    /**
     * Sets the value of the kBid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKBid(String value) {
        this.kBid = value;
    }

}
