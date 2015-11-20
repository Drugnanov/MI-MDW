package main.cast.prvni.server;

import main.cast.prvni.rmi.CurrencyConverterInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		try {
			CurrencyConverterInterface curInter = new CurrencyConverterServer();

			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("CurrencyConverterServer", curInter);
			System.out.println("Currency server is running...");
		}
		catch (Exception e) {
			System.err.println("Something terrible happened! " + e.getMessage());
		}
	}
}