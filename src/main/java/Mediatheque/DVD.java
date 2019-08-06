/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import MySqlDB.InteractionDB;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class DVD extends Media {
    
    public DVD() throws Exception{
        super ("Titre", "auteur");
    }
    
    private String duree;
    public DVD(String titre, String auteur, String duree) throws Exception{
        super(titre, auteur);
        setDuree(duree);
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) throws Exception {
        if ((duree.trim().equals("min")) || (duree.trim().equals("m"))){
            throw new Exception("Veuillez renseigner la durée en min.");}
        else {this.duree = duree.trim();}
    }

    @Override
    public String getRequete() {
        //@TODO mettre nom de table en paramètre
        StringBuilder sb = new StringBuilder("INSERT INTO `dvd` (`titre`, `auteur`, `duree`, `lecteur`, `dateEmprunt`)");
        sb.append("VALUES ('");
        sb.append(getTitre());
        sb.append("', '");
        sb.append(getAuteur());
        sb.append("', '");
        sb.append(getDuree());
        sb.append("', , )");
        return sb.toString();
    }
    
    public static ArrayList<Media> getAll(){
        ArrayList<Media> table = new ArrayList<>();
        try{
        Connection c = InteractionDB.getInteractionDB().getConnection();
            Statement stmt = c.createStatement();
            String requete = "SELECT `titre`, `auteur`, `duree` FROM `dvd`";
            ResultSet resultat = stmt.executeQuery(requete);
            while (resultat.next()){
                try{
                    Media m = new DVD (resultat.getString("titre"), resultat.getString("auteur"), resultat.getString("duree"));
                    if (!table.contains(m)) {table.add(m);}
                    } catch (Exception e){System.out.println(e.getMessage());}
            }
        } catch (SQLException e){
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, e);
        }
        return table;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getTitre()); // ici, dans la classe nom = this.nom
        sb.append(" de ");
        sb.append(this.getAuteur());
        sb.append(", ");
        sb.append(this.getDuree());
        return sb.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Enregistre(PrintStream p) {
        StringBuilder sb = new StringBuilder(getTitre());
        sb.append("; ");
        sb.append(getAuteur());
        sb.append("; ");
        sb.append(duree);
        p.println(sb.toString());
    }
}
