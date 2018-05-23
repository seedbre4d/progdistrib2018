package equation.iiop.c;
import equation.rmi.i.IEquation;

import javax.rmi.PortableRemoteObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;
import java.io.*;

public class EquationClient {
  public static void  main( String args[] ) {
    String host="localhost";
    String port="1050";
    if (args.length>0)
       host=args[0];
    if (args.length>1)
       port=args[1];
    
    Scanner scanner=new Scanner(System.in);
    System.out.println("n :");
    long n=Long.parseLong(scanner.next());    
    try {
      System.setProperty("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
      System.setProperty("java.naming.provider.url","iiop://"+host+":"+port);
      Context ctx = new InitialContext();
     
      // STEP 1: Get the Object reference from the Name Servctxe
      // using JNDI call.
      Object objref = ctx.lookup("EquationService");
     
      System.out.println("Client: Obtained a ref. to server.");
      // STEP 2: Narrow the object reference to the concrete type and
      // invoke the method.
      IEquation obj = (IEquation) PortableRemoteObject.narrow(objref,IEquation.class);
      long x=obj.equation(n);
	  System.out.println("Numarul de pasi:"+x); 

      
    } 
    catch( Exception e ) {
      e.printStackTrace();
    }
  }
}


