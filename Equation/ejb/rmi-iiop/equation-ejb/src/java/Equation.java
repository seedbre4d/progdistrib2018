package equation.ejb;
import javax.ejb.Remote;

@Remote
public interface Equation{
  public String equation(long num);
}