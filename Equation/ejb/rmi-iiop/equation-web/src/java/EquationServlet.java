package equation.web;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import equation.ejb.Equation;
import javax.ejb.*;
import javax.naming.Context;
import javax.naming.InitialContext; 
import javax.servlet.annotation.WebServlet; 
import java.util.Properties;

@WebServlet(urlPatterns = {"/equation"}) 
public class EquationServlet extends HttpServlet{
  @EJB
  Equation cb;
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    String sn=req.getParameter("n");     
    long n=Long.parseLong(sn);  
    String x=cb.equation(n);
    PrintWriter out=res.getWriter();
   
    String title="Cmmdc Servlet";
    res.setContentType("text/html");
    out.println("<HTML><HEAD><TITLE>");
    out.println(title);
    out.println("</TITLE></HEAD><BODY>");
    out.println("<H1>"+title+"</H1>");
    out.println("@EJB=" + cb);
	out.println("JNDI=" + lookupField());
    out.println();
    out.println("<P> "+x);
    out.println("</BODY></HTML>");
     
    out.close();   
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  } 
  
  private Object lookupField() {
        try {
			Properties p = new Properties();
			p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
			p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");
			InitialContext ctx = new InitialContext();
			Object obj =  ctx.lookup("java:global/equation-ear/equation-ejb/EquationBean!equation.ejb.Equation");
			Equation cd = (Equation) obj;
			String x = cd.equation(1);
			System.out.println(x);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}