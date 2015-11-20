package main.jmi;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public abstract class JMSConsumerAbs extends JMSCommonAbs implements MessageListener {
  // queue receiver that receives a message to the queue
  protected QueueReceiver qreceiver;

  // callback when the message exist in the queue
  public void onMessage(Message msg) {
    try {
      String msgText;
      if (msg instanceof TextMessage) {
        msgText = ((TextMessage) msg).getText();
      }
      else {
        msgText = msg.toString();
      }
      processMessage(msgText);
    }
    catch (JMSException jmse) {
      System.err.println("An exception occurred: " + jmse.getMessage());
    }
    catch (Exception e) {
      System.err.println("An exception occurred: " +  e.getMessage());
    }
  }

  protected void processMessage(String msgText) throws Exception {
    System.out.println("Message Received: " + msgText);
  }

  @Override
  protected void specialInit(Context ctx, String queueName) throws JMSException {
    qreceiver = qsession.createReceiver(queue);
    qreceiver.setMessageListener(this);

    qcon.start();
  }

  @Override
  protected void specialClose() throws JMSException {
    qreceiver.close();
  }

  // start receiving messages from the queue
  private void receive(String queueName) throws Exception {
    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.INITIAL_CONTEXT_FACTORY, Config.JNDI_FACTORY);
    env.put(Context.PROVIDER_URL, Config.PROVIDER_URL);

    InitialContext ic = new InitialContext(env);

    init(ic, queueName);

    System.out.println("Connected to " + queue.toString() + ", receiving messages...");
    try {
      synchronized (this) {
        while (true) {
          this.wait();
        }
      }
    }
    finally {
      close();
      System.out.println("Finished.");
    }
  }

  protected void consume(String queueName) throws Exception {
    receive(queueName);
  }
}
