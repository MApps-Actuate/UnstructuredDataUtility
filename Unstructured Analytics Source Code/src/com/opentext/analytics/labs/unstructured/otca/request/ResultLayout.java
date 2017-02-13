
package com.opentext.analytics.labs.unstructured.otca.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultLayout.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResultLayout">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NCONCEPTEXTRACTOR"/>
 *     &lt;enumeration value="NFINDER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResultLayout")
@XmlEnum
public enum ResultLayout {

    NCONCEPTEXTRACTOR,
    NFINDER;

    public String value() {
        return name();
    }

    public static ResultLayout fromValue(String v) {
        return valueOf(v);
    }

}
