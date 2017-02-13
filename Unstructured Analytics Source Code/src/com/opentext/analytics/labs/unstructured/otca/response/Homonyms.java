
package com.opentext.analytics.labs.unstructured.otca.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Homonyms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Homonyms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Homonym" type="{}Homonym" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Homonyms", propOrder = {
    "homonym"
})
public class Homonyms {

    @XmlElement(name = "Homonym")
    protected List<Homonym> homonym;

    /**
     * Gets the value of the homonym property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the homonym property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHomonym().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Homonym }
     * 
     * 
     */
    public List<Homonym> getHomonym() {
        if (homonym == null) {
            homonym = new ArrayList<Homonym>();
        }
        return this.homonym;
    }

}
