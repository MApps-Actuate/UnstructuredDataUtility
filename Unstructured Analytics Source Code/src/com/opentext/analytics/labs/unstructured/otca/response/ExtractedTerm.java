
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtractedTerm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtractedTerm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nfinderNormalized" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientNormalized" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MainTerm" type="{}MainTerm" minOccurs="0"/>
 *         &lt;element name="Subterms" type="{}SubTerms" minOccurs="0"/>
 *         &lt;element name="Hierarchy" type="{}Hierarchy" minOccurs="0"/>
 *         &lt;element name="Homonyms" type="{}Homonyms" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CartridgeID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ConfidenceScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="RelevancyScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Frequency" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Subjectivity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SubjectivityConfidenceScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="SubjectivityScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="SubjectivityDistribution" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Tone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ToneConfidenceScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="PositiveToneScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="PositiveToneDistribution" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="NegativeToneScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="NegativeToneDistribution" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtractedTerm", propOrder = {
    "finderNormalized",
    "clientNormalized",
    "id",
    "mainTerm",
    "subTerms",
    "hierarchy",
    "homonyms"
})
public class ExtractedTerm {

    @XmlElement(name = "nfinderNormalized")
    protected String finderNormalized;
    @XmlElement(name = "ClientNormalized")
    protected String clientNormalized;
    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "MainTerm")
    protected MainTerm mainTerm;
    @XmlElement(name = "Subterms")
    protected SubTerms subTerms;
    @XmlElement(name = "Hierarchy")
    protected Hierarchy hierarchy;
    @XmlElement(name = "Homonyms")
    protected Homonyms homonyms;
    @XmlAttribute(name = "CartridgeID")
    protected String cartridgeID;
    @XmlAttribute(name = "ConfidenceScore")
    protected Float confidenceScore;
    @XmlAttribute(name = "RelevancyScore")
    protected Float relevancyScore;
    @XmlAttribute(name = "Frequency")
    protected Integer frequency;
    @XmlAttribute(name = "Subjectivity")
    protected String subjectivity;
    @XmlAttribute(name = "SubjectivityConfidenceScore")
    protected Float subjectivityConfidenceScore;
    @XmlAttribute(name = "SubjectivityScore")
    protected Float subjectivityScore;
    @XmlAttribute(name = "SubjectivityDistribution")
    protected Float subjectivityDistribution;
    @XmlAttribute(name = "Tone")
    protected String tone;
    @XmlAttribute(name = "ToneConfidenceScore")
    protected Float toneConfidenceScore;
    @XmlAttribute(name = "PositiveToneScore")
    protected Float positiveToneScore;
    @XmlAttribute(name = "PositiveToneDistribution")
    protected Float positiveToneDistribution;
    @XmlAttribute(name = "NegativeToneScore")
    protected Float negativeToneScore;
    @XmlAttribute(name = "NegativeToneDistribution")
    protected Float negativeToneDistribution;

    /**
     * Gets the value of the finderNormalized property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinderNormalized() {
        return finderNormalized;
    }

    /**
     * Sets the value of the finderNormalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinderNormalized(String value) {
        this.finderNormalized = value;
    }

    /**
     * Gets the value of the clientNormalized property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientNormalized() {
        return clientNormalized;
    }

    /**
     * Sets the value of the clientNormalized property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientNormalized(String value) {
        this.clientNormalized = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the mainTerm property.
     * 
     * @return
     *     possible object is
     *     {@link MainTerm }
     *     
     */
    public MainTerm getMainTerm() {
        return mainTerm;
    }

    /**
     * Sets the value of the mainTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link MainTerm }
     *     
     */
    public void setMainTerm(MainTerm value) {
        this.mainTerm = value;
    }

    /**
     * Gets the value of the subTerms property.
     * 
     * @return
     *     possible object is
     *     {@link SubTerms }
     *     
     */
    public SubTerms getSubTerms() {
        return subTerms;
    }

    /**
     * Sets the value of the subTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubTerms }
     *     
     */
    public void setSubTerms(SubTerms value) {
        this.subTerms = value;
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
     * Gets the value of the homonyms property.
     * 
     * @return
     *     possible object is
     *     {@link Homonyms }
     *     
     */
    public Homonyms getHomonyms() {
        return homonyms;
    }

    /**
     * Sets the value of the homonyms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Homonyms }
     *     
     */
    public void setHomonyms(Homonyms value) {
        this.homonyms = value;
    }

    /**
     * Gets the value of the cartridgeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCartridgeID() {
        return cartridgeID;
    }

    /**
     * Sets the value of the cartridgeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCartridgeID(String value) {
        this.cartridgeID = value;
    }

    /**
     * Gets the value of the confidenceScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getConfidenceScore() {
        return confidenceScore;
    }

    /**
     * Sets the value of the confidenceScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setConfidenceScore(Float value) {
        this.confidenceScore = value;
    }

    /**
     * Gets the value of the relevancyScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRelevancyScore() {
        return relevancyScore;
    }

    /**
     * Sets the value of the relevancyScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRelevancyScore(Float value) {
        this.relevancyScore = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrequency(Integer value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the subjectivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectivity() {
        return subjectivity;
    }

    /**
     * Sets the value of the subjectivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectivity(String value) {
        this.subjectivity = value;
    }

    /**
     * Gets the value of the subjectivityConfidenceScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSubjectivityConfidenceScore() {
        return subjectivityConfidenceScore;
    }

    /**
     * Sets the value of the subjectivityConfidenceScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSubjectivityConfidenceScore(Float value) {
        this.subjectivityConfidenceScore = value;
    }

    /**
     * Gets the value of the subjectivityScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSubjectivityScore() {
        return subjectivityScore;
    }

    /**
     * Sets the value of the subjectivityScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSubjectivityScore(Float value) {
        this.subjectivityScore = value;
    }

    /**
     * Gets the value of the subjectivityDistribution property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSubjectivityDistribution() {
        return subjectivityDistribution;
    }

    /**
     * Sets the value of the subjectivityDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSubjectivityDistribution(Float value) {
        this.subjectivityDistribution = value;
    }

    /**
     * Gets the value of the tone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTone() {
        return tone;
    }

    /**
     * Sets the value of the tone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTone(String value) {
        this.tone = value;
    }

    /**
     * Gets the value of the toneConfidenceScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getToneConfidenceScore() {
        return toneConfidenceScore;
    }

    /**
     * Sets the value of the toneConfidenceScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setToneConfidenceScore(Float value) {
        this.toneConfidenceScore = value;
    }

    /**
     * Gets the value of the positiveToneScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPositiveToneScore() {
        return positiveToneScore;
    }

    /**
     * Sets the value of the positiveToneScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPositiveToneScore(Float value) {
        this.positiveToneScore = value;
    }

    /**
     * Gets the value of the positiveToneDistribution property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPositiveToneDistribution() {
        return positiveToneDistribution;
    }

    /**
     * Sets the value of the positiveToneDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPositiveToneDistribution(Float value) {
        this.positiveToneDistribution = value;
    }

    /**
     * Gets the value of the negativeToneScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNegativeToneScore() {
        return negativeToneScore;
    }

    /**
     * Sets the value of the negativeToneScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNegativeToneScore(Float value) {
        this.negativeToneScore = value;
    }

    /**
     * Gets the value of the negativeToneDistribution property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNegativeToneDistribution() {
        return negativeToneDistribution;
    }

    /**
     * Sets the value of the negativeToneDistribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNegativeToneDistribution(Float value) {
        this.negativeToneDistribution = value;
    }

}
