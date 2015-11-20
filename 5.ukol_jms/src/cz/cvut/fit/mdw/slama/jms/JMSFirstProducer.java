package cz.cvut.fit.mdw.slama.jms;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class JMSFirstProducer extends JMSProducerAbs {

  public static void main(String[] args) throws Exception {
    // input arguments
    String msg = "Hello";
    String queueName = Config.JMS_QUEUE_FIRST;

    // create the producer object and send the message
    JMSFirstProducer producer = new JMSFirstProducer();
    producer.send(queueName, msg);
  }
}
