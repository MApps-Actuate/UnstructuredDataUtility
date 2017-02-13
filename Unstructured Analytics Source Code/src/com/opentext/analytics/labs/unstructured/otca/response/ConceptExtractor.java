
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConceptExtractor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConceptExtractor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComplexConcepts" type="{}Concepts" minOccurs="0"/>
 *         &lt;element name="SimpleConcepts" type="{}Concepts" minOccurs="0"/>
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
@XmlType(name = "ConceptExtractor", propOrder = {
    "complexConcepts",
    "simpleConcepts"
})
public class ConceptExtractor {

    @XmlElement(name = "ComplexConcepts")
    protected Concepts complexConcepts;
    @XmlElement(name = "SimpleConcepts")
    protected Concepts simpleConcepts;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the complexConcepts property.
     * 
     * @return
     *     possible object is
     *     {@link Concepts }
     *     
     */
    public Concepts getComplexConcepts() {
        return complexConcepts;
    }

    /**
     * Sets the value of the complexConcepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Concepts }
     *     
     */
    public void setComplexConcepts(Concepts value) {
        this.complexConcepts = value;
    }

    /**
     * Gets the value of the simpleConcepts property.
     * 
     * @return
     *     possible object is
     *     {@link Concepts }
     *     
     */
    public Concepts getSimpleConcepts() {
        return simpleConcepts;
    }

    /**
     * Sets the value of the simpleConcepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Concepts }
     *     
     */
    public void setSimpleConcepts(Concepts value) {
        this.simpleConcepts = value;
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
