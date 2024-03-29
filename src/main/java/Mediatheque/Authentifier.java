/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import Authentification.Authentification;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
public class Authentifier extends HttpServlet {
    ServletContext sc;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
//        try (PrintWriter out = response.getWriter()) {
//            out.println(user);
//        }
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
        sc.getRequestDispatcher("/Connexion").forward(request, response);
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
        String emailSaisi = request.getParameter("email");
        String mdpSaisi = request.getParameter("password");
        
//        request.setAttribute( "user", "Session Invitée" );
        if(emailSaisi != null && mdpSaisi != null){
            String userName = Authentification.isUser(emailSaisi, mdpSaisi);
            if(userName != null){
                session.setAttribute("user", userName);
//                response.sendRedirect(sc.getContextPath() + "/Emprunter");
                sc.getRequestDispatcher("/Success.jsp").forward(request, response);
            } else {
                String err = "Login ou mot de passe invalide.";
                request.setAttribute("error", err);
                sc.getRequestDispatcher("/Connexion").forward(request, response);}
//            sc = "this.getServletContext()"
//            le forward envoie la réponse en mode "return" (d'où la mention unecessary statement)
//            un include à la place pourrait permettre d'envoyer UNE réponse et de pouvoir la renvoyer après
        } else {
                response.sendRedirect(sc.getContextPath() + "/Connexion");
//            sc.getRequestDispatcher("/Connexion").forward(request, response);
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

}
