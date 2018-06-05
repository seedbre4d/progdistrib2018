package sum.ejb;

import javax.ejb.Remote;

@Remote
public interface Sum{
  public String sum(long num);
}