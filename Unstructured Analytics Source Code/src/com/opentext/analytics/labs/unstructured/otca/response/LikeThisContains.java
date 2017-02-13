
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LikeThisContains complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LikeThisContains">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsTextIndexed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LikeThisContains", propOrder = {
    "isTextIndexed"
})
public class LikeThisContains {

    @XmlElement(name = "IsTextIndexed")
    protected int isTextIndexed;

    /**
     * Gets the value of the isTextIndexed property.
     * 
     */
    public int getIsTextIndexed() {
        return isTextIndexed;
    }

    /**
     * Sets the value of the isTextIndexed property.
     * 
     */
    public void setIsTextIndexed(int value) {
        this.isTextIndexed = value;
    }

}
