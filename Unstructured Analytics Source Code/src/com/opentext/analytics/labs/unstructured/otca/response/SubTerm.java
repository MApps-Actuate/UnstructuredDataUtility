
package com.opentext.analytics.labs.unstructured.otca.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for SubTerm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubTerm">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Position" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Length" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Candidate" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Subjectivity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SubjectivityConfidenceScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="SubjectivityScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Tone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ToneConfidenceScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="PositiveToneScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="NegativeToneScore" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="SentenceBeginIndex" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SentenceEndIndex" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Sentence" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubTerm", propOrder = {
    "value"
})
public class SubTerm {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "Position", required = true)
    protected int position;
    @XmlAttribute(name = "Length", required = true)
    protected int length;
    @XmlAttribute(name = "Candidate")
    protected Integer candidate;
    @XmlAttribute(name = "Subjectivity")
    protected String subjectivity;
    @XmlAttribute(name = "SubjectivityConfidenceScore")
    protected Float subjectivityConfidenceScore;
    @XmlAttribute(name = "SubjectivityScore")
    protected Float subjectivityScore;
    @XmlAttribute(name = "Tone")
    protected String tone;
    @XmlAttribute(name = "ToneConfidenceScore")
    protected Float toneConfidenceScore;
    @XmlAttribute(name = "PositiveToneScore")
    protected Float positiveToneScore;
    @XmlAttribute(name = "NegativeToneScore")
    protected Float negativeToneScore;
    @XmlAttribute(name = "SentenceBeginIndex")
    protected Integer sentenceBeginIndex;
    @XmlAttribute(name = "SentenceEndIndex")
    protected Integer sentenceEndIndex;
    @XmlAttribute(name = "Sentence")
    protected String sentence;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
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
     * Gets the value of the position property.
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     */
    public void setPosition(int value) {
        this.position = value;
    }

    /**
     * Gets the value of the length property.
     * 
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     */
    public void setLength(int value) {
        this.length = value;
    }

    /**
     * Gets the value of the candidate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCandidate() {
        return candidate;
    }

    /**
     * Sets the value of the candidate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCandidate(Integer value) {
        this.candidate = value;
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
     * Gets the value of the sentenceBeginIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSentenceBeginIndex() {
        return sentenceBeginIndex;
    }

    /**
     * Sets the value of the sentenceBeginIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSentenceBeginIndex(Integer value) {
        this.sentenceBeginIndex = value;
    }

    /**
     * Gets the value of the sentenceEndIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSentenceEndIndex() {
        return sentenceEndIndex;
    }

    /**
     * Sets the value of the sentenceEndIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSentenceEndIndex(Integer value) {
        this.sentenceEndIndex = value;
    }

    /**
     * Gets the value of the sentence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Sets the value of the sentence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentence(String value) {
        this.sentence = value;
    }

}
