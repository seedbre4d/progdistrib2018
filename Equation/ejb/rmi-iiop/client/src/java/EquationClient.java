package equation;

import equation.ejb.Equation;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;
import java.util.Properties;

public class EquationClient{
    private static Equation cb;

    public static void main(String[] args)throws Exception{
        Properties p = new Properties();
        p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
        p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");
        Context ctx = null;
        try
        {
            ctx = new InitialContext(p);
            Object obj = ctx.lookup("java:global/equation-ear/equation-ejb/EquationBean!equation.ejb.Equation");
			//Aici se face cautarea iiop
			cb = (Equation) javax.rmi.PortableRemoteObject.narrow(obj, Equation.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("After");
        Scanner scanner=new Scanner(System.in);;
        System.out.println("n=");
        long n=scanner.nextLong();
        String x=cb.equation(n);
        System.out.println(x);

    }

}