/**
 * BankAccountServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.mdw.slama.hw8.client;

public interface BankAccountServiceService extends javax.xml.rpc.Service {
    public java.lang.String getBankAccountServicePortAddress();

    public cz.mdw.slama.hw8.client.BankAccountService getBankAccountServicePort() throws javax.xml.rpc.ServiceException;

    public cz.mdw.slama.hw8.client.BankAccountService getBankAccountServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
