package main.jmi;

import javax.jms.MessageListener;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class JMSMiddleConsumer extends JMSConsumerAbs implements MessageListener {

  JMSMiddleProducer producer = new JMSMiddleProducer();

  @Override
  protected void processMessage(String msgText) throws Exception {
    super.processMessage(msgText);
    System.out.println("Forwarding message '" + msgText + "' to second queue " + Config.JMS_QUEUE_SECOND);
    producer.send(Config.JMS_QUEUE_SECOND, msgText);
  }

  public void runConsume(String queueName) throws Exception {
    consume(queueName);
  }
}
