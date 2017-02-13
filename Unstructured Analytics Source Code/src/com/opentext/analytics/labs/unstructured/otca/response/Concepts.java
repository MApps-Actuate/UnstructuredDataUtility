
package com.opentext.analytics.labs.unstructured.otca.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Concepts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Concepts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Concept" type="{}Concept" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="ExtractedTerm" type="{}ConceptExtractedTerm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Concepts", propOrder = {
    "concept",
    "extractedTerm"
})
public class Concepts {

    @XmlElement(name = "Concept")
    protected List<Concept> concept;
    @XmlElement(name = "ExtractedTerm")
    protected List<ConceptExtractedTerm> extractedTerm;

    /**
     * Gets the value of the concept property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concept property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcept().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Concept }
     * 
     * 
     */
    public List<Concept> getConcept() {
        if (concept == null) {
            concept = new ArrayList<Concept>();
        }
        return this.concept;
    }

    /**
     * Gets the value of the extractedTerm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extractedTerm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtractedTerm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConceptExtractedTerm }
     * 
     * 
     */
    public List<ConceptExtractedTerm> getExtractedTerm() {
        if (extractedTerm == null) {
            extractedTerm = new ArrayList<ConceptExtractedTerm>();
        }
        return this.extractedTerm;
    }

}
