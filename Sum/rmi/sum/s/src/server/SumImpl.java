package sum.rmi.s;

import sum.rmi.i.ISum;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import java.util.stream.IntStream;
import javax.naming.InitialContext;

public class SumImpl implements ISum {

    public String solve(long a) {
        Integer sum = IntStream.range(1, (int) a).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        return sb.toString();
    }

    public static void main(String args[]) {
        String host = "localhost";
        int port = 1099;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);
        try {
            SumImpl obj = new SumImpl();
            ISum stub = (ISum) UnicastRemoteObject.exportObject(obj, 0);
            String sPort = Integer.valueOf(port).toString();
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            System.setProperty(Context.PROVIDER_URL, "rmi://" + host + ":" + sPort);
            Context ctx = new InitialContext();
            ctx.bind("SumServer", stub);
            System.out.println("SumServer ready");
            System.out.println("Press CTRL+C to finish !");
        } catch (Exception e) {
            // System.out.println("SumImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
