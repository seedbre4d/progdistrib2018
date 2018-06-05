package sum.ejb;
import java.util.stream.IntStream;

import javax.ejb.Stateless;
import javax.ejb.Remote;

@Stateless
@Remote(Sum.class)
public class SumBean implements Sum {
    public String sum(int n) {
        Integer sum = IntStream.range(1, n)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        return sb.toString();
    }
}
