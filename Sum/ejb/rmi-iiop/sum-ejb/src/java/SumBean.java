package sum

import javax.ejb.Stateless;


@Stateless 
@Remote(Sum.class)
public class SumBean implements Sum{
  public String sum(long num){
     String sir = "Sirul este:";
		StringBuilder sb = new StringBuilder (String.valueOf (sir));
		sb.append(num);
		sb.append(",");	
        int count = 0;
        while(num!=1)
        {
            if(num%2==0)
            {
                num /= 2;	
				sb.append(num);
				sb.append(",");					
            }
            else
            {
                num = 3*num + 1;
				sb.append(num);
				sb.append(",");
                count++;
            }
        }
		sb.append(" [nr pasi =");
		sb.append(count);
		s
        return sb.toString();
  }   
}