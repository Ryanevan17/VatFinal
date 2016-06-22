/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainlayer;

import java.util.ArrayList;

/**
 *
 * @author jnmkimpton
 */

public class TableCollection {
    
    // ArrayList for TableCollection
    private ArrayList<String> tables; 
    
    public TableCollection()
    {
        this.tables = new ArrayList<>();
    }
    
    /**
     * Add table 
     * 
     * @param table 
     */
    public void addTable(String table) 
    {
        this.tables.add(table);
    }
    
    /**
     * Get arraylist of tables
     * 
     * @return arraylist tables
     */
    public ArrayList<String> getTables() {
        return tables;
    }
    
    /**
     * Get table
     * 
     * @param index
     * @return index of table
     */
    public String getTable(int index) {
        return tables.get(index);
    }
    
    /**
     * Remove table from list 
     * 
     * @param index 
     */
    public void removeTable(int index) {
        tables.remove(index);
    }
    
    public void removeTable(String table) {
        tables.remove(table);
    }
   
    
}