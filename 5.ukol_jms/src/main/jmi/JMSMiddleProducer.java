package main.jmi;

import javax.jms.MessageListener;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class JMSMiddleProducer extends JMSProducerAbs {

  public void runProduce(String message, String queueName) throws Exception {
    send(message, queueName);
  }
}
