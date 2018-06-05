package sum.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sum.ejb.SumBean;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

@WebServlet({ "/sum" })
public class SumServlet extends HttpServlet {
  @EJB
  SumBean cb;

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String sn = req.getParameter("n");
    long n = Long.parseLong(sn);
    String x = cb.sum(n);
    PrintWriter out = res.getWriter();

    String title = "Sum Servlet";
    res.setContentType("text/html");
    out.println("<HTML><HEAD><TITLE>");
    out.println(title);
    out.println("</TITLE></HEAD><BODY>");
    out.println("<H1>" + title + "</H1>");
    out.println("<P> " + x);
    out.println("</BODY></HTML>");

    out.close();
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    doGet(req, res);
  }
}