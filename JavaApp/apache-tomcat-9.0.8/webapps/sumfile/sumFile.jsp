<!doctype html>
<html>

<body>
  <H1> Sum </H1>
  <%@ page import="java.util.stream.IntStream" %>
    <%!
    String solve(int n) {
      Integer sum = IntStream.range(1, n)
          .filter(i -> i % 3 == 0 || i % 5 == 0)
          .sum();
      StringBuilder sb = new StringBuilder();
      sb.append(sum);
      return sb.toString();
    }   
    %>
      <form method="post">
        <table>
          <tr>
            <td>
              <label> n </label>
            </td>
            <td>
              <input type="number" name="n" size="5" value="1" required min="1" />
            </td>
          </tr>
          <tr>
            <td>
              <p>
                <input type="submit" value="Calculeaza">
            </td>
          </tr>
        </table>
      </form>
      Rezultatul este
      <% 
       String sn=request.getParameter("n"); 
       if(sn==null) sn="1";
	   System.out.println("n="+sn);  
       int numberN=Integer.parseInt(sn.trim());
       out.println(solve(numberN));   
    %>
</body>

</html>