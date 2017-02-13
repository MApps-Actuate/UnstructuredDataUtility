
package com.opentext.analytics.labs.unstructured.otca.request;

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
 *           &lt;element name="Index" type="{}LikeThisIndex"/>
 *           &lt;element name="IsTextIndexed" type="{}LikeThisIsTextIndexed"/>
 *           &lt;element name="Compare" type="{}LikeThisCompare"/>
 *           &lt;element name="Delete" type="{}LikeThisDelete"/>
 *           &lt;element name="Optimize" type="{}LikeThisOptimize"/>
 *           &lt;element name="GetAllIds" type="{}LikeThisGetAllIds"/>
 *           &lt;element name="GetStats" type="{}LikeThisGetStats"/>
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
    "index",
    "isTextIndexed",
    "compare",
    "delete",
    "optimize",
    "getAllIds",
    "getStats"
})
public class LikeThis {

    @XmlElement(name = "Index")
    protected LikeThisIndex index;
    @XmlElement(name = "IsTextIndexed")
    protected LikeThisIsTextIndexed isTextIndexed;
    @XmlElement(name = "Compare")
    protected LikeThisCompare compare;
    @XmlElement(name = "Delete")
    protected LikeThisDelete delete;
    @XmlElement(name = "Optimize")
    protected LikeThisOptimize optimize;
    @XmlElement(name = "GetAllIds")
    protected LikeThisGetAllIds getAllIds;
    @XmlElement(name = "GetStats")
    protected LikeThisGetStats getStats;
    @XmlAttribute(name = "Name")
    protected String name;

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisIndex }
     *     
     */
    public LikeThisIndex getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisIndex }
     *     
     */
    public void setIndex(LikeThisIndex value) {
        this.index = value;
    }

    /**
     * Gets the value of the isTextIndexed property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisIsTextIndexed }
     *     
     */
    public LikeThisIsTextIndexed getIsTextIndexed() {
        return isTextIndexed;
    }

    /**
     * Sets the value of the isTextIndexed property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisIsTextIndexed }
     *     
     */
    public void setIsTextIndexed(LikeThisIsTextIndexed value) {
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
     * Gets the value of the delete property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisDelete }
     *     
     */
    public LikeThisDelete getDelete() {
        return delete;
    }

    /**
     * Sets the value of the delete property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisDelete }
     *     
     */
    public void setDelete(LikeThisDelete value) {
        this.delete = value;
    }

    /**
     * Gets the value of the optimize property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisOptimize }
     *     
     */
    public LikeThisOptimize getOptimize() {
        return optimize;
    }

    /**
     * Sets the value of the optimize property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisOptimize }
     *     
     */
    public void setOptimize(LikeThisOptimize value) {
        this.optimize = value;
    }

    /**
     * Gets the value of the getAllIds property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisGetAllIds }
     *     
     */
    public LikeThisGetAllIds getGetAllIds() {
        return getAllIds;
    }

    /**
     * Sets the value of the getAllIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisGetAllIds }
     *     
     */
    public void setGetAllIds(LikeThisGetAllIds value) {
        this.getAllIds = value;
    }

    /**
     * Gets the value of the getStats property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThisGetStats }
     *     
     */
    public LikeThisGetStats getGetStats() {
        return getStats;
    }

    /**
     * Sets the value of the getStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThisGetStats }
     *     
     */
    public void setGetStats(LikeThisGetStats value) {
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
