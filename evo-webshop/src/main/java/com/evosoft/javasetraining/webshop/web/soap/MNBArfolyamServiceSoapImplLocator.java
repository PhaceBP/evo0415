/**
 * MNBArfolyamServiceSoapImplLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.evosoft.javasetraining.webshop.web.soap;

public class MNBArfolyamServiceSoapImplLocator extends org.apache.axis.client.Service implements com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoapImpl {

    public MNBArfolyamServiceSoapImplLocator() {
    }


    public MNBArfolyamServiceSoapImplLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MNBArfolyamServiceSoapImplLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomBinding_MNBArfolyamServiceSoap
    private java.lang.String CustomBinding_MNBArfolyamServiceSoap_address = "http://www.mnb.hu/arfolyamok.asmx";

    public java.lang.String getCustomBinding_MNBArfolyamServiceSoapAddress() {
        return CustomBinding_MNBArfolyamServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomBinding_MNBArfolyamServiceSoapWSDDServiceName = "CustomBinding_MNBArfolyamServiceSoap";

    public java.lang.String getCustomBinding_MNBArfolyamServiceSoapWSDDServiceName() {
        return CustomBinding_MNBArfolyamServiceSoapWSDDServiceName;
    }

    public void setCustomBinding_MNBArfolyamServiceSoapWSDDServiceName(java.lang.String name) {
        CustomBinding_MNBArfolyamServiceSoapWSDDServiceName = name;
    }

    public com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap getCustomBinding_MNBArfolyamServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomBinding_MNBArfolyamServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomBinding_MNBArfolyamServiceSoap(endpoint);
    }

    public com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap getCustomBinding_MNBArfolyamServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.evosoft.javasetraining.webshop.web.soap.CustomBinding_MNBArfolyamServiceSoapStub _stub = new com.evosoft.javasetraining.webshop.web.soap.CustomBinding_MNBArfolyamServiceSoapStub(portAddress, this);
            _stub.setPortName(getCustomBinding_MNBArfolyamServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomBinding_MNBArfolyamServiceSoapEndpointAddress(java.lang.String address) {
        CustomBinding_MNBArfolyamServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.evosoft.javasetraining.webshop.web.soap.MNBArfolyamServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.evosoft.javasetraining.webshop.web.soap.CustomBinding_MNBArfolyamServiceSoapStub _stub = new com.evosoft.javasetraining.webshop.web.soap.CustomBinding_MNBArfolyamServiceSoapStub(new java.net.URL(CustomBinding_MNBArfolyamServiceSoap_address), this);
                _stub.setPortName(getCustomBinding_MNBArfolyamServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CustomBinding_MNBArfolyamServiceSoap".equals(inputPortName)) {
            return getCustomBinding_MNBArfolyamServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "MNBArfolyamServiceSoapImpl");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "CustomBinding_MNBArfolyamServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomBinding_MNBArfolyamServiceSoap".equals(portName)) {
            setCustomBinding_MNBArfolyamServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
