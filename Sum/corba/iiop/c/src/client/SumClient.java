package sum.iiop.c;

import sum.rmi.i.ISum;

import javax.rmi.PortableRemoteObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;
import java.io.*;

public class SumClient {
  public static void main(String args[]) {
    String host = "localhost";
    String port = "1050";
    if (args.length > 0)
      host = args[0];
    if (args.length > 1)
      port = args[1];

    Scanner scanner = new Scanner(System.in);
    System.out.println("n :");
    Integer n = Integer.parseInt(scanner.next());
    try {
      System.setProperty("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
      System.setProperty("java.naming.provider.url", "iiop://" + host + ":" + port);
      Context ctx = new InitialContext();

      // STEP 1: Get the Object reference from the Name Servctxe
      // using JNDI call.
      Object objref = ctx.lookup("SumService");

      System.out.println("Client: Obtained a ref. to server.");
      // STEP 2: Narrow the object reference to the concrete type and
      // invoke the method.
      ISum obj = (ISum) PortableRemoteObject.narrow(objref, ISum.class);
      Integer x = obj.sum(n);
      System.out.println("Suma:" + x);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
