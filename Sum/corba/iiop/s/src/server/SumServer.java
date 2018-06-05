package sum.iiop.s;

import javax.naming.InitialContext;
import javax.naming.Context;

public class SumServer {
  public static void main(String[] args) {
    String host = "localhost";
    String port = "1050";
    if (args.length > 0)
      host = args[0];
    if (args.length > 1)
      port = args[1];
    try {
      // 1: Crearea unei instante CmmdcImpl
      SumImpl sumRef = new SumImpl();

      // 2: Inregistrarea unei referinte a serviciului
      // utilizand JNDI API
      System.setProperty("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
      System.setProperty("java.naming.provider.url", "iiop://" + host + ":" + port);
      Context ctx = new InitialContext();
      ctx.rebind("SumService", sumRef);
      System.out.println("Server: Ready...");
      System.out.println("Press CTRL+C to finish !");
    } catch (Exception e) {
      System.out.println("Server: " + e.getMessage());
    }
  }
}
