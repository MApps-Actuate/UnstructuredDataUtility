
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LikeThisSize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LikeThisSize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NbDocuments" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LikeThisSize", propOrder = {
    "nbDocuments"
})
public class LikeThisSize {

    @XmlElement(name = "NbDocuments")
    protected int nbDocuments;

    /**
     * Gets the value of the nbDocuments property.
     * 
     */
    public int getNbDocuments() {
        return nbDocuments;
    }

    /**
     * Sets the value of the nbDocuments property.
     * 
     */
    public void setNbDocuments(int value) {
        this.nbDocuments = value;
    }

}
