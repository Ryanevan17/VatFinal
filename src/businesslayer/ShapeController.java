/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import domainlayer.ShapeCollection;
import domainlayer.ShapeType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import presentationlayer.BlockFrame;
import presentationlayer.CilinderFrame;
import presentationlayer.ConeFrame;
import presentationlayer.MainFrame;
import presentationlayer.SphereFrame;

/**
 *
 * @author jnmkimpton
 */

public class ShapeController {
    
    private MainFrame mainframe;
    private Map<String, JFrame> views;
    private ShapeCollection collection;
    
    /**
     * 
     * @param mainframe
     * @param views
     * @param collection 
     */
    public ShapeController(MainFrame mainframe, Map<String, JFrame> views, ShapeCollection collection) {
        this.mainframe = mainframe;
        this.views = views;
        this.collection = collection;

        //Add mainframe listeners
        this.mainframe.addbtnDeleteCollectionListener(new DeleteCollectionListener());
        this.mainframe.addbtnDeleteShapeListener(new DeleteShapeListener());
        this.mainframe.addbtnAddListener(new AddListener());
        this.mainframe.addListShapeCollectionListener(new ListSCListener());
        
        //Refill list
        mainframe.refillList(this.collection.getShapes().toArray());

        // Add listeners blockframe
        BlockFrame blockframe = (BlockFrame) this.views.get("Block");
        blockframe.addbtnCancelListener(new CancelListener());
        blockframe.addbtnAddShapeListener(new AddShapeListener());
        
        // Add listeners sphereframe
        SphereFrame sphereframe = (SphereFrame) this.views.get("Sphere");
        sphereframe.addbtnCancelListener(new CancelListener());
        sphereframe.addbtnAddShapeListener(new AddShapeListener());

        // Add listeners cilinderframe
        CilinderFrame cilinderframe = (CilinderFrame) this.views.get("Cilinder");
        cilinderframe.addbtnCancelListener(new CancelListener());
        cilinderframe.addbtnAddShapeListener(new AddShapeListener());
        
        // Add listenersconeframe
        ConeFrame coneframe = (ConeFrame) this.views.get("Cone");
        coneframe.addbtnCancelListener(new CancelListener());
        coneframe.addbtnAddShapeListener(new AddShapeListener());
         
    }
    
    /**
     * listener delete collectionbutton
     */
    private class DeleteCollectionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            collection.clearAll();
            mainframe.refillList(collection.getShapes().toArray());
            mainframe.setTotalVolume(collection.getTotalVolume());
        }
    }
    
    /**
     * listener delete shapebutton
     */
    private class DeleteShapeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            collection.removeShape(mainframe.getSelectedListIndex());
            mainframe.refillList(collection.getShapes().toArray());
            mainframe.setTotalVolume(collection.getTotalVolume());
        }
    }
    
    /**
     * listener for listitem
     */
    private class ListSCListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            int index = mainframe.getSelectedListIndex();
            try {
                ShapeType type = collection.getShape(index).getType();
                int height = collection.getShape(index).getHeight();
                int width = collection.getShape(index).getWidth();
                int length = collection.getShape(index).getLength();
                int radius = collection.getShape(index).getRadius();
                double volume = collection.getShape(index).getVolume();
                mainframe.setShape(type);
                mainframe.setHeight(height);
                mainframe.setWidth(width);
                mainframe.setLength(length);
                mainframe.setRadius(radius);
                mainframe.setVolume(volume);
            }
            catch(IndexOutOfBoundsException iex) {
                // No item selected
            }
        }
    }
    
    /**
     * listener for addbutton 
     */
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (mainframe.getSelectedShapeDropdownValue()) {
                case BLOCK:
                    views.get("Block").setVisible(true);
                    mainframe.setEnabled(false);
                    break;
                case SPHERE:
                    views.get("Sphere").setVisible(true);
                    mainframe.setEnabled(false);
                    break;
                case CILINDER:
                    views.get("Cilinder").setVisible(true);
                    mainframe.setEnabled(false);
                    break; 
                case CONE:
                    views.get("Cone").setVisible(true);
                    mainframe.setEnabled(false);
                    break;
               
            }
        }
    }
    
    /**
     * listener for cancelbutton
     */
    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource(); 
            Window frame = SwingUtilities.windowForComponent(button); 
            frame.dispose();
            mainframe.setEnabled(true);
        }
    }
    
    /**
     * listener for addbutton
     */
    private class AddShapeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();
            Window frame = SwingUtilities.windowForComponent(button);
            try { 
                switch (button.getName()) {
                    case "Block":
                        BlockFrame blockframe = (BlockFrame) views.get("Block");
                        int blength = blockframe.getLengthValue();
                        int bwidth = blockframe.getWidthValue();
                        int bheight = blockframe.getHeightValue();
                        collection.addShapeBlock(ShapeType.BLOCK, blength, bwidth, bheight);  
                        blockframe.setEmptyValue();
                        break;
                    case "Sphere":
                        SphereFrame sphereframe = (SphereFrame) views.get("Sphere");
                        int sradius = sphereframe.getRadiusValue();
                        collection.addShapeSphere(ShapeType.SPHERE, sradius);
                        sphereframe.setEmptyValue();
                        break;
                    case "Cilinder":
                        CilinderFrame cilinderframe = (CilinderFrame) views.get("Cilinder");
                        int cheight = cilinderframe.getHeightValue();
                        int cradius = cilinderframe.getRadiusValue();
                        collection.addShapeCilinder(ShapeType.CILINDER, cheight, cradius);
                        cilinderframe.setEmptyValue();
                        break;
                    case "Cone":
                        ConeFrame coneframe = (ConeFrame) views.get("Cone");
                        int coneheight = coneframe.getHeightValue();
                        int coneradius = coneframe.getRadiusValue();
                        collection.addShapeCone(ShapeType.CONE, coneheight, coneradius);
                        coneframe.setEmptyValue();
                        break;
                    
                }
                mainframe.refillList(collection.getShapes().toArray());
                mainframe.setTotalVolume(collection.getTotalVolume());
                frame.dispose();
            } catch (Exception ex) {    
                JOptionPane.showMessageDialog(frame, "Unknown error occured");
            }
            mainframe.setEnabled(true);
        }
    }
    
    
}