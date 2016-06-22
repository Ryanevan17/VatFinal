/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import datalayer.DatabaseConnection;
import domainlayer.ShapeCollection;
import domainlayer.ShapeFile;
import domainlayer.ShapeType;
import static domainlayer.ShapeType.BLOCK;
import static domainlayer.ShapeType.CONE;
import static domainlayer.ShapeType.CILINDER;
import static domainlayer.ShapeType.SPHERE;
import domainlayer.TableCollection;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import presentationlayer.MainFrame;

/**
 *
 * @author jnmkimpton
 */
public class ShapeIOController {
    
    private MainFrame mainframe;
    private Map<String, JFrame> views;
    private ShapeCollection collection;
    private TableCollection tables;
    
    /** 
     * @param mainframe
     * @param views
     * @param collection 
     */
    public ShapeIOController(MainFrame mainframe, Map<String, JFrame> views, ShapeCollection collection, TableCollection tables) throws Exception {
        this.mainframe = mainframe;
        this.views = views;
        this.collection = collection;
        this.tables = tables;
        
        //Add mainframe listeners
        this.mainframe.addbtnReadDatabase(new ReadDatabase());
        this.mainframe.addbtnSaveToDatabase(new SaveToDatabase(tables));
        this.mainframe.addbtnDeleteTable(new DeleteTable(tables));
        this.mainframe.addListTableCollectionListener(new ListTableListener());
        this.mainframe.addbtnSaveFile(new SaveFile());
        this.mainframe.addbtnReadFile(new ReadFile());
        
        DatabaseConnection dao = new DatabaseConnection();
        dao.getAllTables(tables);
        
        // Refill tablelist
        mainframe.refillTableList(this.tables.getTables().toArray());
    }
   
    
    /**
     * listener for loadtablebutton
     */
    private class ReadDatabase implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();
            Window frame = SwingUtilities.windowForComponent(button);
            String tablename = mainframe.getTableName().trim();

            if(tablename.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Tablename can't be empty.");
            } else {            
                DatabaseConnection dao = new DatabaseConnection();
                try {
                    // Check if DB exists
                    if(dao.tableExists(tablename)) {
                        ArrayList shapes = new ArrayList<>();
                        // Read DB
                        shapes = dao.readDatabase(tablename);
                        if(shapes.size() == 0) {
                            JOptionPane.showMessageDialog(frame, "Table has no shapes.");
                        } else {
                            collection.clearAll();
                            for(Object shape : shapes) {
                                // Split shape
                                String[] split = shape.toString().split("-");
                                // fill item with shape type
                                String item = split[0].trim();
                                switch(item) {
                                    case "Block":
                                        addShape(ShapeType.BLOCK, split[1].trim());
                                        break;
                                    case "Cilinder":
                                        addShape(ShapeType.CILINDER, split[1].trim());
                                        break;
                                    case "Sphere":
                                        addShape(ShapeType.SPHERE, split[1].trim());
                                        break;
                                    case "Cone":
                                        addShape(ShapeType.CONE, split[1].trim());
                                        break;
                                }                        
                            }
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(frame, "Table doesn't exist.");
                    }
                    //dao.readDatabase(tablename);
                } catch (Exception ex) {
                    Logger.getLogger(ShapeIOController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * listener for loadtablebutton
     */
    private class SaveToDatabase implements ActionListener {
        
        private TableCollection tables;
        
        public SaveToDatabase(TableCollection tables) {
            this.tables = tables;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();
            Window frame = SwingUtilities.windowForComponent(button);
            String tablename = mainframe.getTableName().trim();

            if(tablename.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Tablename can not be empty.");
            } else {            
                DatabaseConnection dao = new DatabaseConnection();
                try {
                    // Check if DB exists
                    if(dao.tableExists(tablename)) {
                        // Table name exists
                        JOptionPane.showMessageDialog(frame, "Table already exists.");
                    } else {
                        if(collection.getCounter() == 0) {
                            JOptionPane.showMessageDialog(frame, "No shapes were entered.");
                        } else {
                            // Create table
                            dao.createTable(tablename);
                            tables.addTable(tablename);
                            
                            for(int i = 0; i < collection.getCounter(); i++) {
                                ShapeType type = collection.getShape(i).getType();
                                StringBuilder property = new StringBuilder();
                                switch(type) {
                                    case BLOCK:
                                        property.append(collection.getShape(i).getLength());
                                        property.append(",");
                                        property.append(collection.getShape(i).getWidth());
                                        property.append(",");
                                        property.append(collection.getShape(i).getHeight());  
                                        break;
                                    case CILINDER:
                                        property.append(collection.getShape(i).getRadius());
                                        property.append(",");
                                        property.append(collection.getShape(i).getHeight());
                                        break;
                                    case SPHERE:
                                        property.append(collection.getShape(i).getRadius());
                                        break;
                                    case CONE:
                                        property.append(collection.getShape(i).getRadius());
                                        property.append(",");
                                        property.append(collection.getShape(i).getHeight());
                                        break;
                                }
                                
                                // Insert into table
                                dao.insertRecord(type, property.toString(), tablename);
                            }
                            mainframe.refillTableList(this.tables.getTables().toArray());
                            mainframe.setTableName("");
                            JOptionPane.showMessageDialog(frame, "Shapes succesfully added to table: " + tablename);      
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ShapeIOController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * listener loadtablebutton
     */
    private class DeleteTable implements ActionListener {
        
        private TableCollection tables;
        
        public DeleteTable(TableCollection tables) {
            this.tables = tables;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();
            Window frame = SwingUtilities.windowForComponent(button);
            String tablename = mainframe.getTableName().trim();

            if(tablename.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Tablename can not be empty.");
            } else {            
                DatabaseConnection dao = new DatabaseConnection();
                try {
                    // Check if DB exists
                    if(!dao.tableExists(tablename)) {
                        // Table name exists
                        JOptionPane.showMessageDialog(frame, "Table doesn't exist.");
                    } else {
                        dao.deleteTabel(tablename);
                        // Remove table from list
                        tables.removeTable(tablename);
                        mainframe.refillTableList(this.tables.getTables().toArray());
                        JOptionPane.showMessageDialog(frame, "Table: " + tablename + " deleted.");     
                        mainframe.setTableName("");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ShapeIOController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * listener for listitem
     */
    private class ListTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            int index = mainframe.getSelectedTableListIndex();
            try {
                // Fill table name textfield
                String table = tables.getTable(index);
                mainframe.setTableName(table);            
            }
            catch(IndexOutOfBoundsException iex) {
                // No table selected
            }
        }
    }
    
    public void addShape(ShapeType shape, String property) {
        // Split property
        String[] properties = property.split(",");
        
        // Block l,b,h
        // Cilinder r,h
        // Sphere r
        // Cone r,h
        switch(shape) {
            case BLOCK:
                collection.addShapeBlock(ShapeType.BLOCK, Integer.parseInt(properties[0]), Integer.parseInt(properties[1]), Integer.parseInt(properties[2])); 
                break;
            case CILINDER:
                collection.addShapeCilinder(ShapeType.CILINDER, Integer.parseInt(properties[0]), Integer.parseInt(properties[1]));
                break;
            case SPHERE:
                collection.addShapeSphere(ShapeType.SPHERE, Integer.parseInt(properties[0]));
                break;
            case CONE:
                collection.addShapeCone(ShapeType.CONE, Integer.parseInt(properties[0]), Integer.parseInt(properties[1]));
                break;
 
        }
        mainframe.refillList(collection.getShapes().toArray());
        mainframe.setTotalVolume(collection.getTotalVolume());
    }
    
    /**
     * listener for savefilebutton
     */
    private class SaveFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Create filechooser
            JFileChooser filechooser = new JFileChooser();
            
            // Set a title to dialog
            filechooser.setDialogTitle("Save file");
            
            // Create filefilter 
            FileFilter filter = new FileNameExtensionFilter("TXT file", "txt");
            
            // Only set filefilter to read file
            filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(filter);
 
            // Open dialog box
            int userSelection = filechooser.showSaveDialog(mainframe);
            
            // click to open file
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = filechooser.getSelectedFile();
                
                // Add extension .txt to file
                String path = fileToSave.getAbsolutePath() + ".txt";    
                
                // Check if file exists
                ShapeFile shapefile = new ShapeFile(path);
                JButton button = (JButton) ae.getSource();
                Window frame = SwingUtilities.windowForComponent(button);
                if(shapefile.exists()) {
                    // if exists 
                    JOptionPane.showMessageDialog(frame, "File already exists.");
                } else {               
                    try {
                        shapefile.WriteTextFile(collection);
                        JOptionPane.showMessageDialog(frame, "File saved.");
                    } catch (IOException ex) {
                        Logger.getLogger(ShapeIOController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    /**
     * listener for openfilebutton
     */
    private class ReadFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            // filechooser
            JFileChooser filechooser = new JFileChooser();
            
            // Settitle to dialog
            filechooser.setDialogTitle("Open file");
            
            // Create filefilter 
            FileFilter filter = new FileNameExtensionFilter("TXT file", "txt");
            
            // Set filefilter to read-only
            filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(filter);
 
            // open dialog box
            int userSelection = filechooser.showOpenDialog(mainframe);
            
            // click to open file
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Get selected file
                File fileToOpen = filechooser.getSelectedFile();
                
                ShapeFile shapefile = new ShapeFile(fileToOpen.getAbsolutePath());
                try {
                    collection = shapefile.ReadTextFile();
                    mainframe.refillList(collection.getShapes().toArray());
                    mainframe.setTotalVolume(collection.getTotalVolume());
                } catch (IOException ex) {
                    Logger.getLogger(ShapeIOController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}