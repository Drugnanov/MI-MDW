package main.cast.prvni.client;

import main.cast.prvni.rmi.CurrencyConverterInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

  public static void main(String args[]) {
    try {
      CurrencyConverterInterface curRmi;
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      curRmi = (CurrencyConverterInterface) registry.lookup("CurrencyConverterServer");

      System.out.println("Test client currency convert: 10 USD to " + curRmi.convert("USD", "GBP", 10.0) + " GBP.");
      System.out.println("Test client currency convert: 5 GBP to " + curRmi.convert("GBP", "USD", 5.0) + " USD.");
      System.out.println("Test client currency convert: 100 EUR to " + curRmi.convert("EUR", "GBP", 100.0) + " GBP.");
    }
    catch (Exception e) {
      System.err.println("Something terrible happened! " + e.getMessage());
    }
  }
}