package sum.web;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.
import sum.ejb.Sum;

import javax. naming .Context;
import javax.naming.InitialContext;  
    port
    port java.u

    ebServlet(urlPatterns = {"/sum"})    class SumServlet extend s HttpServl e
        JB  
        m cb;  
          
        blic void doGet ( HttpServletReque

        String sn=re q .getParameter(
        long n=Long.parseLong(sn);  
        String x=cb.sum(n);
        PrintWriter out=res
        
        String title="Cmmd c  Serv l et";
        res.setContentType ( "te
        out.println("<HTML><HEAD><TITL

        out.println(
     

    ut.println("JNDI=" + lookupField());  t.println();  
        out.printl n("<P
     
     
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
			Object obj =  ctx.lookup("java:global/sum-ear/sum-ejb/SumBean!sum.ejb.Sum");
			Sum cd = (Sum) obj;
			String x = cd.sum(1);
			System.out.println(x);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}