
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Methods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Methods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ping" type="{}Ping"/>
 *         &lt;element name="GetSupportedEncodings" type="{}GetSupportedEncodings"/>
 *         &lt;element name="languagedetector" type="{}LanguageDetector"/>
 *         &lt;element name="nconceptextractor" type="{}ConceptExtractor"/>
 *         &lt;element name="ncategorizer" type="{}Categorizer"/>
 *         &lt;element name="nfinder" type="{}Finder"/>
 *         &lt;element name="nsentiment" type="{}Sentiment"/>
 *         &lt;element name="nlikethis" type="{}LikeThis"/>
 *         &lt;element name="nsummarizer" type="{}Summarizer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Methods", propOrder = {
    "ping",
    "getSupportedEncodings",
    "languageDetector",
    "conceptExtractor",
    "categorizer",
    "finder",
    "sentiment",
    "likeThis",
    "summarizer"
})
public class Methods {

    @XmlElement(name = "Ping", required = true)
    protected Ping ping;
    @XmlElement(name = "GetSupportedEncodings", required = true)
    protected GetSupportedEncodings getSupportedEncodings;
    @XmlElement(name = "languagedetector", required = true)
    protected LanguageDetector languageDetector;
    @XmlElement(name = "nconceptextractor", required = true)
    protected ConceptExtractor conceptExtractor;
    @XmlElement(name = "ncategorizer", required = true)
    protected Categorizer categorizer;
    @XmlElement(name = "nfinder", required = true)
    protected Finder finder;
    @XmlElement(name = "nsentiment", required = true)
    protected Sentiment sentiment;
    @XmlElement(name = "nlikethis", required = true)
    protected LikeThis likeThis;
    @XmlElement(name = "nsummarizer", required = true)
    protected Summarizer summarizer;

    /**
     * Gets the value of the ping property.
     * 
     * @return
     *     possible object is
     *     {@link Ping }
     *     
     */
    public Ping getPing() {
        return ping;
    }

    /**
     * Sets the value of the ping property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ping }
     *     
     */
    public void setPing(Ping value) {
        this.ping = value;
    }

    /**
     * Gets the value of the getSupportedEncodings property.
     * 
     * @return
     *     possible object is
     *     {@link GetSupportedEncodings }
     *     
     */
    public GetSupportedEncodings getGetSupportedEncodings() {
        return getSupportedEncodings;
    }

    /**
     * Sets the value of the getSupportedEncodings property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSupportedEncodings }
     *     
     */
    public void setGetSupportedEncodings(GetSupportedEncodings value) {
        this.getSupportedEncodings = value;
    }

    /**
     * Gets the value of the languageDetector property.
     * 
     * @return
     *     possible object is
     *     {@link LanguageDetector }
     *     
     */
    public LanguageDetector getLanguageDetector() {
        return languageDetector;
    }

    /**
     * Sets the value of the languageDetector property.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageDetector }
     *     
     */
    public void setLanguageDetector(LanguageDetector value) {
        this.languageDetector = value;
    }

    /**
     * Gets the value of the conceptExtractor property.
     * 
     * @return
     *     possible object is
     *     {@link ConceptExtractor }
     *     
     */
    public ConceptExtractor getConceptExtractor() {
        return conceptExtractor;
    }

    /**
     * Sets the value of the conceptExtractor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConceptExtractor }
     *     
     */
    public void setConceptExtractor(ConceptExtractor value) {
        this.conceptExtractor = value;
    }

    /**
     * Gets the value of the categorizer property.
     * 
     * @return
     *     possible object is
     *     {@link Categorizer }
     *     
     */
    public Categorizer getCategorizer() {
        return categorizer;
    }

    /**
     * Sets the value of the categorizer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Categorizer }
     *     
     */
    public void setCategorizer(Categorizer value) {
        this.categorizer = value;
    }

    /**
     * Gets the value of the finder property.
     * 
     * @return
     *     possible object is
     *     {@link Finder }
     *     
     */
    public Finder getFinder() {
        return finder;
    }

    /**
     * Sets the value of the finder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Finder }
     *     
     */
    public void setFinder(Finder value) {
        this.finder = value;
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
     * Gets the value of the likeThis property.
     * 
     * @return
     *     possible object is
     *     {@link LikeThis }
     *     
     */
    public LikeThis getLikeThis() {
        return likeThis;
    }

    /**
     * Sets the value of the likeThis property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikeThis }
     *     
     */
    public void setLikeThis(LikeThis value) {
        this.likeThis = value;
    }

    /**
     * Gets the value of the summarizer property.
     * 
     * @return
     *     possible object is
     *     {@link Summarizer }
     *     
     */
    public Summarizer getSummarizer() {
        return summarizer;
    }

    /**
     * Sets the value of the summarizer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Summarizer }
     *     
     */
    public void setSummarizer(Summarizer value) {
        this.summarizer = value;
    }

}
