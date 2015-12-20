/**
 * BankAccountServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.mdw.slama.hw8.client;

public class BankAccountServiceServiceLocator extends org.apache.axis.client.Service implements cz.mdw.slama.hw8.client.BankAccountServiceService {

    public BankAccountServiceServiceLocator() {
    }


    public BankAccountServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankAccountServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankAccountServicePort
    private java.lang.String BankAccountServicePort_address = "http://192.168.99.1:7001/mdw-ukol-8/BankAccountServiceService";

    public java.lang.String getBankAccountServicePortAddress() {
        return BankAccountServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BankAccountServicePortWSDDServiceName = "BankAccountServicePort";

    public java.lang.String getBankAccountServicePortWSDDServiceName() {
        return BankAccountServicePortWSDDServiceName;
    }

    public void setBankAccountServicePortWSDDServiceName(java.lang.String name) {
        BankAccountServicePortWSDDServiceName = name;
    }

    public cz.mdw.slama.hw8.client.BankAccountService getBankAccountServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankAccountServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankAccountServicePort(endpoint);
    }

    public cz.mdw.slama.hw8.client.BankAccountService getBankAccountServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cz.mdw.slama.hw8.client.BankAccountServicePortBindingStub _stub = new cz.mdw.slama.hw8.client.BankAccountServicePortBindingStub(portAddress, this);
            _stub.setPortName(getBankAccountServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankAccountServicePortEndpointAddress(java.lang.String address) {
        BankAccountServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cz.mdw.slama.hw8.client.BankAccountService.class.isAssignableFrom(serviceEndpointInterface)) {
                cz.mdw.slama.hw8.client.BankAccountServicePortBindingStub _stub = new cz.mdw.slama.hw8.client.BankAccountServicePortBindingStub(new java.net.URL(BankAccountServicePort_address), this);
                _stub.setPortName(getBankAccountServicePortWSDDServiceName());
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
        if ("BankAccountServicePort".equals(inputPortName)) {
            return getBankAccountServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.hw8.slama.mdw.cz/", "BankAccountServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.hw8.slama.mdw.cz/", "BankAccountServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BankAccountServicePort".equals(portName)) {
            setBankAccountServicePortEndpointAddress(address);
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
