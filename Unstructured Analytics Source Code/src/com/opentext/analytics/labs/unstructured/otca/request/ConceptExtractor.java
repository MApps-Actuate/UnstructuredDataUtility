
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;all>
 *         &lt;element name="Mode" type="{}ConceptExtractorMode" minOccurs="0"/>
 *         &lt;element name="ComplexConcepts" type="{}ComplexConcepts" minOccurs="0"/>
 *         &lt;element name="SimpleConcepts" type="{}SimpleConcepts" minOccurs="0"/>
 *         &lt;element name="ExcludeEntities" type="{}ExcludeEntities" minOccurs="0"/>
 *         &lt;element name="ResultLayout" type="{}ResultLayout" minOccurs="0"/>
 *       &lt;/all>
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

})
public class ConceptExtractor {

    @XmlElement(name = "Mode")
    @XmlSchemaType(name = "string")
    protected ConceptExtractorMode mode;
    @XmlElement(name = "ComplexConcepts")
    protected ComplexConcepts complexConcepts;
    @XmlElement(name = "SimpleConcepts")
    protected SimpleConcepts simpleConcepts;
    @XmlElement(name = "ExcludeEntities")
    protected ExcludeEntities excludeEntities;
    @XmlElement(name = "ResultLayout")
    @XmlSchemaType(name = "string")
    protected ResultLayout resultLayout;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link ConceptExtractorMode }
     *     
     */
    public ConceptExtractorMode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConceptExtractorMode }
     *     
     */
    public void setMode(ConceptExtractorMode value) {
        this.mode = value;
    }

    /**
     * Gets the value of the complexConcepts property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexConcepts }
     *     
     */
    public ComplexConcepts getComplexConcepts() {
        return complexConcepts;
    }

    /**
     * Sets the value of the complexConcepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexConcepts }
     *     
     */
    public void setComplexConcepts(ComplexConcepts value) {
        this.complexConcepts = value;
    }

    /**
     * Gets the value of the simpleConcepts property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleConcepts }
     *     
     */
    public SimpleConcepts getSimpleConcepts() {
        return simpleConcepts;
    }

    /**
     * Sets the value of the simpleConcepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleConcepts }
     *     
     */
    public void setSimpleConcepts(SimpleConcepts value) {
        this.simpleConcepts = value;
    }

    /**
     * Gets the value of the excludeEntities property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludeEntities }
     *     
     */
    public ExcludeEntities getExcludeEntities() {
        return excludeEntities;
    }

    /**
     * Sets the value of the excludeEntities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludeEntities }
     *     
     */
    public void setExcludeEntities(ExcludeEntities value) {
        this.excludeEntities = value;
    }

    /**
     * Gets the value of the resultLayout property.
     * 
     * @return
     *     possible object is
     *     {@link ResultLayout }
     *     
     */
    public ResultLayout getResultLayout() {
        return resultLayout;
    }

    /**
     * Sets the value of the resultLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultLayout }
     *     
     */
    public void setResultLayout(ResultLayout value) {
        this.resultLayout = value;
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
