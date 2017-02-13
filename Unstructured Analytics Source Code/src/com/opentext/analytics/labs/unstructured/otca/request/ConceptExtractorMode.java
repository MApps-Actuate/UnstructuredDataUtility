
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConceptExtractorMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConceptExtractorMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NCONCEPT"/>
 *     &lt;enumeration value="NFINDER"/>
 *     &lt;enumeration value="NCATEGORIZER"/>
 *     &lt;enumeration value="NSUMMARIZER"/>
 *     &lt;enumeration value="FAST"/>
 *     &lt;enumeration value="PHOTOCAPTION"/>
 *     &lt;enumeration value="NLIKETHIS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConceptExtractorMode")
@XmlEnum
public enum ConceptExtractorMode {

    NCONCEPT,
    NFINDER,
    NCATEGORIZER,
    NSUMMARIZER,
    FAST,
    PHOTOCAPTION,
    NLIKETHIS;

    public String value() {
        return name();
    }

    public static ConceptExtractorMode fromValue(String v) {
        return valueOf(v);
    }

}
