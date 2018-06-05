package sum.rmi.i;

public interface ISum extends java.rmi.RemoteException
{

    long sum(long a) throws java.rmi.RemoteException;
}
