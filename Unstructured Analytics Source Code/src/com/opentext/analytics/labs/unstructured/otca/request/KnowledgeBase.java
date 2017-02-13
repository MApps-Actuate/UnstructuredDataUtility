
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KnowledgeBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KnowledgeBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="KBid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NumberOfCategories" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RejectedCategories" type="{}RejectedCategories" minOccurs="0"/>
 *         &lt;element name="OutputAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputParents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputParentsAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LegacyResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgeBase", propOrder = {

})
public class KnowledgeBase {

    @XmlElement(name = "KBid", required = true)
    protected String kBid;
    @XmlElement(name = "NumberOfCategories")
    protected Integer numberOfCategories;
    @XmlElement(name = "RejectedCategories")
    protected RejectedCategories rejectedCategories;
    @XmlElement(name = "OutputAttributes")
    protected Boolean outputAttributes;
    @XmlElement(name = "OutputParents")
    protected Boolean outputParents;
    @XmlElement(name = "OutputParentsAttributes")
    protected Boolean outputParentsAttributes;
    @XmlElement(name = "LegacyResult")
    protected Boolean legacyResult;

    /**
     * Gets the value of the kBid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKBid() {
        return kBid;
    }

    /**
     * Sets the value of the kBid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKBid(String value) {
        this.kBid = value;
    }

    /**
     * Gets the value of the numberOfCategories property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfCategories() {
        return numberOfCategories;
    }

    /**
     * Sets the value of the numberOfCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfCategories(Integer value) {
        this.numberOfCategories = value;
    }

    /**
     * Gets the value of the rejectedCategories property.
     * 
     * @return
     *     possible object is
     *     {@link RejectedCategories }
     *     
     */
    public RejectedCategories getRejectedCategories() {
        return rejectedCategories;
    }

    /**
     * Sets the value of the rejectedCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectedCategories }
     *     
     */
    public void setRejectedCategories(RejectedCategories value) {
        this.rejectedCategories = value;
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
     * Gets the value of the legacyResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLegacyResult() {
        return legacyResult;
    }

    /**
     * Sets the value of the legacyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLegacyResult(Boolean value) {
        this.legacyResult = value;
    }

}
