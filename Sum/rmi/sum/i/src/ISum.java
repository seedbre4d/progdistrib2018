package sum.rmi.i;

public interface ISum extends java.rmi.Remote {
    String solve(long a) throws java.rmi.RemoteException;
}
