package sum.ejb;
import javax.ejb.Stateless;
import java.util.stream.IntStream;
 
@Stateless
public class SumBean{
    public String sum(int n) {
        Integer sum = IntStream.range(1, n)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        return sb.toString();
  }   
}