import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "Simple", urlPatterns = {"/Simple})"})

public class Simple extends GenericServlet {
    
    @Override
    public void service(ServletRequest req, ServletResponse resp)
    throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.println("Hello la servlet générique.");
    }
}

