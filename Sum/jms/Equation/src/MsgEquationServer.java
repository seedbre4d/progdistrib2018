package sum;

import javax.jms.TextMessage;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.JMSContext;
import javax.jms.JMSConsumer;
import javax.jms.JMSProducer;

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
            long n = Long.parseLong(ss[0]);
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

  private String sum(long num) {
    String sir = "Sirul este:";
    StringBuilder sb = new StringBuilder(String.valueOf(sir));
    sb.append(num);
    sb.append(",");
    int count = 0;
    while (num != 1) {
      if (num % 2 == 0) {
        num /= 2;
        sb.append(num);
        sb.append(",");
      } else {
        num = 3 * num + 1;
        sb.append(num);
        sb.append(",");
        count++;
      }
    }
    sb.append(" [nr pasi =");
    sb.append(count);
    sb.append("]");
    return sb.toString();
  }
}
