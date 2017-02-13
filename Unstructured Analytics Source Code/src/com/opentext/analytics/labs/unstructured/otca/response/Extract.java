
package com.opentext.analytics.labs.unstructured.otca.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Extract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Extract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtractedTerm" type="{}ExtractedTerm" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extract", propOrder = {
    "extractedTerm"
})
public class Extract {

    @XmlElement(name = "ExtractedTerm")
    protected List<ExtractedTerm> extractedTerm;

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
     * {@link ExtractedTerm }
     * 
     * 
     */
    public List<ExtractedTerm> getExtractedTerm() {
        if (extractedTerm == null) {
            extractedTerm = new ArrayList<ExtractedTerm>();
        }
        return this.extractedTerm;
    }

}
