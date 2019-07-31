/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import java.io.PrintStream;

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
