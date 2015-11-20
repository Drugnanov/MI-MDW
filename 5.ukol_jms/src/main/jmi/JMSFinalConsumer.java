package main.jmi;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class JMSFinalConsumer extends JMSConsumerAbs implements MessageListener {

  public static void main(String[] args) throws Exception {
    // input arguments
    JMSFinalConsumer consumer = new JMSFinalConsumer();
    consumer.consume(Config.JMS_QUEUE_SECOND);
  }
}
