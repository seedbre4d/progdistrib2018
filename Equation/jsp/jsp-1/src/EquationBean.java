package equation;
public class EquationBean{  

	private String n="";
  
	public void setn(String n){
		this.n=n;
	}
	public String getn(){
		return n;
	}
  
	public String getEcuation(){
		long a=Long.parseLong(n);
		return solve(a);
	}
	  
	private String solve(long num){
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
		sb.append("]");
        return sb.toString();
    }
}