package equation.rmi.c;
import equation.rmi.i.IEquation;
import java.util.Scanner;
// Varianta cu apel rmiregistry direct
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
// Varianta JNDI
import javax.naming.Context;
import javax.naming.InitialContext;

public class EquationClient {
  public static void main(String args[]) {
    String host="localhost";
    int port=1099;
    if(args.length>0)
      host=args[0];
    if (args.length>1)
      port=Integer.parseInt(args[1]);
    Scanner scanner=new Scanner(System.in);
    System.out.println("n :");
    long n=Long.parseLong(scanner.next());
    try {
      String sPort=Integer.valueOf(port).toString();
      System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.rmi.registry.RegistryContextFactory");
      System.setProperty(Context.PROVIDER_URL,"rmi://"+host+":"+sPort);
      Context ctx=new InitialContext();
      IEquation obj=(IEquation)ctx.lookup("EquationServer");
      
      String x=obj.solve(n);
      System.out.println(x);
    }
    catch (Exception e) {
      System.out.println("EquationClient exception: "+e.getMessage());
    }
  }
}
