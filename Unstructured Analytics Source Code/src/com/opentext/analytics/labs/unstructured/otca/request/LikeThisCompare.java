
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LikeThisCompare complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LikeThisCompare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="KBid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NumberOfMatchedFiles" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="EnableFastSearch" type="{}EnabledFastSearch" minOccurs="0"/>
 *         &lt;element name="NoIndexing" type="{}NoIndexing" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LikeThisCompare", propOrder = {

})
public class LikeThisCompare {

    @XmlElement(name = "KBid", required = true)
    protected String kBid;
    @XmlElement(name = "NumberOfMatchedFiles")
    protected Integer numberOfMatchedFiles;
    @XmlElement(name = "EnableFastSearch")
    protected EnabledFastSearch enableFastSearch;
    @XmlElement(name = "NoIndexing")
    protected NoIndexing noIndexing;

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
     * Gets the value of the numberOfMatchedFiles property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfMatchedFiles() {
        return numberOfMatchedFiles;
    }

    /**
     * Sets the value of the numberOfMatchedFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfMatchedFiles(Integer value) {
        this.numberOfMatchedFiles = value;
    }

    /**
     * Gets the value of the enableFastSearch property.
     * 
     * @return
     *     possible object is
     *     {@link EnabledFastSearch }
     *     
     */
    public EnabledFastSearch getEnableFastSearch() {
        return enableFastSearch;
    }

    /**
     * Sets the value of the enableFastSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnabledFastSearch }
     *     
     */
    public void setEnableFastSearch(EnabledFastSearch value) {
        this.enableFastSearch = value;
    }

    /**
     * Gets the value of the noIndexing property.
     * 
     * @return
     *     possible object is
     *     {@link NoIndexing }
     *     
     */
    public NoIndexing getNoIndexing() {
        return noIndexing;
    }

    /**
     * Sets the value of the noIndexing property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoIndexing }
     *     
     */
    public void setNoIndexing(NoIndexing value) {
        this.noIndexing = value;
    }

}
