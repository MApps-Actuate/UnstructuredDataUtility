
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelevancyLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelevancyLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FIRST"/>
 *     &lt;enumeration value="SECOND"/>
 *     &lt;enumeration value="THIRD"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelevancyLevel")
@XmlEnum
public enum RelevancyLevel {

    FIRST,
    SECOND,
    THIRD,
    ALL;

    public String value() {
        return name();
    }

    public static RelevancyLevel fromValue(String v) {
        return valueOf(v);
    }

}
