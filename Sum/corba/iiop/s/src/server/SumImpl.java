package sum.iiop.s;
import java.util.stream.IntStream;

import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import sum.rmi.i.ISum;

// Se extinde clasa PortableRemoteObject 
// si nu UnicastRemoteObject

public class SumImpl extends PortableRemoteObject implements ISum {
    // Constructorul clasei
    public SumImpl() throws RemoteException {
    }

    public Integer sum(int n) {
        Integer sum = IntStream.range(1, n) // create range
                  .filter(i -> i % 3 == 0 || i % 5 == 0) // filter out
                  .sum(); // output: 233168
        StringBuilder sb = new StringBuilder();
        return sum;
    }
}