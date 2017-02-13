
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComplexConcepts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexConcepts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="RelevancyLevel" type="{}RelevancyLevel" minOccurs="0"/>
 *         &lt;element name="NumberOfComplexConcepts" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexConcepts", propOrder = {

})
public class ComplexConcepts {

    @XmlElement(name = "RelevancyLevel")
    @XmlSchemaType(name = "string")
    protected RelevancyLevel relevancyLevel;
    @XmlElement(name = "NumberOfComplexConcepts")
    protected Integer numberOfComplexConcepts;

    /**
     * Gets the value of the relevancyLevel property.
     * 
     * @return
     *     possible object is
     *     {@link RelevancyLevel }
     *     
     */
    public RelevancyLevel getRelevancyLevel() {
        return relevancyLevel;
    }

    /**
     * Sets the value of the relevancyLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelevancyLevel }
     *     
     */
    public void setRelevancyLevel(RelevancyLevel value) {
        this.relevancyLevel = value;
    }

    /**
     * Gets the value of the numberOfComplexConcepts property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfComplexConcepts() {
        return numberOfComplexConcepts;
    }

    /**
     * Sets the value of the numberOfComplexConcepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfComplexConcepts(Integer value) {
        this.numberOfComplexConcepts = value;
    }

}
