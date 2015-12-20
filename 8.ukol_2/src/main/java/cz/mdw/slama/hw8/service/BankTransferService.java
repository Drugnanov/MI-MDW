package cz.mdw.slama.hw8.service;

import cz.mdw.slama.hw8.client.*;
import cz.mdw.slama.hw8.db.BankAccountDb;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created by Drugnanov on 20.12.2015.
 */
@WebService
public class BankTransferService {

  public boolean transfer(@WebParam(name = "fromBankAccountNumber") String from,
                          @WebParam(name = "toBankAccountNumber") String to,
                          @WebParam(name = "amount") double amount)
  {
    try {
      BankAccountServiceServiceLocator l = new BankAccountServiceServiceLocator();
      cz.mdw.slama.hw8.client.BankAccountService service =  l.getBankAccountServicePort();
      if(!service.accountExists(from) || !service.accountExists(to)) {
        return false;
      }
      if(!service.validateBalance(from, amount)) {
        return false;
      }
        service.changeBalance(from, -amount);
        service.changeBalance(to, amount);
        return true;

    }
    catch (ServiceException e) {
      e.printStackTrace();
    }
    catch (RemoteException e) {
      e.printStackTrace();
    }

    return false;
  }
}
