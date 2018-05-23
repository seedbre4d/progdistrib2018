import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/send"}, asyncSupported=true)
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        ServletInputStream input = req.getInputStream();
        ServletOutputStream output = res.getOutputStream();
        AsyncContext context = req.startAsync();
        EquationListener listener=new EquationListener(input, context, output);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}
