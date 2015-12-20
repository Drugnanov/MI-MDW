package cz.mdw.slama.hw8.service;

import cz.mdw.slama.hw8.db.BankAccountDb;
import cz.mdw.slama.hw8.model.BankAccount;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Drugnanov on 20.12.2015.
 */
@WebService
public class BankAccountService {

  public boolean accountExists(@WebParam(name = "bankAccountNumber") String accountNumber) {
    return BankAccountDb.accountExists(accountNumber);
  }

  public boolean validateBalance(@WebParam(name = "bankAccountNumber") String accountNumber,
                                 @WebParam(name = "amount") double amount) {
    BankAccount account = BankAccountDb.getAccount(accountNumber);
    if (account == null) {
      return false;
    }
    return account.getBalance() >= amount;
  }

  public boolean changeBalance(@WebParam(name = "bankAccountNumber") String accountNumber,
                               @WebParam(name = "amount") double amount) {
    return BankAccountDb.changeAccountBalance(accountNumber, amount);
  }

  public double getBalance(@WebParam(name = "bankAccountNumber") String accountNumber) {
    return BankAccountDb.getBankAccountBalance(accountNumber);
  }
}
