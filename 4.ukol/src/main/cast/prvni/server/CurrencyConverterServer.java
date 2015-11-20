package main.cast.prvni.server;

import main.cast.prvni.rmi.CurrencyConverterInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CurrencyConverterServer extends UnicastRemoteObject implements CurrencyConverterInterface {

  private static enum Currency {EUR, USD, GBP}

  ;
  private static Double eurRatio = 1.0;
  private static Double usdRatio = 0.93;
  private static Double gbpRatio = 1.4;

  public CurrencyConverterServer() throws RemoteException {
    super();
  }

  public Double convert(String from, String to, Double amount) throws RemoteException {
    Currency curFrom = Currency.valueOf(from);
    Currency curTo = Currency.valueOf(to);
    Double fromRatio = getRation(curFrom);
    Double toRatio = getRation(curTo);
    return Math.round(fromRatio / toRatio * amount * 100) / 100.0;
  }

  private Double getRation(Currency currency) {
    switch (currency) {
      case EUR: {
        return eurRatio;
      }
      case USD: {
        return usdRatio;
      }
      case GBP: {
        return gbpRatio;
      }
      default:
        return 0.0;
    }
  }
}
