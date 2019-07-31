
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "Counter", urlPatterns = {"/Counter"})
public class Counter extends HttpServlet {
    int NombreAcces;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter p = resp.getWriter();
        NombreAcces++;
        p.println("<HTML>");
        p.println("<HEAD>");
        p.println("<TITLE>Life Cycle Servlet</TITLE>");
        p.println("</HEAD><BODY style='background-color:SteelBlue; text-align:center;'>");
        p.println("<h1> On l'a dans le get</h1>");
        p.println("<p style='color:MistyRose;'>"+ NombreAcces +" fois.<p>");
        p.println("</BODY></HTML>");
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try{
            File r = new File("./data/counter.dat");
            DataInputStream ds = new DataInputStream(new FileInputStream(r));
            NombreAcces = ds.readInt();
            ds.close();
            }
            catch (FileNotFoundException e) {
            // Handle error
            } catch (IOException e) {
            // This should be logged
            }
    }

    @Override
    public void destroy() {
        File r = new File("./data/counter.dat");
        try{
            DataOutputStream dout = new DataOutputStream(new FileOutputStream(r));
            dout.writeInt(NombreAcces);
            dout.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            super.destroy();
        }
        
    }
    
}
