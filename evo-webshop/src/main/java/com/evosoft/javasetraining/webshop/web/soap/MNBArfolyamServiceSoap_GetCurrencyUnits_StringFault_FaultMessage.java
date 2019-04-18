/**
 * MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.evosoft.javasetraining.webshop.web.soap;

public class MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage extends org.apache.axis.AxisFault {
    public java.lang.String detail;
    public java.lang.String getDetail() {
        return this.detail;
    }

    public MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage() {
    }

    public MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage(java.lang.Exception target) {
        super(target);
    }

    public MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage(java.lang.String message, java.lang.Throwable t) {
        super(message, t);
    }

      public MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage(java.lang.String detail) {
        this.detail = detail;
    }

    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, detail);
    }
}
