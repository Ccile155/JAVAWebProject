package Mediatheque;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.PrintStream;
import java.util.Objects;
/**
 *
 * @author Administrateur
 */
public abstract class Media {
    private String titre, auteur;
    
    // constructeur de l'objet
    public Media (String titre, String auteur) throws Exception {
        setTitre(titre);
        setAuteur(auteur);
    }
        
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) throws Exception {
        if (!titre.trim().equals("")){ this.titre = titre.trim();}
        else {throw new Exception("Attention : le titre ne peut être vide.");}
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) throws Exception {
        if (!auteur.trim().equals("")){ this.auteur = auteur.trim();}
        else {throw new Exception("Attention : cette oeuvre a certainement un auteur.");}
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.titre);
        hash = 59 * hash + Objects.hashCode(this.auteur);
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
        final Media other = (Media) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
//        if (!Objects.equals(this.auteur, other.auteur)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return " - " + titre + " de " + auteur ;
    }

    public abstract void Enregistre(PrintStream p);
    
}
