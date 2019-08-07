/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification;


import java.sql.Connection;
import MySqlDB.InteractionDB;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class InscriptionDB {
    static public boolean makeUser(String login, String date, String mail, String mdp){
        Connection c = InteractionDB.getInteractionDB().getConnection();
        
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy"); 
//        Date date1 = formatter1.parse(sdate);
//        try{dateNaiss = dateSaisie.parse(date);} catch (Exception e){}

        try{
            Statement stmt = c.createStatement();
            StringBuilder sb = new StringBuilder("INSERT INTO `lecteurs` (`id`, `nom`, `date-naissance`, `email`, `passwrd`) VALUES (NULL, '");
            sb.append(login);
            sb.append("', '");
            sb.append(date);
            sb.append("', '");
            sb.append(mail);
            sb.append("', '");
            sb.append(mdp);
            sb.append("');");
            String requete = sb.toString();
//            ResultSet resultat = stmt.executeQuery(requete);
            int added;
            added = stmt.executeUpdate(requete);
            stmt.close();
            return added == 1;
        }catch (SQLException e){
            Logger.getLogger(InscriptionDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}