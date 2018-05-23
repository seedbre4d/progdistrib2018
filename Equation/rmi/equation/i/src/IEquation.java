package equation.rmi.i;

public interface IEquation extends java.rmi.Remote {
    String solve(long a) throws java.rmi.RemoteException;
}

    
