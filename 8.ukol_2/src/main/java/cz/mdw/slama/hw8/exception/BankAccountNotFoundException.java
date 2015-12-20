package cz.mdw.slama.hw8.exception;

import javax.xml.ws.WebServiceException;

/**
 * Created by Drugnanov on 20.12.2015.
 */
public class BankAccountNotFoundException extends WebServiceException {

  public BankAccountNotFoundException(String message) {
    super(message);
  }
}
