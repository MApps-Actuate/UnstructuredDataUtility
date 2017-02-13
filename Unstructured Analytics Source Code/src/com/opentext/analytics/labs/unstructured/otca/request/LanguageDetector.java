
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LanguageDetector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LanguageDetector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{}LanguageDetectorMode" minOccurs="0"/>
 *         &lt;element name="OutputParagraphs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "LanguageDetector", propOrder = {
    "mode",
    "outputParagraphs"
})
public class LanguageDetector {

    @XmlElement(name = "Mode")
    @XmlSchemaType(name = "string")
    protected LanguageDetectorMode mode;
    @XmlElement(name = "OutputParagraphs")
    protected Boolean outputParagraphs;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageDetectorMode }
     *     
     */
    public LanguageDetectorMode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageDetectorMode }
     *     
     */
    public void setMode(LanguageDetectorMode value) {
        this.mode = value;
    }

    /**
     * Gets the value of the outputParagraphs property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputParagraphs() {
        return outputParagraphs;
    }

    /**
     * Sets the value of the outputParagraphs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputParagraphs(Boolean value) {
        this.outputParagraphs = value;
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
