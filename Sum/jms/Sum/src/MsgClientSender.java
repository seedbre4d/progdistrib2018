package sum;

import javax.jms.Topic;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.JMSConsumer;
import java.util.Scanner;

public class MsgClientSender {
  private String msg, clientID, clientName, topicResult;

  MsgClientSender(String clientID, String clientName) {
    this.clientID = clientID;
    this.clientName = clientName;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduceti n :");
    int n = scanner.nextInt();
    String sn = Long.valueOf(n).toString();
    System.out.println("Introduceti 'Topic'-ul raspunsului");
    topicResult = scanner.next();
    msg = sn + " " + topicResult;
  }

  private void service() {
    try {
      // Varianta Oracle-Sun Message Topic
      com.sun.messaging.TopicConnectionFactory cf = new com.sun.messaging.TopicConnectionFactory();
      // cf.setProperty("imqBrokerHostName","host");
      // cf.setProperty("imqBrokerHostPort","7676");
      Topic t = new com.sun.messaging.Topic("Sum");
      JMSContext ctx = cf.createContext();

      Topic t1 = new com.sun.messaging.Topic(topicResult);
      ctx.setClientID(clientID);
      JMSConsumer consumer = ctx.createDurableConsumer(t1, clientName);
      // JMSConsumer consumer = ctx.createSharedDurableConsumer(t,clientName);

      JMSProducer producer = ctx.createProducer();
      producer.send(t, msg);

      ctx.close();
    } catch (Exception e) {
      System.out.println("JMSException : " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage:");
      System.out.println("java MsgClientSender clientID clientName");
      System.exit(0);
    }
    MsgClientSender client = new MsgClientSender(args[0], args[1]);
    client.service();
  }
}
