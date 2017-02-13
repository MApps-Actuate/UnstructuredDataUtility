
package com.opentext.analytics.labs.unstructured.otca.response;

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
 *       &lt;sequence>
 *         &lt;element name="KBid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelevancyScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Categories" type="{}Categories" minOccurs="0"/>
 *         &lt;element name="RejectedCategories" type="{}RejectedCategories" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgeBase", propOrder = {
    "kBid",
    "relevancyScore",
    "categories",
    "rejectedCategories"
})
public class KnowledgeBase {

    @XmlElement(name = "KBid")
    protected String kBid;
    @XmlElement(name = "RelevancyScore")
    protected Integer relevancyScore;
    @XmlElement(name = "Categories")
    protected Categories categories;
    @XmlElement(name = "RejectedCategories")
    protected RejectedCategories rejectedCategories;

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
     * Gets the value of the relevancyScore property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRelevancyScore() {
        return relevancyScore;
    }

    /**
     * Sets the value of the relevancyScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRelevancyScore(Integer value) {
        this.relevancyScore = value;
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link Categories }
     *     
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setCategories(Categories value) {
        this.categories = value;
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

}
