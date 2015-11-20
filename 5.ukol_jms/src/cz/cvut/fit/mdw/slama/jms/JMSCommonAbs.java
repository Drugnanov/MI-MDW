package cz.cvut.fit.mdw.slama.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Created by Drugnanov on 20.11.2015.
 */
public abstract class JMSCommonAbs {
  // connection factory
  protected QueueConnectionFactory qconFactory;

  // connection to a queue
  protected QueueConnection qcon;

  // session within a connection
  protected QueueSession qsession;

  // queue where the message will be sent to
  protected Queue queue;

  // create a connection to the WLS using a JNDI context
  protected void init(Context ctx, String queueName)
      throws NamingException, JMSException {

    qconFactory = (QueueConnectionFactory) ctx.lookup(Config.JMS_FACTORY);
    qcon = qconFactory.createQueueConnection();
    qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    queue = (Queue) ctx.lookup(queueName);

    specialInit(ctx, queueName);
  }

  // close sender, connection and the session
  protected void close() throws JMSException {
    specialClose();
    qsession.close();
    qcon.close();
  }

  protected abstract void specialClose() throws JMSException;

  protected abstract void specialInit(Context ctx, String queueName) throws JMSException;
}
