/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class Saisie {

    static ArrayList<Media> liste;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        liste = new ArrayList<>();
        Importe();
        System.out.println("Catalogue importé");
        for (Media l : liste){ System.out.println(l);}
        
        String titre="";
        String auteur="";
        String param= "";
        
        Scanner sc = new Scanner(System.in);      
                
        System.out.println("Enregistrez une oeuvre: (F pour finir)");
        System.out.println("Livre: Titre, Auteur, [nombre de pages]p");
        System.out.println("DVD: Titre, Auteur, [durée en minutes]min");
        String entree = sc.nextLine();
   
        while(!(entree.toUpperCase().equals("F"))){
            try{
                if (!(entree.contains(","))){ System.out.println("Cette entrée n'est pas valide."); }
                else{    
                    String[] parts = entree.split(",");
                    titre = parts[0]; 
                    auteur = parts[1];
                    param = parts[2];
                }
                
                boolean type;
                    if(type = param.endsWith("p")){
                        Livre l1 = new Livre(titre, auteur, param);
                        if (!liste.contains(l1)){ liste.add(l1);} 
                        else { System.out.println("Ce livre est déjà enregistré."); } 
                        
                    } else if((type = param.endsWith("min")) || (type = param.endsWith("m"))){
                        DVD d1 = new DVD(titre, auteur, param); 
                        if (!liste.contains(d1)){ liste.add(d1);} 
                        else { System.out.println("Ce DVD existe déjà."); }
                        
                    } else {System.out.println("La fin de votre entrée n'est pas claire : livre ou DVD ?");}
                
            }
            catch (NullPointerException e){
                    System.out.println("Au moins un champ est vide");
            }
            catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Attention : cette entrée n'est pas valide.");
            }
            catch (Exception e){
                    System.out.println(e.getMessage());
            }

            System.out.println("Titre, Auteur, pages(p)/durée(min) : (F pour finir)");
            entree = sc.nextLine();
        }
        if (liste.size() > 0){
            System.out.println("       ~~~ Merci de vorte contribution ~~~");
            System.out.println("Notre médiathèque comporte les titres suivants : ");
            for (Media item : liste) {
                System.out.println(item);
            }
            Exporte();
        } else { System.out.println("Pas de nouvel enregistrement.");}
        
    }
    
    static public void Exporte(){
        try{
            FileOutputStream fos = new FileOutputStream("export.csv");
            PrintStream ps = new PrintStream(fos);
            for (Media m : liste){
                m.Enregistre(ps);
            }
            ps.close();
            fos.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex); 
         } catch (IOException e){
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, e); 
        } catch (NullPointerException e){
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, e); 
        }
    }
    
    static public void Importe(){
    try{
        FileInputStream fis = new FileInputStream("export.csv");
        Scanner sc = new Scanner(fis);
        String ligne;
        while(sc.hasNextLine()){
            ligne = sc.nextLine();
            String[] table = ligne.split(";");
            if(table.length == 0){continue;}
            
            try{
                Media m ;
                if (table[2].endsWith("p")) {
                    m = new Livre(table[0], table[1], table[2]);
                } else {
                    m = new DVD (table[0], table[1], table[2]);
                }
                if (!liste.contains(m)) {
                    liste.add(m);
                    }
            } catch (Exception e){
                System.out.println(e.getMessage());
            } 
        }
        fis.close();   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Saisie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
