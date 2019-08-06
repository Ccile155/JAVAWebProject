/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification;


import java.sql.Connection;
import MySqlDB.InteractionDB;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class Authentification {
    static public String isUser(String login, String mdp){
        Connection c = InteractionDB.getInteractionDB().getConnection();
        try{
            Statement stmt = c.createStatement();
            String requete = "SELECT nom, email, passwrd FROM lecteurs WHERE email = '"+ login +"' AND passwrd ='"+mdp+"'";
            ResultSet resultat = stmt.executeQuery(requete);
            while (resultat.next()) {
                String userName = resultat.getString("nom");
    //            request.getServletContext().getRequestDispatcher("/Success.jsp").forward(request, response);
    //            int nb = resultat.getInt(1);
                return userName;
            }
        }catch (SQLException e){
            Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
