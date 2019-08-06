/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import Authentification.InscriptionDB;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrateur
 */
public class Inscrire extends HttpServlet {
    
    ServletContext sc;
//    String nomSaisi;
//    Date date ;
//    String emailSaisi;
//    String mdpSaisi ;
//    String mdpSaisi2;
    
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
        response.sendRedirect(sc.getContextPath() + "/Inscription");
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
        String nomSaisi = request.getParameter("nom");
        String dateSaisi = request.getParameter("date");
        String emailSaisi = request.getParameter("email");
        String mdpSaisi = request.getParameter("passwrd");
        String mdpSaisi2 = request.getParameter("passwrd2");
        
        if (mdpSaisi != null && mdpSaisi.equals(mdpSaisi2)){
            if(!(emailSaisi == null && nomSaisi == null)){
                boolean added = InscriptionDB.makeUser(nomSaisi, dateSaisi, emailSaisi, mdpSaisi);
                if(added){
                    session.setAttribute("user", nomSaisi);
//                    response.sendRedirect(sc.getContextPath() + "/Success");
                    sc.getRequestDispatcher("/Success.jsp").forward(request, response);
                }
    //            sc = "this.getServletContext()"
    //            le forward envoie la réponse en mode "return" (d'où la mention unecessary statement)
    //            un include à la place pourrait permettre d'envoyer UNE réponse et de pouvoir la renvoyer après
            } else {
                sc.getRequestDispatcher("/Inscription.jsp").forward(request, response);
    //            sc.getRequestDispatcher("/Connexion").forward(request, response);
            }
        } else {JOptionPane.showMessageDialog(null,"Les mots de passe ne correspondent pas!");
            sc.getRequestDispatcher("/Inscription.jsp").forward(request, response);
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
