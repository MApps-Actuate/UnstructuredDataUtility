
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LanguageDetectorMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LanguageDetectorMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="text"/>
 *     &lt;enumeration value="paragraph"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LanguageDetectorMode")
@XmlEnum
public enum LanguageDetectorMode {

    @XmlEnumValue("text")
    TEXT("text"),
    @XmlEnumValue("paragraph")
    PARAGRAPH("paragraph");
    private final String value;

    LanguageDetectorMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LanguageDetectorMode fromValue(String v) {
        for (LanguageDetectorMode c: LanguageDetectorMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
