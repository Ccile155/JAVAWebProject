/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediatheque;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;


/**
 *
 * @author Administrateur
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");
        ArrayList<Media> liste  = Catalogue.get();
        servletContextEvent.getServletContext().setAttribute("catalogue", liste);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}
