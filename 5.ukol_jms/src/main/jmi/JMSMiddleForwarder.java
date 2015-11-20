package main.jmi;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class JMSMiddleForwarder {

  static JMSMiddleConsumer consumer = new JMSMiddleConsumer();

  public static void main(String[] args) throws Exception {
    // input arguments
    consumer.runConsume(Config.JMS_QUEUE_FIRST);
  }
}
