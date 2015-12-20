/**
 * BankAccountService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.mdw.slama.hw8.client;

public interface BankAccountService extends java.rmi.Remote {
    public boolean accountExists(java.lang.String bankAccountNumber) throws java.rmi.RemoteException;
    public boolean changeBalance(java.lang.String bankAccountNumber, double amount) throws java.rmi.RemoteException;
    public double getBalance(java.lang.String bankAccountNumber) throws java.rmi.RemoteException;
    public boolean validateBalance(java.lang.String bankAccountNumber, double amount) throws java.rmi.RemoteException;
}
