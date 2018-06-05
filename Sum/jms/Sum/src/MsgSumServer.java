package sum;

import javax.jms.TextMessage;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.JMSContext;
import javax.jms.JMSConsumer;
import javax.jms.JMSProducer;
import java.util.stream.IntStream;

public class MsgSumServer {

  public static void main(String[] args) {
    MsgSumServer server = new MsgSumServer();
    server.service();
  }

  private void service() {
    try {
      com.sun.messaging.TopicConnectionFactory cf = new com.sun.messaging.TopicConnectionFactory();
      // cf.setProperty("imqBrokerHostName","host");
      // cf.setProperty("imqBrokerHostPort","7676");
      Topic t = new com.sun.messaging.Topic("Sum");
      JMSContext ctx = cf.createContext();
      JMSConsumer consumer = ctx.createSharedConsumer(t, "Sum");
      JMSProducer producer = ctx.createProducer();
      while (true) {
        Message msg = null;
        while ((msg = consumer.receive()) != null) {
          if (msg instanceof TextMessage) {
            TextMessage tm = (TextMessage) msg;
            String s = tm.getText();
            String[] ss = s.split(" ");
            int n = Integer.parseInt(ss[0]);
            String topic = ss[1];
            String c = sum(n);
            Topic t1 = new com.sun.messaging.Topic(topic);
            producer.send(t1, c);
            System.out.println("Server sent " + c + " to " + topic);
          }
        }
      }

    } catch (Exception e) {
      System.out.println("JMSException : " + e.getMessage());
    }
  }

  public String sum(int n) {
    Integer sum = IntStream.range(1, n)
            .filter(i -> i % 3 == 0 || i % 5 == 0)
            .sum();
    StringBuilder sb = new StringBuilder();
    sb.append(sum);
    return sb.toString();
  }   
}
