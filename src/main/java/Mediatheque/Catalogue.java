/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    
    static public ArrayList <Media> get(){
        if (liste == null){
        liste = new ArrayList<>();
        Importe();
        }
        return liste;
    }

    static public void Importe(){
    try{
        FileInputStream fis = new FileInputStream("./data/export.csv");
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
