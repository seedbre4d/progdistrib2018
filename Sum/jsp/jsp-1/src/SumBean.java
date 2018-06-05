package sum;
import java.util.stream.IntStream;

public class SumBean{  

	private String n="";
  
	public void setn(String n){
		this.n=n;
	}
	public String getn(){
		return n;
	}
  
	public String getSum(){
		int a=Integer.parseInt(n);
		return solve(a);
	}
	  

	public String solve(int n) {
	  Integer sum = IntStream.range(1, n)
			  .filter(i -> i % 3 == 0 || i % 5 == 0)
			  .sum();
	  StringBuilder sb = new StringBuilder();
	  sb.append(sum);
	  return sb.toString();
	}   
}