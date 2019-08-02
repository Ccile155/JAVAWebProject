/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
public class FiltrerCata extends HttpServlet {

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
        
        Recherche r = (Recherche)request.getSession().getAttribute("MaRecherche"); //récupération du bean
        
        ArrayList<Media> ResultatRecherche = (ArrayList) request.getServletContext().getAttribute("catalogue");
        
        if (r.getAuteur().trim().length() != 0){
            ArrayList<Media> c = new ArrayList<>();
            for (Media x: ResultatRecherche){
                if (x.getAuteur().toLowerCase().contains((r.getAuteur().toLowerCase()))){
                    c.add(x);
                }
            }
        ResultatRecherche = c;
        }
        if (r.getTitre().trim().length() != 0){
            ArrayList<Media> c = new ArrayList<>();
            for (Media x: ResultatRecherche){
                if (x.getTitre().toLowerCase().contains((r.getTitre().toLowerCase()))){
                    c.add(x);
                }
            }
        ResultatRecherche = c;
        }

//        PrintWriter out = response.getWriter();
//        for (Media v: ResultatRecherche){
//            if (v instanceof Livre){
//                Livre l = (Livre)v;
//                out.println(l.getTitre()+", "+ l.getAuteur()+", "+ l.getNbpage()+"<br>");
//            }
//            if (v instanceof DVD){
//                DVD d = (DVD)v;
//                out.println(d.getTitre()+", "+ d.getAuteur()+", "+ d.getDuree()+"<br>");
//        }}
        request.getSession().setAttribute("resultat", ResultatRecherche);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
