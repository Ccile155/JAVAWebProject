package Mediatheque;

import java.io.PrintStream;

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
   
}
