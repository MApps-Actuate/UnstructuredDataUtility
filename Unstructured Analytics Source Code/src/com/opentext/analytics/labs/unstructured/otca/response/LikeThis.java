
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LikeThis complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LikeThis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="IsTextIndexed" type="{}LikeThisContains"/>
 *           &lt;element name="Compare" type="{}LikeThisCompare"/>
 *           &lt;element name="GetAllIds" type="{}LikeThisList"/>
 *           &lt;element name="GetStats" type="{}LikeThisSize"/>
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
@XmlType(name = "LikeThis", propOrder = {
    "isTextIndexed",
    "compare",
    "getAllIds",
    "getStats"
})
public class LikeThis {

    @XmlElement(name = "IsTextIndexed")
    protected LikeThisContains isTextIndexed;
    @XmlElement(name = "Compare")
    protected LikeThisCompare compare;
    @XmlElement(name = "GetAllIds")
    protected LikeThisList getAllIds;
    @XmlElement(name = "GetStats")
    protected LikeThisSize getStats;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the isTextIndexed property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisContains }
     *     
     */
    public LikeThisContains getIsTextIndexed() {
        return isTextIndexed;
    }

    /**
     * Sets the value of the isTextIndexed property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisContains }
     *     
     */
    public void setIsTextIndexed(LikeThisContains value) {
        this.isTextIndexed = value;
    }

    /**
     * Gets the value of the compare property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisCompare }
     *     
     */
    public LikeThisCompare getCompare() {
        return compare;
    }

    /**
     * Sets the value of the compare property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisCompare }
     *     
     */
    public void setCompare(LikeThisCompare value) {
        this.compare = value;
    }

    /**
     * Gets the value of the getAllIds property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisList }
     *     
     */
    public LikeThisList getGetAllIds() {
        return getAllIds;
    }

    /**
     * Sets the value of the getAllIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisList }
     *     
     */
    public void setGetAllIds(LikeThisList value) {
        this.getAllIds = value;
    }

    /**
     * Gets the value of the getStats property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisSize }
     *     
     */
    public LikeThisSize getGetStats() {
        return getStats;
    }

    /**
     * Sets the value of the getStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisSize }
     *     
     */
    public void setGetStats(LikeThisSize value) {
        this.getStats = value;
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
