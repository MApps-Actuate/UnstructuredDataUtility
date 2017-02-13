
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sentiment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sentiment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SentenceLevel" type="{}SentenceLevel" minOccurs="0"/>
 *         &lt;element name="DocumentLevel" type="{}DocumentLevel" minOccurs="0"/>
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
@XmlType(name = "Sentiment", propOrder = {
    "sentenceLevel",
    "documentLevel"
})
public class Sentiment {

    @XmlElement(name = "SentenceLevel")
    protected SentenceLevel sentenceLevel;
    @XmlElement(name = "DocumentLevel")
    protected DocumentLevel documentLevel;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the sentenceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link SentenceLevel }
     *     
     */
    public SentenceLevel getSentenceLevel() {
        return sentenceLevel;
    }

    /**
     * Sets the value of the sentenceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link SentenceLevel }
     *     
     */
    public void setSentenceLevel(SentenceLevel value) {
        this.sentenceLevel = value;
    }

    /**
     * Gets the value of the documentLevel property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentLevel }
     *     
     */
    public DocumentLevel getDocumentLevel() {
        return documentLevel;
    }

    /**
     * Sets the value of the documentLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentLevel }
     *     
     */
    public void setDocumentLevel(DocumentLevel value) {
        this.documentLevel = value;
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
