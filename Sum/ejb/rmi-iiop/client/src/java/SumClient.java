package sum;

import sum.ejb.Sum;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Scanner;
import java.util.Properties;

public class SumClient {
    private static Sum cb;

    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
        p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");
        Context ctx = null;
        try {
            ctx = new InitialContext(p);
            Object obj = ctx.lookup("java:global/sum-ear/sum-ejb/SumBean!sum.ejb.Sum");
            // Aici se face cautarea iiop
            cb = (Sum) javax.rmi.PortableRemoteObject.narrow(obj, Sum.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("After");
        Scanner scanner = new Scanner(System.in);
        ;
        System.out.println("n=");
        int n = scanner.nextInt();
        String x = cb.sum(n);
        System.out.println(x);

    }

}