package cz.mdw.slama.hw8.db;

import cz.mdw.slama.hw8.exception.BankAccountNotFoundException;
import cz.mdw.slama.hw8.model.BankAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Drugnanov on 20.12.2015.
 */
public class BankAccountDb {

  private static final Map<String, BankAccount> accounts = new HashMap<String, BankAccount>();

  static {
    BankAccount defaultAccount_1 = new BankAccount("1", 100.0);
    BankAccount defaultAccount_2 = new BankAccount("2", 500.0);

    accounts.put(defaultAccount_1.getNumber(), defaultAccount_1);
    accounts.put(defaultAccount_2.getNumber(), defaultAccount_2);
  }

  public static BankAccount getAccount(String accountNumber) {
    if (!accountExists(accountNumber)){
      throw new BankAccountNotFoundException("No account for account number "+ accountNumber);
    }
     return accounts.get(accountNumber);
  }

  public static boolean accountExists(String accountNumber) {
    return accounts.containsKey(accountNumber);
  }

  public static boolean changeAccountBalance(String accountNumber, double amount) {
    BankAccount ba = getAccount(accountNumber);
    ba.changeBalance(amount);
    return true;
  }

  public static double getBankAccountBalance(String accountNumber) {
    BankAccount ba = getAccount(accountNumber);
    return ba.getBalance();
  }
}
