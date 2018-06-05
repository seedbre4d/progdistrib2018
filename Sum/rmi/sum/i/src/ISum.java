package sum.rmi.i;

public interface ISum extends java.rmi.Remote {
    String solve(int a) throws java.rmi.RemoteException;
}
