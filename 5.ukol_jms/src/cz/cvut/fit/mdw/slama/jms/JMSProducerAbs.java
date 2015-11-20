package cz.cvut.fit.mdw.slama.jms;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.QueueSender;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class JMSProducerAbs extends JMSCommonAbs {

  // queue sender that sends a message to the queue
  private QueueSender qsender;

  // a message that will be sent to the queue
  private TextMessage msg;

  @Override
  protected void specialInit(Context ctx, String queueName) throws JMSException {
    // create sender and message
    qsender = qsession.createSender(queue);
    msg = qsession.createTextMessage();
  }

  @Override
  protected void specialClose() throws JMSException {
    qsender.close();
  }

  // sends the message to the queue
  protected void send(String queueName, String message) throws Exception {

    // create a JNDI context to lookup JNDI objects (connection factory and queue)
    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.INITIAL_CONTEXT_FACTORY, Config.JNDI_FACTORY);
    env.put(Context.PROVIDER_URL, Config.PROVIDER_URL);

    InitialContext ic = new InitialContext(env);
    init(ic, queueName);

    // send the message and close
    try {
      msg.setText(message);
      qsender.send(msg, DeliveryMode.PERSISTENT, 8, 0);
      System.out.println("The message was sent to the destination " +
          qsender.getDestination().toString());
    }
    finally {
      close();
    }
  }

}
