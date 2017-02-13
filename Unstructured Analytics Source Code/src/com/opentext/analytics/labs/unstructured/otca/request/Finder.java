
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Finder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Finder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="nfExtract" type="{}Extract"/>
 *           &lt;element name="nfFullTextSearch" type="{}FullTextSearch"/>
 *         &lt;/choice>
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
@XmlType(name = "Finder", propOrder = {
    "extract",
    "fullTextSearch"
})
public class Finder {

    @XmlElement(name = "nfExtract")
    protected Extract extract;
    @XmlElement(name = "nfFullTextSearch")
    protected FullTextSearch fullTextSearch;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the extract property.
     * 
     * @return
     *     possible object is
     *     {@link Extract }
     *     
     */
    public Extract getExtract() {
        return extract;
    }

    /**
     * Sets the value of the extract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extract }
     *     
     */
    public void setExtract(Extract value) {
        this.extract = value;
    }

    /**
     * Gets the value of the fullTextSearch property.
     * 
     * @return
     *     possible object is
     *     {@link FullTextSearch }
     *     
     */
    public FullTextSearch getFullTextSearch() {
        return fullTextSearch;
    }

    /**
     * Sets the value of the fullTextSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullTextSearch }
     *     
     */
    public void setFullTextSearch(FullTextSearch value) {
        this.fullTextSearch = value;
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
