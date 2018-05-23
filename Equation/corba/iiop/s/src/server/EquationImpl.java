package equation.iiop.s;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import equation.rmi.i.IEquation;

// Se extinde clasa PortableRemoteObject 
// si nu UnicastRemoteObject

public class EquationImpl extends PortableRemoteObject
                       implements IEquation{
  // Constructorul clasei
  public EquationImpl() throws RemoteException {}
     
  public long equation(long a)
    {
		String sir = "Sirul este:";
		StringBuilder sb = new StringBuilder (String.valueOf (sir));
		sb.append(a);
		sb.append(",");	
        int count = 0;
        while(a!=1)
        {
            if(a%2==0)
            {
                a /= 2;	
				sb.append(a);
				sb.append(",");					
            }
            else
            {
                a = 3*a + 1;
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