/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySqlDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Administrateur
 */
public class InteractionDB extends HttpServlet {
    
    static final String USER = "root";
    static final String password = "";
//    static final String url = "jdbc:mysql://localhost:3306/world?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Paris";
    static final String url = "jdbc:mysql://localhost:3306/mediatheque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String driver = "com.mysql.jdbc.Driver"; // comme ca tout est accessible au début du code pour modif ultérieure
    
    static private InteractionDB idb = null;
    private Connection c;
    
    public Connection getConnection(){return c;}
    
    private InteractionDB() {
        try {
            Class.forName(driver); //chargement explicite du driver
            c = DriverManager.getConnection(url, USER, password);
        } catch (ClassNotFoundException e) { 
            Logger.getLogger(InteractionDB.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) { 
            Logger.getLogger(InteractionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static public InteractionDB getInteractionDB() {
        if (idb == null){
            idb = new InteractionDB();
        }
        return idb;
    }

}
