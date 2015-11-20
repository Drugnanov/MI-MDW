package cz.cvut.fit.mdw.slama.jms;

/**
 * Created by Drugnanov on 10.11.2015.
 */
public class Config {

    // Defines the JNDI context factory.
    public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

    // Defines the JMS context factory.
    public final static String JMS_FACTORY = "jms/mdw-cf";

    // URL
    public final static String PROVIDER_URL = "t3://localhost:7001";

    public final static String JMS_QUEUE_FIRST = "jms/mdw-queue";
    public final static String JMS_QUEUE_SECOND = "jms/mdw-queue_2";
}
