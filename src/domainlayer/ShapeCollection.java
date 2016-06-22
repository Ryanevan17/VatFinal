/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainlayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jnmkimpton
 */

public class ShapeCollection implements Serializable {
    
    // ArrayList for ShapeCollection
    private ArrayList<Shape> shapes; 
    
    // save total volume
    private double totalvolume;
    
    
    public ShapeCollection()
    {
        this.shapes = new ArrayList<>();
        totalvolume = 0.00;
    }
    
    /**
     * Add shape 
     * 
     * @param shapes 
     */
    public void addShape(Shape... shapes) 
    {
        this.shapes.addAll(Arrays.asList(shapes));
        calculateTotalVolume(this.shapes);
    }
    
    /**
     * Calculate total volume of all shapes
     * 
     * @param shapes 
     */
    private void calculateTotalVolume(ArrayList<Shape> shapes) {
        totalvolume = 0.00;
        for (Shape shape : shapes) {
            totalvolume += shape.getVolume();
        }
    }
    
    /**
     * Add block to list
     * 
     * @param type
     * @param l the length
     * @param w the width
     * @param h the height
     */
    public void addShapeBlock(ShapeType type, int l, int w, int h) {
        switch (type) {
            case BLOCK:
                addShape(new Block(l, w, h));
                break;
        }
    }
    
    /**
     * Add sphere to list
     * 
     * @param type
     * @param r the radius
     */
    public void addShapeSphere(ShapeType type, int r) {
        switch (type) {
            case SPHERE:
                addShape(new Sphere(r));
                break;
        }
    }
    
    /**
     * Add cilinder to list
     * 
     * @param type
     * @param h the height
     * @param r the radius
     */
    public void addShapeCilinder(ShapeType type, int h, int r) {
        switch (type) {
            case CILINDER:
                addShape(new Cilinder(h, r));
                break;
        }
    }
    
    /**
     * Add cone to list
     * 
     * @param type
     * @param h the height
     * @param r the radius
     */
    public void addShapeCone(ShapeType type, int h, int r) {
        switch (type) {
            case CONE:
                addShape(new Cone(h, r));
                break;
        }
    }
    
    
    /**
     * Get arraylist of shapes
     * 
     * @return arraylist shapes
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }
    
    /**
     * Get total volume of all shapes
     * 
     * @return total volume
     */
    public double getTotalVolume() {
        return totalvolume;
    }
    
    /**
     * Get shape
     * 
     * @param index
     * @return index of shape
     */
    public Shape getShape(int index) {
        return shapes.get(index);
    }
    
    /**
     * Remove shape from list
     * 
     * @param index 
     */
    public void removeShape(int index) {
        shapes.remove(index);
        calculateTotalVolume(shapes);
    }
    
    /**
     * Remove all shapes
     */
    public void clearAll() {
        shapes.clear();
        calculateTotalVolume(shapes);
    }
    
    /**
     * Count size of list
     * 
     * @return size
     */
    public int getCounter() {
        return shapes.size();
    }
}