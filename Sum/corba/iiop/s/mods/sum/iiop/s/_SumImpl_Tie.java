// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package sum.iiop.s;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.UnknownException;
import org.omg.CORBA_2_3.portable.ObjectImpl;


public class _SumImpl_Tie extends ObjectImpl implements Tie {
    
    volatile private SumImpl target = null;
    
    private static final String[] _type_ids = {
        "RMI:sum.rmi.i.ISum:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (SumImpl) target;
    }
    
    public Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return this;
    }
    
    public void deactivate() {
        _orb().disconnect(this);
        _set_delegate(null);
        target = null;
    }
    
    public ORB orb() {
        return _orb();
    }
    
    public void orb(ORB orb) {
        orb.connect(this);
    }
    
    public String[] _ids() { 
        return (String[]) _type_ids.clone();
    }
    
    public OutputStream  _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            SumImpl target = this.target;
            if (target == null) {
                throw new java.io.IOException();
            }
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            if (method.equals("sum")) {
                int arg0 = in.read_long();
                Integer result = target.sum(arg0);
                org.omg.CORBA_2_3.portable.OutputStream out = 
                    (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
                out.write_value(result,Integer.class);
                return out;
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
}
