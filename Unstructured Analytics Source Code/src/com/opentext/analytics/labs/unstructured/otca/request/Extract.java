
package com.opentext.analytics.labs.unstructured.otca.request;

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
 *         &lt;element name="Cartridges" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Cartridge" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OutputSubterms" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputParents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputParentsAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputHomonyms" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputHomonymsAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputHomonymsParents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Hierarchy" type="{}Hierarchy" minOccurs="0"/>
 *         &lt;element name="nsentiment" type="{}Sentiment"/>
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
    "cartridges",
    "outputSubterms",
    "outputAttributes",
    "outputParents",
    "outputParentsAttributes",
    "outputHomonyms",
    "outputHomonymsAttributes",
    "outputHomonymsParents",
    "hierarchy",
    "sentiment"
})
public class Extract {

    @XmlElement(name = "Cartridges")
    protected Extract.Cartridges cartridges;
    @XmlElement(name = "OutputSubterms")
    protected Boolean outputSubterms;
    @XmlElement(name = "OutputAttributes")
    protected Boolean outputAttributes;
    @XmlElement(name = "OutputParents")
    protected Boolean outputParents;
    @XmlElement(name = "OutputParentsAttributes")
    protected Boolean outputParentsAttributes;
    @XmlElement(name = "OutputHomonyms")
    protected Boolean outputHomonyms;
    @XmlElement(name = "OutputHomonymsAttributes")
    protected Boolean outputHomonymsAttributes;
    @XmlElement(name = "OutputHomonymsParents")
    protected Boolean outputHomonymsParents;
    @XmlElement(name = "Hierarchy")
    protected Hierarchy hierarchy;
    @XmlElement(name = "nsentiment", required = true)
    protected Sentiment sentiment;

    /**
     * Gets the value of the cartridges property.
     * 
     * @return
     *     possible object is
     *     {@link Extract.Cartridges }
     *     
     */
    public Extract.Cartridges getCartridges() {
        return cartridges;
    }

    /**
     * Sets the value of the cartridges property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extract.Cartridges }
     *     
     */
    public void setCartridges(Extract.Cartridges value) {
        this.cartridges = value;
    }

    /**
     * Gets the value of the outputSubterms property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputSubterms() {
        return outputSubterms;
    }

    /**
     * Sets the value of the outputSubterms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputSubterms(Boolean value) {
        this.outputSubterms = value;
    }

    /**
     * Gets the value of the outputAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputAttributes() {
        return outputAttributes;
    }

    /**
     * Sets the value of the outputAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputAttributes(Boolean value) {
        this.outputAttributes = value;
    }

    /**
     * Gets the value of the outputParents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputParents() {
        return outputParents;
    }

    /**
     * Sets the value of the outputParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputParents(Boolean value) {
        this.outputParents = value;
    }

    /**
     * Gets the value of the outputParentsAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputParentsAttributes() {
        return outputParentsAttributes;
    }

    /**
     * Sets the value of the outputParentsAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputParentsAttributes(Boolean value) {
        this.outputParentsAttributes = value;
    }

    /**
     * Gets the value of the outputHomonyms property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputHomonyms() {
        return outputHomonyms;
    }

    /**
     * Sets the value of the outputHomonyms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputHomonyms(Boolean value) {
        this.outputHomonyms = value;
    }

    /**
     * Gets the value of the outputHomonymsAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputHomonymsAttributes() {
        return outputHomonymsAttributes;
    }

    /**
     * Sets the value of the outputHomonymsAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputHomonymsAttributes(Boolean value) {
        this.outputHomonymsAttributes = value;
    }

    /**
     * Gets the value of the outputHomonymsParents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutputHomonymsParents() {
        return outputHomonymsParents;
    }

    /**
     * Sets the value of the outputHomonymsParents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutputHomonymsParents(Boolean value) {
        this.outputHomonymsParents = value;
    }

    /**
     * Gets the value of the hierarchy property.
     * 
     * @return
     *     possible object is
     *     {@link Hierarchy }
     *     
     */
    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    /**
     * Sets the value of the hierarchy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hierarchy }
     *     
     */
    public void setHierarchy(Hierarchy value) {
        this.hierarchy = value;
    }

    /**
     * Gets the value of the sentiment property.
     * 
     * @return
     *     possible object is
     *     {@link Sentiment }
     *     
     */
    public Sentiment getSentiment() {
        return sentiment;
    }

    /**
     * Sets the value of the sentiment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sentiment }
     *     
     */
    public void setSentiment(Sentiment value) {
        this.sentiment = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Cartridge" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cartridge"
    })
    public static class Cartridges {

        @XmlElement(name = "Cartridge")
        protected List<String> cartridge;

        /**
         * Gets the value of the cartridge property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cartridge property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCartridge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCartridge() {
            if (cartridge == null) {
                cartridge = new ArrayList<String>();
            }
            return this.cartridge;
        }

    }

}
