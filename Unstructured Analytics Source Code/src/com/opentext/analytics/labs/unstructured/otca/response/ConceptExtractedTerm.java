
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConceptExtractedTerm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConceptExtractedTerm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="GenericForm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="Subterms" type="{}ConceptSubTerms"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Frequency" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Weight" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptExtractedTerm", propOrder = {
    "genericForm",
    "subTerms"
})
public class ConceptExtractedTerm {

    @XmlElement(name = "GenericForm")
    protected String genericForm;
    @XmlElement(name = "Subterms")
    protected ConceptSubTerms subTerms;
    @XmlAttribute(name = "Frequency")
    protected Integer frequency;
    @XmlAttribute(name = "Weight")
    protected Integer weight;

    /**
     * Gets the value of the genericForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericForm() {
        return genericForm;
    }

    /**
     * Sets the value of the genericForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericForm(String value) {
        this.genericForm = value;
    }

    /**
     * Gets the value of the subTerms property.
     * 
     * @return
     *     possible object is
     *     {@link ConceptSubTerms }
     *     
     */
    public ConceptSubTerms getSubTerms() {
        return subTerms;
    }

    /**
     * Sets the value of the subTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConceptSubTerms }
     *     
     */
    public void setSubTerms(ConceptSubTerms value) {
        this.subTerms = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrequency(Integer value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWeight(Integer value) {
        this.weight = value;
    }

}
