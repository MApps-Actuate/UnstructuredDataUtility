
package com.opentext.analytics.labs.unstructured.otca.request;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Categorizer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Categorizer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KBid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumberOfCategories" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RejectedCategories" type="{}RejectedCategories" minOccurs="0"/>
 *         &lt;element name="KnowledgeBase" type="{}KnowledgeBase" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Categorizer", propOrder = {
    "kBid",
    "numberOfCategories",
    "rejectedCategories",
    "knowledgeBase"
})
public class Categorizer {

    @XmlElement(name = "KBid")
    protected String kBid;
    @XmlElement(name = "NumberOfCategories")
    protected Integer numberOfCategories;
    @XmlElement(name = "RejectedCategories")
    protected RejectedCategories rejectedCategories;
    @XmlElement(name = "KnowledgeBase")
    protected List<KnowledgeBase> knowledgeBase;
    @XmlAttribute(name = "Name")
    protected String name;

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
     * Gets the value of the knowledgeBase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knowledgeBase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnowledgeBase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KnowledgeBase }
     * 
     * 
     */
    public List<KnowledgeBase> getKnowledgeBase() {
        if (knowledgeBase == null) {
            knowledgeBase = new ArrayList<KnowledgeBase>();
        }
        return this.knowledgeBase;
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
