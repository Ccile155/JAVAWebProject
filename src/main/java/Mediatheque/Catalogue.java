/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import MySqlDB.InteractionDB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class Catalogue {
    
    static private ArrayList<Media> liste, myFile;
     
    static public ArrayList <Media> get(String urlFichier){
        LireCSV(urlFichier);
        return myFile;
    }

    // IMPORT DEPUIS UN FICHIER LOCAL    
    static public void LireCSV(String urlFichier){
        if (myFile == null){
            myFile = new ArrayList<>();
        }
        try{
            FileInputStream fis = new FileInputStream(urlFichier);
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
                        m = new DVD(table[0], table[1], table[2]);
                    }
                    myFile.add(m);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                } 
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static public int EcrireDB(ArrayList<Media> catalogue){
        Connection c = InteractionDB.getInteractionDB().getConnection();
        try{
            for (Media m : catalogue){
                if (!liste.contains(m)) {
                    Statement stmt = c.createStatement();
                    String requete = m.getRequete();
                    stmt.executeUpdate(requete);
                    int updateCount = stmt.executeUpdate(requete);
                    stmt.close();
                    return updateCount;
                }
            }
        } catch (SQLException e){
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
// IMPORT DEPUIS LA DB
    static public void LireDB(){
        liste = Livre.getAll();
        liste.addAll(DVD.getAll());
    }
    
    static public ArrayList <Media> get(){
        if (liste == null){
            liste = new ArrayList<>();
            LireDB();
        }
        return liste;
    }   
}
