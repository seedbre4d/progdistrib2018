package sum.iiop.s;

import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import sum.rmi.i.ISum;

// Se extinde clasa PortableRemoteObject 
// si nu UnicastRemoteObject

public class SumImpl extends PortableRemoteObject implements ISum {
    // Constructorul clasei
    public SumImpl() throws RemoteException {
    }

    public long sum(long a) {
        String sir = "Sirul este:";
        StringBuilder sb = new StringBuilder(String.valueOf(sir));
        sb.append(a);
        sb.append(",");
        int count = 0;
        while (a != 1) {
            if (a % 2 == 0) {
                a /= 2;
                sb.append(a);
                sb.append(",");
            } else {
                a = 3 * a + 1;
                sb.append(a);
                sb.append(",");
                count++;
            }
        }
        sb.append(" [nr pasi =");
        sb.append(count);
        sb.append("]");
        return count;
    }
}