package sum.rmi.i;

public interface ISum extends java.rmi.Remote
{

    Integer sum(int a) throws java.rmi.RemoteException;
}
