/**
 * MNBArfolyamServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.evosoft.javasetraining.webshop.web.soap;

public interface MNBArfolyamServiceSoap extends java.rmi.Remote {
    public java.lang.String getCurrencies() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetCurrencies_StringFault_FaultMessage;
    public java.lang.String getCurrencyUnits(java.lang.String currencyNames) throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage;
    public java.lang.String getCurrentExchangeRates() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetCurrentExchangeRates_StringFault_FaultMessage;
    public java.lang.String getDateInterval() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetDateInterval_StringFault_FaultMessage;
    public java.lang.String getExchangeRates(java.lang.String startDate, java.lang.String endDate, java.lang.String currencyNames) throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetExchangeRates_StringFault_FaultMessage;
    public java.lang.String getInfo() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetInfo_StringFault_FaultMessage;
}
