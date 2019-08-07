package Mediatheque;

import MySqlDB.InteractionDB;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
public class Livre extends Media {
    
    public Livre() throws Exception{
        super ("Titre", "auteur");
    }
    
    private String nbpage;
    
    public Livre (String titre, String auteur, String nbpage) throws Exception{
        super(titre, auteur);
        setNbpage(nbpage);
    }

    public String getNbpage() {
        return nbpage;
    }

    public void setNbpage(String nbpage) throws Exception {
        if (!nbpage.trim().equals("p")){ this.nbpage = nbpage.trim();}
        else {throw new Exception("Veuillez renseigner le nombre de pages.");}
    }

    @Override
    public String getRequete() {
        //@TODO mettre nom de table en paramètre
        StringBuilder sb = new StringBuilder("INSERT INTO `livre` (`titre`, `auteur`, `nbpage`, `lecteur`, `dateEmprunt`)");
        sb.append("VALUES ('");
        sb.append(getTitre());
        sb.append("', '");
        sb.append(getAuteur());
        sb.append("', '");
        sb.append(getNbpage());
        sb.append("', NULL, NULL)");
        return sb.toString();
    }

    public static ArrayList<Media> getAll(){
        ArrayList<Media> table = new ArrayList<>();
        try{
        Connection c = InteractionDB.getInteractionDB().getConnection();
            Statement stmt = c.createStatement();
            String requete = "SELECT `titre`, `auteur`, `nbpage` FROM `livre`";
            ResultSet resultat = stmt.executeQuery(requete);
            while (resultat.next()){
                try{
                    Media m = new Livre (resultat.getString(1), resultat.getString(2), resultat.getString(3));
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
        StringBuilder sb = new StringBuilder(this.getTitre());
        sb.append(" de ");
        sb.append(this.getAuteur());
        sb.append(", ");
        sb.append(this.getNbpage());
        return sb.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Enregistre(PrintStream p) {
        StringBuilder sb = new StringBuilder(getTitre());
        sb.append("; ");
        sb.append(getAuteur());
        sb.append("; ");
        sb.append(nbpage);
        p.println(sb.toString());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livre other = (Livre) obj;
        if (!Objects.equals(this.nbpage, other.nbpage)) {
            return false;
        }
        return true;
    }
   
}
