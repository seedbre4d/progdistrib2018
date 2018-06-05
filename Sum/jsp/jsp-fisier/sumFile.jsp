<!doctype html>
<html>
  <body>
    <H1> Sum </H1>
    <%!
		String solve(long num){
			
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
    %>
    <form method="post">
      <table> 
        <tr>
          <td><label> n </label></td>
          <td>    
             <input type="number" name="n" size="5" value="1"
             required min="1"/>         
          </td>
        </tr>  
        <tr>
          <td>          
             <p><input type="submit" value="Calculeaza">
          </td>
        </tr>
      </table>  
    </form>
    Rezultatul este 
    <% 
       String sn=request.getParameter("n"); 
       if(sn==null) sn="1";
	   System.out.println("n="+sn);  
       long numberN=Long.parseLong(sn.trim());
       out.println(solve(numberN));   
    %>
  </body>
</html>
