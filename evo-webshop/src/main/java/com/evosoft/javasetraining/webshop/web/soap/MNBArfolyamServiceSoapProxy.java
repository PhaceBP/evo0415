package com.evosoft.javasetraining.webshop.web.soap;

public class MNBArfolyamServiceSoapProxy implements com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap {
  private String _endpoint = null;
  private com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap mNBArfolyamServiceSoap = null;
  
  public MNBArfolyamServiceSoapProxy() {
    _initMNBArfolyamServiceSoapProxy();
  }
  
  public MNBArfolyamServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initMNBArfolyamServiceSoapProxy();
  }
  
  private void _initMNBArfolyamServiceSoapProxy() {
    try {
      mNBArfolyamServiceSoap = (new com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoapImplLocator()).getCustomBinding_MNBArfolyamServiceSoap();
      if (mNBArfolyamServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mNBArfolyamServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mNBArfolyamServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mNBArfolyamServiceSoap != null)
      ((javax.xml.rpc.Stub)mNBArfolyamServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap getMNBArfolyamServiceSoap() {
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap;
  }
  
  public java.lang.String getCurrencies() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetCurrencies_StringFault_FaultMessage{
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap.getCurrencies();
  }
  
  public java.lang.String getCurrencyUnits(java.lang.String currencyNames) throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetCurrencyUnits_StringFault_FaultMessage{
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap.getCurrencyUnits(currencyNames);
  }
  
  public java.lang.String getCurrentExchangeRates() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetCurrentExchangeRates_StringFault_FaultMessage{
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap.getCurrentExchangeRates();
  }
  
  public java.lang.String getDateInterval() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetDateInterval_StringFault_FaultMessage{
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap.getDateInterval();
  }
  
  public java.lang.String getExchangeRates(java.lang.String startDate, java.lang.String endDate, java.lang.String currencyNames) throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetExchangeRates_StringFault_FaultMessage{
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap.getExchangeRates(startDate, endDate, currencyNames);
  }
  
  public java.lang.String getInfo() throws java.rmi.RemoteException, com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap_GetInfo_StringFault_FaultMessage{
    if (mNBArfolyamServiceSoap == null)
      _initMNBArfolyamServiceSoapProxy();
    return mNBArfolyamServiceSoap.getInfo();
  }
  
  
}