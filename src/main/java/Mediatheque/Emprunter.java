/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "Emprunter", urlPatterns = {"/Emprunter"})
public class Emprunter extends HttpServlet {
    ArrayList <Media> liste = new ArrayList<>();
    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        liste = new ArrayList<>();
//        Importe();
        sc = config.getServletContext();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String id = (String) session.getAttribute("id");
        if (id == null){
//            response.sendRedirect(sc.getContextPath()+"/Connexion.html");
            sc.getRequestDispatcher("/Connexion").forward(request, response);
        }
//        
//        ArrayList <Media> table = new ArrayList<>();
//        for (Media x : liste) {
//            table.add(x);
//            request.setAttribute("media", table);
//        }
//        this.getServletContext().getRequestDispatcher("/Emprunt.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String id = (String) session.getAttribute("id");
        if (id == null){
            sc.getRequestDispatcher("/Connexion").forward(request, response);
            return;
        } else {
            sc.getRequestDispatcher("/Emprunt.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

//    public void Importe(){
//    try{
//        FileInputStream fis = new FileInputStream("./data/export.csv");
//        Scanner sc = new Scanner(fis);
//        String ligne;
//        while(sc.hasNextLine()){
//            ligne = sc.nextLine();
//            String[] table = ligne.split(";");
//            if(table.length == 0){continue;}
//            
//            try{
//                Media m ;
//                if (table[2].endsWith("p")) {
//                    m = new Livre(table[0], table[1], table[2]);
//                } else {
//                    m = new DVD(table[0], table[1], table[2]);
//                }
//                if (!liste.contains(m)) {
//                    liste.add(m);
//                    }
//            } catch (Exception e){
//                System.out.println(e.getMessage());
//            } 
//        }
//        fis.close();   
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
