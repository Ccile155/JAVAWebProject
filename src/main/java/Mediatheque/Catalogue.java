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
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Administrateur
 */
public class Catalogue extends HttpServlet {
    
    static private ArrayList<Media> liste;
    
    static public ArrayList <Media> get(String urlFichier){
        if (liste == null){
        liste = new ArrayList<>();
        Importe(urlFichier);
        }
        return liste;
    }

    static public void Exporte(ArrayList<Media> catalogue){
        Connection c = InteractionDB.getInteractionDB().getConnection();
        try{
            for (Media m : catalogue){
                Statement stmt = c.createStatement();
                String requete = m.getRequete();
                stmt.executeUpdate(requete);
                stmt.close();
            }
        } catch (SQLException e){
            Logger.getLogger(Catalogue.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    static public ArrayList <Media> get(){
        if (liste == null){
        liste = new ArrayList<>();
        ImporteDB();
        }
        return liste;
    }
    
// IMPORT DEPUIS LA DB
    static public void ImporteDB(){
        liste = Livre.getAll();
        liste.addAll(DVD.getAll());
    }
        
// IMPORT DEPUIS UN FICHIER LOCAL    
    static public void Importe(String urlFichier){
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
                if (!liste.contains(m)) {
                    liste.add(m);
                    }
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
    
}
