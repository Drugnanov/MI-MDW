package cz.mdw.slama.hw8.model;

/**
 * Created by Drugnanov on 20.12.2015.
 */
public class BankAccount {

  String number;
  Double balance;

  public BankAccount(String number, Double balance) {
    this.number = number;
    this.balance = balance;
  }

  public Double getBalance() {
    return balance;
  }

  public String getNumber() {
    return number;
  }

  public Double changeBalance(Double addValue) // + or - values
  {
    this.balance += addValue;
    return this.balance;
  }

}
