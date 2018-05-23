package equation.rmi.s;

import equation.rmi.i.IEquation;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import javax.naming.InitialContext;

public class EquationImpl  implements IEquation{

    public String solve(long a)
    {
		String sir = "Sirul este:";
		StringBuilder sb = new StringBuilder (String.valueOf (sir));
		sb.append(a);
		sb.append(",");	
        int count = 0;
        while(a!=1)
        {
            if(a%2==0)
            {
                a /= 2;	
				sb.append(a);
				sb.append(",");					
            }
            else
            {
                a = 3*a + 1;
				sb.append(a);
				sb.append(",");
                count++;
            }
        }
		sb.append(" [nr pasi =");
		sb.append(count);
		sb.append("]");
        return sb.toString();
    }
  
    public static void main(String args[]) {
      String host="localhost";
      int port=1099;
      if(args.length>0)
         port=Integer.parseInt(args[0]);
      try {
        EquationImpl obj=new EquationImpl();
        IEquation stub=(IEquation)UnicastRemoteObject.exportObject(obj,0);
        String sPort=Integer.valueOf(port).toString();
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
          "com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL,"rmi://"+host+":"+sPort);
        Context ctx=new InitialContext();
        ctx.bind("EquationServer",stub);
        System.out.println("EquationServer ready");
        System.out.println("Press CTRL+C to finish !");
      } 
      catch (Exception e) {
        //System.out.println("EquationImpl err: " + e.getMessage());
        e.printStackTrace();
      }
    }
} 
