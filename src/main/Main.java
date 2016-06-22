/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import businesslayer.ShapeController;
import businesslayer.ShapeIOController;
import domainlayer.ShapeCollection;
import domainlayer.TableCollection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import presentationlayer.*;


/**
 *
 * @author jnmkimpton
 */

public class Main {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Create MainFrame view
        MainFrame mainframe = new MainFrame();
        
        // Create other views
        Map<String, JFrame> views = new HashMap<>();
        views = addview(views, mainframe);
        
        // Create shapecollection
        ShapeCollection collection = new ShapeCollection();
        TableCollection tables = new TableCollection();
        
        // Create ShapeController
        new ShapeController(mainframe, views, collection);
        new ShapeIOController(mainframe, views, collection, tables);
        
        // Show mainframe
        mainframe.setVisible(true);
        
    }
    
    /**
     * Create views for other frames
     * 
     * @param views
     * @param mainframe
     * @return views
     */
    private static Map<String, JFrame> addview(Map<String, JFrame> views, MainFrame mainframe) {
        Map<String, JFrame> returnviews = views;
        returnviews.put("Block", new BlockFrame(mainframe));
        returnviews.put("Sphere", new SphereFrame(mainframe));
        returnviews.put("Cilinder", new CilinderFrame(mainframe));
        returnviews.put("Cone", new ConeFrame(mainframe));
        
                
        return returnviews;
    }

    
}